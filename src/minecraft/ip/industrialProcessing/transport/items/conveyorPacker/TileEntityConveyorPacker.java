package ip.industrialProcessing.transport.items.conveyorPacker;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import ip.industrialProcessing.machines.plants.storage.storageBox.BlockStorageBox;
import ip.industrialProcessing.machines.plants.storage.storageRack.TileEntityStorageRack;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorPowerTranslation;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import ip.industrialProcessing.utils.nbt.NbtHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorPacker extends TileEntityConveyorPowerTranslation implements IStateConfig, IMachineContainerEntity, ISidedInventory {

    private static int tickOffset;
    ItemStack[] slots = new ItemStack[1 + BlockStorageBox.STORAGE_SIZE];
    private PackerOperationMode operationMode = PackerOperationMode.PACK_FULL;
    private int updateCycle = 20;
    private int ticks = 0;
    private LocalDirection boxInput = LocalDirection.LEFT;
    private LocalDirection boxOutput = LocalDirection.RIGHT;

    private boolean boxAllowedOnConveyor = true;

    public boolean isBoxAllowedOnConveyor() {
        return boxAllowedOnConveyor;
    }

    public void setBoxAllowedOnConveyor(boolean boxAllowedOnConveyor) {
        this.boxAllowedOnConveyor = boxAllowedOnConveyor;
    }

    // 0: box slot
    // 1-9: Config

    public TileEntityConveyorPacker() {
        this.setConnectionMode(LocalDirection.LEFT, ConnectionMode.NONE);
        this.setConnectionMode(LocalDirection.RIGHT, ConnectionMode.NONE);
        this.setConnectionMode(LocalDirection.UP, ConnectionMode.NONE);
        this.setConnectionMode(LocalDirection.DOWN, ConnectionMode.NONE);
        this.ticks = (tickOffset++ % updateCycle);
        this.setButtonState(1, 1);
    }

    @Override
    public void toggleSlope(EntityPlayer player) {
        int index = operationMode.ordinal();
        index++;
        while (index >= 4) {
            index -= 4;
            boxAllowedOnConveyor = !boxAllowedOnConveyor;
        }
        operationMode = PackerOperationMode.values()[index];

        String mode;
        switch (operationMode) {
        case PACK_ANY:
            mode = "Pack all items";
            break;
        case PACK_FULL:
            mode = "Pack untill box completly full";
            break;
        case PASS_THROUGH:
            mode = "Pass through";
            break;
        default:
            mode = "Unpack boxes";
            break;
        }

        int i2 = 1 + index + (boxAllowedOnConveyor ? 4 : 0);
        if (!worldObj.isRemote)
            player.sendChatToPlayer(ChatMessageComponent.createFromText(i2 + "/8: " + mode + ", " + (boxAllowedOnConveyor ? "boxes allowed on conveyor" : "boxes not allowed on conveyor") + "."));
    }

    public PackerOperationMode getOperationMode() {
        return operationMode;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            if (ticks++ > updateCycle) {
                ticks = 0;
                if (operationMode == PackerOperationMode.UNPACK) {
                    extractFromBox();
                } else {
                    checkBox();
                    if (operationMode == PackerOperationMode.PASS_THROUGH)
                        ejectBox();
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (operationMode != null)
            nbt.setInteger("Mode", operationMode.ordinal());
        NbtHelper.writeInventory(this.slots, nbt);
        nbt.setBoolean("ConveyorBox", boxAllowedOnConveyor);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("Mode"))
            operationMode = PackerOperationMode.values()[nbt.getInteger("Mode")];
        NbtHelper.readInventory(this.slots, nbt);
        if (nbt.hasKey("ConveyorBox"))
            boxAllowedOnConveyor = nbt.getBoolean("ConveyorBox");
    }

    private void checkBox() {
        if (this.slots[0] == null)
            fetchBox();
    }

    private void extractFromBox() {
        ItemStack box = slots[0];
        if (box != null && box.itemID == IndustrialProcessing.blockStorageBox.blockID) {
            boolean hasExtracted = false;
            for (int i = 0; i < BlockStorageBox.STORAGE_SIZE; i++) {
                ItemStack stack = IndustrialProcessing.blockStorageBox.peekStackFromBox(box, i);
                if (stack != null) {
                    ItemStack configStack = slots[i + 1];
                    if (configStack == null || configStack.isItemEqual(stack)) {
                        // only fetch configged items!
                        stack = IndustrialProcessing.blockStorageBox.getStackFromBox(box, i, 8);
                        MovingItemStack movingStack = this.addItemStack(stack, null);
                        // this stack can not be used anymore, don't allow it to
                        // get routed back into the slot.
                        movingStack.routed = true;
                        hasExtracted = true;
                        onInventoryChanged();
                        break;
                    }
                }
            }
            if (!hasExtracted) {
                ejectBox();
            }
        } else {
            fetchBox();
        }
    }

    private void fetchBox() {
        if (slots[0] == null) {
            ForgeDirection left = DirectionUtils.getWorldDirection(boxInput, this.forwardDirection);
            TileEntity te = this.worldObj.getBlockTileEntity(xCoord + left.offsetX, yCoord + left.offsetY, zCoord + left.offsetZ);
            if (te instanceof TileEntityStorageRack) {
                TileEntityStorageRack rack = (TileEntityStorageRack) te;
                ItemStack box = rack.popBox();
                if (box != null) {
                    slots[0] = box;
                    onInventoryChanged();
                }
            }
        }
    }

    private void ejectBox() {
        if (slots[0] != null) {
            ForgeDirection left = DirectionUtils.getWorldDirection(boxOutput, this.forwardDirection);
            TileEntity te = this.worldObj.getBlockTileEntity(xCoord + left.offsetX, yCoord + left.offsetY, zCoord + left.offsetZ);
            if (te instanceof TileEntityStorageRack) {
                TileEntityStorageRack rack = (TileEntityStorageRack) te;
                if (rack.pushBox(slots[0])) {
                    slots[0] = null;
                    onInventoryChanged();
                    return;
                }
            }
            if (boxAllowedOnConveyor) {
                MovingItemStack stack = this.addItemStack(slots[0], null);
                // this stack can not be used anymore, don't allow it to get
                // routed back into the slot.
                stack.routed = true;
                slots[0] = null;
                onInventoryChanged();
                return;
            }
        }
    }

    @Override
    protected void rerouteStack(MovingItemStack stack) {
        if (boxAllowedOnConveyor && stack.stack != null && stack.stack.itemID == IndustrialProcessing.blockStorageBox.blockID) {
            if (slots[0] == null) {
                ItemStack oneBox = stack.stack.splitStack(1);
                slots[0] = oneBox;
                if (stack.stack == null || stack.stack.stackSize == 0)
                    this.itemStacks.remove(stack);
                onInventoryChanged();
                syncConveyor();
                stack.routed = true;
                return;
            }
        }
        if (operationMode == PackerOperationMode.PACK_ANY || operationMode == operationMode.PACK_FULL) {
            ItemStack box = slots[0];
            if (box != null && box.itemID == IndustrialProcessing.blockStorageBox.blockID && stack.stack != null) {
                boolean packed = false;
                boolean accepted = false;
                for (int cI = 1; cI < slots.length; cI++) {
                    int bI = cI - 1;
                    ItemStack configSlot = slots[cI];
                    if (configSlot == null || configSlot.isItemEqual(stack.stack)) {
                        accepted = true;
                        ItemStack rest = putItemInBox(stack.stack, box, bI);
                        if (rest == null || rest.stackSize <= 0) {
                            packed = true;
                            if (this.itemStacks.remove(stack)) {
                                this.syncConveyor();
                                break;
                            }
                        } else {
                            if (rest.stackSize != stack.stack.stackSize) {
                                packed = true;
                                stack.stack = rest;
                                this.syncConveyor();
                            }
                        }
                        onInventoryChanged();
                    }
                }
                if (accepted && !packed) {
                    // box might be full?!
                    if (operationMode == PackerOperationMode.PACK_ANY)
                        ejectBox();
                    else if (operationMode == PackerOperationMode.PACK_FULL)
                        if (isBoxFull())
                            ejectBox();
                }
            }
        }
        stack.routed = true;
    }

    private boolean isBoxFull() {
        ItemStack box = slots[0];
        if (box == null) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            ItemStack peek = IndustrialProcessing.blockStorageBox.peekStackFromBox(box, i);
            if (peek == null || peek.stackSize < peek.getMaxStackSize())
                // stack can still grow, GO FOR IT
                return false;
        }
        return true;
    }

    private ItemStack putItemInBox(ItemStack stack, ItemStack box, int slot) {
        return IndustrialProcessing.blockStorageBox.putStackInBox(stack, box, slot);
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        if (i >= slots.length)
            return null;
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {

        if (i >= slots.length)
            return null;

        ItemStack stack = slots[i];
        if (stack == null)
            return null;

        if (stack.stackSize > j) {
            stack = stack.splitStack(j);
            onInventoryChanged();
            return stack;
        }
        slots[i] = null;
        onInventoryChanged();
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return getStackInSlot(i);
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
        if (slotIndex > getSizeInventory())
            return;
        if (slotIndex > 0) {
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
            }
        } else {
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
            }
        }
        slots[slotIndex] = stack;
        onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "packer";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return !((i == 0) ^ (itemstack != null && itemstack.itemID == IndustrialProcessing.blockStorageBox.blockID));
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int size) {
        return false;
    }

    // shouldn't get called, outputs are disabled.
    @Override
    protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
        return stack.stack;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[0];
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public int getStateValue(int index) {
        switch (index) {
        case 0:
            return this.operationMode.ordinal();
        case 1:
            return this.boxAllowedOnConveyor ? 1 : 0;
        default:
            return 0;
        }
    }

    @Override
    public void setStateValue(int index, int value) {
        switch (index) {
        case 0:
            this.operationMode = PackerOperationMode.values()[value];
            System.out.println("OPMODE:" + this.operationMode);
            break;
        case 1:
            this.boxAllowedOnConveyor = value > 0;
            System.out.println("boxes:" + this.boxAllowedOnConveyor);
            break;
        default:
            break;
        }
    }

    @Override
    public int getMaxStateValue(int index) {
        switch (index) {
        case 0:
            return 3; // 4 modes: 0,1,2,3
        case 1:
            return 1;
        default:
            return 0;
        }
    }

    @Override
    public int getMinStateValue(int index) {
        return 0;
    }

    @Override
    public int getStateCount() { 
        return 2;
    }
}
