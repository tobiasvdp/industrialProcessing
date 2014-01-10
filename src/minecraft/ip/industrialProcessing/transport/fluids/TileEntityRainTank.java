package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.utils.ConnectedTileUtils;
import ip.industrialProcessing.utils.FluidTransfers;

import java.util.Arrays;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityRainTank extends TileEntityFluidMachine implements IConnectedTile, ITankSyncable, IPressuredTank {

	private ConnectionState[] states = new ConnectionState[6];
	private boolean searchConnections;
	private TankHandler tankHandler;

	public TileEntityRainTank() {
		LocalDirection[] sides = new LocalDirection[] { LocalDirection.FRONT, LocalDirection.BACK, LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.DOWN };
		addTank(5 * FluidContainerRegistry.BUCKET_VOLUME, sides, true, true);

		Arrays.fill(this.states, ConnectionState.DISCONNECTED); 
		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (searchConnections)
			searchNeighbors();
		if (!this.worldObj.isRemote) {
			IFluidTank tank = this.getTankInSlot(0);

			if (this.worldObj.isRaining()) {
				int y = this.worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord);
				
				BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord); 
				int rain = (int)(10 * biome.rainfall);
				if (y == yCoord + 1) {
					tank.fill(new FluidStack(FluidRegistry.WATER, rain), true);
				}
			}

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

			if (this.tankHandler.readDataFromTanks()) {
				TileTankSyncHandler.sendTankData(this, this.tankHandler);
			}
		}
	}

	private void searchNeighbors() {
		this.searchConnections = false;
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
			} else {
				changed |= (current != ConnectionState.DISCONNECTED);
				states[i] = ConnectionState.DISCONNECTED;
			}

		}
		if (changed) {
			// stuff changed
			notifyBlockChange();
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		ConnectedTileUtils.readFromNBT(nbt, states);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		ConnectedTileUtils.writeToNBT(nbt, states);
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return fluidId == FluidRegistry.WATER.getID();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public void searchForConnections() {
		this.searchConnections = true;
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		int index = direction.ordinal();
		return states[index];
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	@Override
	public float getPressure(ForgeDirection from) {
		if(from == ForgeDirection.UP) return 0;
		
		IFluidTank tank = getTankInSlot(0);
		float pressure = tank.getFluidAmount() * 1000f / tank.getCapacity();
		if(from == ForgeDirection.DOWN) return pressure;
		return pressure / 2;
	}

}
