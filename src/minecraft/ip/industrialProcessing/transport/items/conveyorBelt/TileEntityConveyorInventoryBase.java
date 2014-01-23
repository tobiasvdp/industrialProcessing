package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.ExtractOrder;
import ip.industrialProcessing.utils.ItemTransfers;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorInventoryBase extends TileEntityConveyorInteractionBase {

    private int updateCycle = 10;
    private int ticks = 0;

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (ticks++ > updateCycle) {
	    ticks = 0;
	    extractFromInputs();
	}
    }

    @Override
    protected TransportConnectionState handleInventoryState(TileEntity entity, ForgeDirection direction) {
	ConnectionMode mode = getConnectionMode(direction);
	if (mode == ConnectionMode.NONE)
	    return TransportConnectionState.NONE;
	if (mode.isInventory())
	    if (entity instanceof IInventory) {
		IInventory inventory = (IInventory) entity;
		if (inventory instanceof ISidedInventory) {
		    ISidedInventory sidedInventory = (ISidedInventory) inventory;
		    int[] slots = sidedInventory.getAccessibleSlotsFromSide(direction.getOpposite().ordinal());
		    if (slots != null && slots.length > 0) {
			return getConnectionFromMode(mode);
		    } else
			return TransportConnectionState.NONE;
		} else
		    return handleInventoryState(inventory, direction, mode);
		// else
		// return getConnectionFromMode(mode);
	    }
	return TransportConnectionState.NONE;
    }

    protected TransportConnectionState handleInventoryState(IInventory inventory, ForgeDirection direction, ConnectionMode mode) {
	return TransportConnectionState.DUAL;
    }

    private TransportConnectionState getConnectionFromMode(ConnectionMode mode) {
	switch (mode) {
	case INPUT:
	case INVENTORYINPUT:
	case ANYINPUT:
	    return TransportConnectionState.INPUT;
	case OUTPUT:
	case INVENTORYOUTPUT:
	case ANYOUTPUT:
	    return TransportConnectionState.OUTPUT;
	case DUAL:
	    return TransportConnectionState.DUAL;
	default:
	    return TransportConnectionState.NONE;
	}
    }

    @Override
    protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {

	for (int i = 0; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[direction.ordinal()];
	    if (state.isOutput()) {
		LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
		if (local != source) {
		    ConnectionMode mode = this.getConnectionMode(local);
		    if (mode.isInventoryOutput()) {
			TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
			if (neighbor instanceof IInventory) {
			    IInventory inventory = (IInventory) neighbor;
			    if (ItemTransfers.canInsert(stack, inventory))
				return local;
			}
		    }
		}
	    }
	}

	for (int i = 0; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[direction.ordinal()];
	    if (state.isConnected()) {
		LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
		if (local != source) {
		    ConnectionMode mode = this.getConnectionMode(local);
		    if (mode.isOutput(false))
			return local;
		}
	    }
	}

	return LocalDirection.UNKNOWN;
    }

    public void extractFromInputs() {
	for (int i = 5; i >= 0; i--) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[i];
	    if (state == TransportConnectionState.INPUT || state == TransportConnectionState.DUAL) {
		ItemStack stack = pullFromSide(direction);
		if (stack != null && stack.stackSize > 0)
		    addItemStack(stack, direction);
	    }
	}
    }

    @Override
    protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
	if (neighbor instanceof IInventory) {
	    return ItemTransfers.transfer(stack.stack, (IInventory) neighbor, direction.getOpposite());
	}
	return stack.stack;
    }

    protected ItemStack pullFromSide(ForgeDirection direction) {

	TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
	if (neighbor instanceof IInventory) {
	    IInventory inventory = (IInventory) neighbor;
	    ForgeDirection opposite = direction.getOpposite();
	    return ItemTransfers.extract(opposite, inventory, ExtractOrder.RANDOM, null, 1);
	}
	return null;
    }
}
