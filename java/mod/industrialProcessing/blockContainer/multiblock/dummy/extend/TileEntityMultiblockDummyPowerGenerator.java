package mod.industrialProcessing.blockContainer.multiblock.dummy.extend;

import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCorePowerGenerator;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.power.network.IPowerOutput;
import mod.industrialProcessing.power.network.IPowerProducer;
import mod.industrialProcessing.power.network.PowerDistributorManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMultiblockDummyPowerGenerator extends TileEntityMultiblockDummy implements IPowerProducer, IPowerOutput {

	private PowerDistributorManager powerManager;
	private boolean searched = false;

	@Override
	public TileEntityMultiblockCorePowerGenerator getCore() {
		if (super.getCore() != null)
			return (TileEntityMultiblockCorePowerGenerator) super.getCore();
		return null;
	}

	public TileEntityMultiblockDummyPowerGenerator() {
		this.powerManager = new PowerDistributorManager(this, this);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.powerManager.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.powerManager.writeToNBT(nbt);
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!searched)
			searchForPowerAcceptors();

		this.powerManager.distributePower(this, this.worldObj);
	}

	public void searchForPowerAcceptors() {
		this.searched = true;
		this.powerManager.searchPowerAcceptors();
	}

	@Override
	public float getCharge(float amount) {
		if (getCore() != null)
			return getCore().getCharge(amount);
		return 0;
	}

	@Override
	public float getVoltage() {
		if (getCore() != null)
			return getCore().getVoltage();
		return 0;
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		if (getCore() != null)
			return getCore().canOutputPower(this.getGroup(),opposite);
		return false;
	}
}
