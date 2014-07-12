package mod.industrialProcessing.blockContainer.multiblock.core.extend;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.power.network.IPowerOutput;
import mod.industrialProcessing.power.network.IPowerProducer;
import mod.industrialProcessing.power.network.PowerDistributorManager;
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
