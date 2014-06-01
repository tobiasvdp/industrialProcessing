package mod.industrialProcessing.transport.fluids.tileEntity;

import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityTransportFluids extends TileEntityTransportFluidsBase {

	private FluidTank tank = new FluidTank(1000);
	private float pressure = 0;

	public TileEntityTransportFluids() {
		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	protected void leakPressure() {
		this.pressure -= this.pressure * 0.005f;
		if (Float.isNaN(this.pressure) || Float.isInfinite(this.pressure))
			this.pressure = 0;
	}

	@Override
	protected IFluidTank getTank(ForgeDirection direction) {
		return this.tank;
	}

	@Override
	public float getPressure(ForgeDirection direction) {
		return this.pressure;
	}

	@Override
	protected void addPressure(ForgeDirection direction, float value) {
		this.pressure += value;
	}

	@Override
	public FluidTankInfo[] getTanks() {
		return new FluidTankInfo[] { this.tank.getInfo() };
	}

	@Override
	public IFluidTank getTankInSlot(int slot) {
		return this.tank;
	}

	@Override
	public int getTankCount() {
		return 1;
	}

	@Override
	protected boolean canConnect(ForgeDirection direction) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) { 
		super.readFromNBT(par1nbtTagCompound);
		this.tank.readFromNBT(par1nbtTagCompound);
		this.pressure = par1nbtTagCompound.getFloat("Pressure");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		this.tank.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setFloat("Pressure", this.pressure);
	}

	@Override
	public FluidTankInfo getTankInfoForSlot(int slot) {
		return getTankInSlot(slot).getInfo();
	}
}
