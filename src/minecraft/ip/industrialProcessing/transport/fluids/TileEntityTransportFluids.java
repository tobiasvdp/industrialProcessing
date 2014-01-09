package ip.industrialProcessing.transport.fluids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import buildcraft.api.transport.IPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.FluidTransfers;

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
	protected float getPressure(ForgeDirection direction) {
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
}
