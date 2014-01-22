package ip.industrialProcessing.transport.items.conveyorInput;

import java.util.Arrays;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.transport.items.conveyorPacker.PackerOperationMode;
import ip.industrialProcessing.utils.ExtractOrder;
import ip.industrialProcessing.utils.IExtractFilter;
import ip.industrialProcessing.utils.ItemTransfers;
import ip.industrialProcessing.utils.nbt.NbtHelper;

public class TileEntityConveyorInput extends TileEntityConveyorInventoryBase {

    private IExtractFilter filter;
    private ExtractOrder operationMode = ExtractOrder.RANDOM;

    ItemStack[] slots = new ItemStack[9];

    public TileEntityConveyorInput() {
	super();
	Arrays.fill(this.connections, ConnectionMode.INVENTORYINPUT);
	setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
	this.filter = new ConveyorImportFilter(this.slots);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	if (operationMode != null)
	    nbt.setInteger("Mode", operationMode.ordinal());
	NbtHelper.writeInventory(this.slots, nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	if (nbt.hasKey("Mode"))
	    operationMode = ExtractOrder.values()[nbt.getInteger("Mode")];
	NbtHelper.readInventory(this.slots, nbt);
    }

    @Override
    protected TransportConnectionState handleInventoryState(IInventory inventory, ForgeDirection direction, ConnectionMode mode) {
	return TransportConnectionState.INPUT;
    }

    protected ItemStack pullFromSide(ForgeDirection direction) {

	TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
	if (neighbor instanceof IInventory) {
	    IInventory inventory = (IInventory) neighbor;
	    ForgeDirection opposite = direction.getOpposite();
	    return ItemTransfers.extract(opposite, inventory, operationMode, filter);
	}
	return null;
    }
}
