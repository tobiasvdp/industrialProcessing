package mod.industrialProcessing.transport.items.conveyorBelt.util;

import mod.industrialProcessing.blockContainer.transport.TransportConnectionState;
import mod.industrialProcessing.utils.inventory.ItemTransfers;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class InventoryUtils {

	private ForgeDirection forwardDirection;

	public TransportConnectionState getInventoryState(TileEntity entity, ForgeDirection direction) {
		if (entity instanceof ISidedInventory) {
			ISidedInventory inventory = (ISidedInventory) entity;
			int[] slots = inventory.getAccessibleSlotsFromSide(direction.getOpposite().ordinal());
			if (slots != null && slots.length > 0) {
				if (direction == this.forwardDirection.getOpposite())
					// this conveyor is connected to an input
					return TransportConnectionState.INPUT;
				else if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN)
					return TransportConnectionState.DUAL;
				else
					// this conveyor belt is connected to an output
					return TransportConnectionState.OUTPUT;
			}
		} else if (entity instanceof IInventory) {
			if (direction == this.forwardDirection.getOpposite())
				// this conveyor is connected to an input
				return TransportConnectionState.INPUT;
			else if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN)
				return TransportConnectionState.DUAL;
			else
				// this conveyor belt is connected to an output
				return TransportConnectionState.OUTPUT;
		}
		return TransportConnectionState.NONE;
	}

	public static boolean canInsert(MovingItemStack stack, ForgeDirection direction, IInventory destinationInventory) {
		if (stack.destination == LocalDirection.BACK && stack.source != LocalDirection.DOWN) {
			if (destinationInventory instanceof ISidedInventory) {
				if (ItemTransfers.canInsert(stack.stack, (ISidedInventory) destinationInventory, direction.getOpposite()))
					return true;
			} else if (ItemTransfers.canInsert(stack.stack, destinationInventory))
				return true;
		}
		return false;
	}
}
