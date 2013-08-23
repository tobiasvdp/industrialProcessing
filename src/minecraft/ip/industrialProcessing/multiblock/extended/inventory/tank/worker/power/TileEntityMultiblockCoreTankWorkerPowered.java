package ip.industrialProcessing.multiblock.extended.inventory.tank.worker.power;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.multiblock.extended.inventory.tank.worker.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.power.IPowerAcceptor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMultiblockCoreTankWorkerPowered extends TileEntityMultiblockCoreTankWorker implements IPowerAcceptor {

	private int counttemp = 0;

	private int powerStorage;
	private int powerCapacity;
	private int maxWorkSpeed;

	public TileEntityMultiblockCoreTankWorkerPowered(MultiblockLayout layout, int powerCapacity, int maxWorkSpeed) {
		super(layout, maxWorkSpeed);
		this.powerStorage = 0;
		this.powerCapacity = powerCapacity;
		this.maxWorkSpeed = maxWorkSpeed;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (counttemp == 80) {
			if (!worldObj.isRemote)
			System.out.println(powerStorage);
			counttemp = 0;
		}
		counttemp++;

	}

	@Override
	public void doWork() {
		//int amount = PowerWorkerHelper.getWork(this.powerCapacity, this.powerStorage, this.maxWorkSpeed);
		this.powerStorage -= work(amount,powerStorage);
	}
	protected int work(int amount, int power) {
		return this.getWorker().doWork(amount,power);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readPowerStatus(nbt);
	}

	private void readPowerStatus(NBTTagCompound nbt) {
		this.powerStorage = nbt.getInteger("PowStor");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writePowerStatus(nbt);
	}

	private void writePowerStatus(NBTTagCompound nbt) {
		nbt.setInteger("PowStor", this.powerStorage);
	}

	@Override
	public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
		if (canAcceptPower(side)) {
			int accept = PowerWorkerHelper.acceptPower(this.powerCapacity, this.powerStorage, maxAmount);
			if (doAccept) {
				this.powerStorage += accept;
			}
			return accept;
		}
		return 0;
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		return true;
	}

	public int getPowerCapacity() {
		return powerCapacity;
	}

	public int getPowerStorage() {
		return powerStorage;
	}

	public void incPowerStorage(int accept) {
		powerStorage += accept;
	}

}
