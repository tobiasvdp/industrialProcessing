package mod.industrialProcessing.plants.transport.fluids.rainTank;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTank;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.blockContainer.transport.IConnectedTile;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TileTankSyncHandler;
import mod.industrialProcessing.fluids.FluidTransfers;
import mod.industrialProcessing.fluids.tank.IPressuredTank;
import mod.industrialProcessing.transport.fluids.tileEntity.TileEntityTransportFluids;
import mod.industrialProcessing.utils.connections.ConnectedTileUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public class TileEntityRainTank extends TileEntityMachineTank implements IConnectedTile, ITankSyncable, IPressuredTank {

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
				TileEntity neighbor = this.worldObj.getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
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
			TileEntity neighbor = this.worldObj.getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
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
	protected boolean isTankValidForFluid(int slot, Fluid fluidId) {
		return fluidId.equals(FluidRegistry.WATER);
	}

	@Override
	protected boolean isValidInput(int slot, Item itemID) {
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