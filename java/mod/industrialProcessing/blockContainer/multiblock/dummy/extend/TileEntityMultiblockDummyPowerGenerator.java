package ip.industrialProcessing.multiblock.dummy.extend;

import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCorePowerGenerator;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.power.IPowerOutput;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.PowerDistributorManager;
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
