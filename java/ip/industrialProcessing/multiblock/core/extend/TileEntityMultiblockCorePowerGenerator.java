package ip.industrialProcessing.multiblock.core.extend;

import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.power.IPowerOutput;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.PowerDistributorManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMultiblockCorePowerGenerator extends TileEntityMultiblockCore implements IPowerProducer, IPowerOutput {

	private PowerDistributorManager powerManager;
	private boolean searched = false;

	public TileEntityMultiblockCorePowerGenerator(StructureMultiblock structure, TierCollection tierRequirments) {
		super(structure, tierRequirments);
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

	public abstract boolean canOutputPower(int group, ForgeDirection opposite);
}
