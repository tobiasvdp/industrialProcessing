package ip.industrialProcessing.transport.fluids;

import java.util.Arrays;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityValve extends TileEntityTransportFluids {
	private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
	private FluidTank[] tanks = new FluidTank[6];
	private float[] pressures = new float[6];

	public TileEntityValve() {
		for (int i = 0; i < 6; i++) {
			pressures[i] = 0;
			tanks[i] = new FluidTank(1000);
		}
		this.tank = new FluidTank(6000);
	}

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			int connectionCount = 0;
			this.pressure = 0;
			if (this.animationHandler.getProgress() > 0) {
				for (int i = 0; i < 6; i++) {
					if (states[i] != TransportConnectionState.NONE) {
						FluidTank sideTank = tanks[i];
						int amount = (int) (sideTank.getFluidAmount() * this.animationHandler.getProgress());
						if (amount > 0) {
							FluidTransfers.transfer(amount, sideTank, this.tank);
						}
						this.pressure += this.pressures[i];
					}
				}

				int amount = this.tank.getFluidAmount() / connectionCount;
				for (int i = 0; i < 6; i++) {
					if (states[i] != TransportConnectionState.NONE) {
						FluidTank sideTank = tanks[i];
						pressures[i] = this.pressure / connectionCount;
						FluidTransfers.transfer(amount, this.tank, sideTank);
					} else
						this.pressures[i] = 0;
				}
			}
			this.animationHandler.update();
		}
		super.updateEntity();
	}

	@Override
	protected float getPressure(ForgeDirection direction) {
		return pressures[direction.ordinal()];
	}

	@Override
	protected void addPressure(ForgeDirection direction, float value) {
		pressures[direction.ordinal()] += value;
	}

	@Override
	protected void setPressure(ForgeDirection direction, float value) {
		pressures[direction.ordinal()] = value;
	}

	@Override
	protected IFluidTank getTank(ForgeDirection direction) {
		return tanks[direction.ordinal()];
	}
}
