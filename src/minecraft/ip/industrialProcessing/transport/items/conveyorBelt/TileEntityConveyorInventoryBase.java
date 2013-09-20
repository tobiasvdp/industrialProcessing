package ip.industrialProcessing.transport.items.conveyorBelt;

import org.lwjgl.Sys;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.utils.ItemTransfers;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorInventoryBase extends TileEntityConveyorInteractionBase {

	private int updateCycle = 20;
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
				return getConnectionFromMode(mode);
		}
		return TransportConnectionState.NONE;
	}

	private TransportConnectionState getConnectionFromMode(ConnectionMode mode) {
		switch (mode) {
		case INPUT:
			return TransportConnectionState.NONE;
		case OUTPUT:
			return TransportConnectionState.NONE;
		case INVENTORYINPUT:
			return TransportConnectionState.INPUT;
		case INVENTORYOUTPUT:
			return TransportConnectionState.OUTPUT;
		case DUAL:
			return TransportConnectionState.NONE;
		default:
			return TransportConnectionState.NONE;
		}
	}

	@Override
	protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {
		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
			if (local != source) {
				if (isOutput(direction)) {
					TransportConnectionState state = this.states[direction.ordinal()];
					if (state.isOutput()) {
						TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
						if (neighbor instanceof IInventory) {
							if (ItemTransfers.canInsert(stack, (IInventory) neighbor, direction.getOpposite()))
								return local;
						} else
							return local;
					}
				}
			}
		}
		for (int i = 5; i > 0; i--) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
			if (local != source && isOutput(direction)) 
					return local; 			
		}
		return LocalDirection.UP;
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
	
	private ItemStack pullFromSide(ForgeDirection direction) {

		TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
		if (neighbor instanceof IInventory) {
			IInventory inventory = (IInventory) neighbor;
			ForgeDirection opposite = direction.getOpposite();
			if (inventory != null) {
				if (inventory instanceof ISidedInventory) {
					ISidedInventory sidedInventory = (ISidedInventory) inventory;
					int[] slots = sidedInventory.getAccessibleSlotsFromSide(opposite.ordinal());
					for (int j = slots.length - 1; j >= 0; j--) {
						ItemStack stack = sidedInventory.getStackInSlot(slots[j]);
						sidedInventory.canExtractItem(slots[j], stack, opposite.ordinal());
						ItemStack item = sidedInventory.decrStackSize(slots[j], 1);
						if (item != null) {
							return item;
						}
					}
				} else {
					for (int j = inventory.getSizeInventory() - 1; j >= 0; j--) {
						ItemStack item = inventory.decrStackSize(j, 1);
						if (item != null) {
							return item;
						}
					}
				}
			}
		}
		return null;
	}
}
