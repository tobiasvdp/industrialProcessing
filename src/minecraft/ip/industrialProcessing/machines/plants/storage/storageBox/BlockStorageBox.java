package ip.industrialProcessing.machines.plants.storage.storageBox;

import java.util.ArrayList;
import java.util.Random;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.machines.plants.storage.storageRack.TileEntityStorageRack;
import ip.industrialProcessing.utils.IDescriptionBlock;
import ip.industrialProcessing.utils.ItemTransfers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockStorageBox extends BlockMachineRendered implements IDescriptionBlock, IGuiLayout {
    public static GuiLayout guiLayout;
    public static final int STORAGE_SIZE = 9;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.vertical, STORAGE_SIZE);
    }
    private Icon[] icons = new Icon[1];

    public BlockStorageBox() {
	super(ConfigMachineBlocks.getBlockStorageBoxID(), Material.iron, 1F, Block.soundMetalFootstep, "BlockStorageBox", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
	if (par1World.isBlockSolidOnSide(x, y - 1, z, ForgeDirection.UP))
	    return super.canPlaceBlockAt(par1World, x, y, z);
	return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
	ItemStack nbtLoadedStack = new ItemStack(this);
	nbtLoadedStack.stackTagCompound = new NBTTagCompound();
	nbtLoadedStack.getItem().setMaxStackSize(1);
	TileEntityStorageBox box = (TileEntityStorageBox) world.getBlockTileEntity(x, y, z);
	for (int i = 0; i < box.getSizeInventory(); i++) {
	    putStackInBox(box.getStackInSlot(i), nbtLoadedStack, i);
	}
	Random random = new Random();
	ItemTransfers.launch(nbtLoadedStack, world, x, y, z, random.nextFloat() / 4, random.nextFloat() / 4, random.nextFloat() / 4);
	if (hasTileEntity(par6) && !(this instanceof BlockContainer)) {
	    world.removeBlockTileEntity(x, y, z);
	}
	world.removeBlockTileEntity(x, y, z);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	if (itemStack.stackTagCompound != null) {
	    TileEntityStorageBox te = (TileEntityStorageBox) world.getBlockTileEntity(x, y, z);
	    for (int i = 0; i < te.getSizeInventory(); i++) {
		ItemStack stack = getStackFromBox(itemStack, i, 64);
		if (stack != null) {
		    te.setInventorySlotContents(i, stack);
		}
	    }
	}
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
	return new ArrayList<ItemStack>();
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityStorageBox te = new TileEntityStorageBox();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererStorageBox();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockBox");
    }

    @Override
    public String getDescription() {
	return "Storage boxes can be stored in racks.";
    }

    @Override
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
	int l = ((IRotateableEntity) par1World.getBlockTileEntity(par2, par3, par4)).getForwardDirection().ordinal();
	if (l == 2) {
	    this.setBlockBounds(0.17F, 0.0F, 0.32F, 0.83F, 0.23F, 0.68F);
	} else if (l == 3) {
	    this.setBlockBounds(0.17F, 0.0F, 0.32F, 0.83F, 0.23F, 0.68F);
	} else if (l == 4) {
	    this.setBlockBounds(0.32F, 0.0F, 0.17F, 0.68F, 0.23F, 0.83F);
	} else if (l == 5) {
	    this.setBlockBounds(0.32F, 0.0F, 0.17F, 0.68F, 0.23F, 0.83F);
	}

	return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }

    public ItemStack putStackInBox(ItemStack stack, ItemStack box, int slot) {
	if (box.itemID == this.blockID && slot >= 0 && slot < STORAGE_SIZE && stack != null && stack.itemID != this.blockID) {
	    if (box.stackTagCompound == null)
		box.setTagCompound(new NBTTagCompound());
	    ItemStack slotStack = getStackInSlot(box, slot);
	    if (slotStack == null) {
		slotStack = stack;
		if (stack.stackSize > 0) {
		    if (!setStackInSlot(box, slot, slotStack)) {
			// adding failed for some weird nbt reason
			return stack;
		    }
		}
		if (stack.stackSize <= 0)
		    stack = null;
	    } else if (slotStack.isItemEqual(stack)) {
		if (slotStack.stackSize < slotStack.getMaxStackSize()) {
		    int transferCount = slotStack.getMaxStackSize() - slotStack.stackSize;
		    transferCount = Math.min(transferCount, stack.stackSize);
		    ItemStack originalStack = stack.copy();
		    ItemStack split = stack.splitStack(transferCount);
		    slotStack.stackSize += split.stackSize;
		    if (transferCount > 0) {
			if (!setStackInSlot(box, slot, slotStack)) {
			    // adding failed for some weird nbt reason
			    return originalStack;
			}
		    }
		    if (stack.stackSize <= 0)
			stack = null;
		}
	    }
	}
	return stack;
    }

    public ItemStack getStackFromBox(ItemStack box, int slot, int amount) {
	if (box != null && box.itemID == this.blockID && box.stackTagCompound != null && slot >= 0 && slot < STORAGE_SIZE) {
	    ItemStack stack = getStackInSlot(box, slot);
	    if (stack != null) {
		amount = Math.min(amount, stack.stackSize);
		ItemStack result = stack.splitStack(amount);
		if (stack != null && stack.stackSize <= 0)
		    stack = null;
		if (setStackInSlot(box, slot, stack))
		    return result;
	    }
	}
	return null;
    }

    public ItemStack peekStackFromBox(ItemStack box, int slot) {
	if (box != null && box.itemID == this.blockID && box.stackTagCompound != null && slot >= 0 && slot < STORAGE_SIZE) {
	    ItemStack stack = getStackInSlot(box, slot);
	    if (stack != null)
		return stack.copy();

	}
	return null;
    }

    private boolean setStackInSlot(ItemStack box, int slot, ItemStack stack) {
	NBTTagList list;
	if (!box.stackTagCompound.hasKey("Slots")) {
	    list = createEmptyNBTStackList(STORAGE_SIZE);
	    box.stackTagCompound.setTag("Slots", list);
	} else {
	    list = box.stackTagCompound.getTagList("Slots");
	}
	if (slot < list.tagCount()) {
	    NBTTagCompound compound = (NBTTagCompound) list.tagAt(slot);
	    if (stack == null)
		compound.setBoolean("NullStack", true);
	    else {
		compound.setBoolean("NullStack", false);
		stack.writeToNBT(compound);
	    }
	    return true;
	}
	return false;
    }

    private NBTTagList createEmptyNBTStackList(int i) {
	NBTTagList list = new NBTTagList();
	for (int j = 0; j < i; j++) {
	    NBTTagCompound compound = new NBTTagCompound();
	    ItemStack stack = new ItemStack(0, 0, 0);
	    stack.writeToNBT(compound);
	    list.appendTag(compound);
	}
	return list;
    }

    private ItemStack getStackInSlot(ItemStack box, int slot) {
	if (box.stackTagCompound.hasKey("Slots")) {
	    NBTTagList list = box.stackTagCompound.getTagList("Slots");
	    if (slot < list.tagCount()) {
		NBTTagCompound tag = (NBTTagCompound) list.tagAt(slot);

		boolean isNullTag = tag.hasKey("NullStack") && tag.getBoolean("NullStack");
		if (isNullTag)
		    return null;
		return ItemStack.loadItemStackFromNBT(tag);
	    }
	}
	return null;
    }
}
