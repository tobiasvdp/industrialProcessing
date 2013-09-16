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

public abstract class TileEntityConveyorInputBase extends TileEntityConveyorInteractionBase {

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
			return TransportConnectionState.INPUT;
		case OUTPUT:
			return TransportConnectionState.OUTPUT;
		case DUAL:
			return TransportConnectionState.DUAL;
		default:
			return TransportConnectionState.NONE;
		}
	}

	@Override
	protected LocalDirection findOutput(ItemStack stack) {

		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			if (isOutput(direction)) {
				TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
				if (neighbor instanceof IInventory){
					if(ItemTransfers.canInsert(stack, (IInventory) neighbor, direction.getOpposite()))
					return DirectionUtils.getLocalDirection(direction, this.forwardDirection);
				}else
					System.out.println("TileEntityConveyorInputBase.findOutput() where shall i go?");
			}
		}
		return LocalDirection.UP;
	}

	public void extractFromInputs() {
		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			TransportConnectionState state = this.states[i];
			if (state == TransportConnectionState.INPUT || state == TransportConnectionState.DUAL) {
				ItemStack stack = pullFromSide(direction);
				if (stack != null && stack.stackSize > 0)
					addItemStack(stack, direction);
			}
		}
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
