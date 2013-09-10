package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.utils.FluidTransfers;

import java.util.Arrays;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityRainTank extends TileEntityFluidMachine {

	private ConnectionState[] states = new ConnectionState[6];

	public TileEntityRainTank() {
		LocalDirection[] sides = new LocalDirection[] { LocalDirection.FRONT, LocalDirection.BACK, LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.DOWN };
		addTank(5 * FluidContainerRegistry.BUCKET_VOLUME, sides, false, true);

		Arrays.fill(this.states, ConnectionState.DISCONNECTED);

	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		IFluidTank tank = this.getTankInSlot(0);
		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if (direction == ForgeDirection.UP)
				continue;
			ConnectionState current = states[i];
			TileEntity neighbor = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
			if (neighbor instanceof TileEntityRainTank) {
				TileEntityRainTank rainTank = (TileEntityRainTank) neighbor;
				IFluidTank otherTank = rainTank.getTankInSlot(0);

				int diff = otherTank.getFluidAmount() - tank.getFluidAmount();
				if (diff > 0) {
					FluidTransfers.transfer(diff / 2, otherTank, tank);
				}
			}
		}
	}

	private void searchNeighbors() {
		boolean changed = false;
		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if (direction == ForgeDirection.UP)
				continue;
			ConnectionState current = states[i];
			TileEntity neighbor = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
			if (neighbor instanceof TileEntityRainTank) {
				changed |= (current != ConnectionState.CONNECTED);
				states[i] = ConnectionState.CONNECTED;
			} else if (neighbor instanceof TileEntityTransportFluids) {
				changed |= (current != ConnectionState.PLUGGED);
				states[i] = ConnectionState.PLUGGED;
			}
		}
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

}
