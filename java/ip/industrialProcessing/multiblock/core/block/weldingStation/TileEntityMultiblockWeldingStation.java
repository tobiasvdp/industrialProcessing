package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.handler.heat.HeatStorage;
import ip.industrialProcessing.utils.handler.heat.IHeatStorage;

public class TileEntityMultiblockWeldingStation extends TileEntityMultiblockCoreTankWorkerPowered implements IHeatStorage {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesWeldingStation();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(2, 0, 0, 0, 1, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupMachineBlocks.BLmultiblockWeldingStation.blockID);

		layout.setBlockID(-1, 0, 0, i++, 0, 1, ISetupMachineBlocks.BLmultiblockWeldingTableExt.blockID);
		layout.setBlockID(0, 1, 0, i++, 0, 0, ISetupMachineBlocks.BLmultiblockScreen.blockID);
		layout.setBlockID(-1, 1, 0, i++, 0, 1, ISetupMachineBlocks.BLmultiblockScreen.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	private float T1;
	private float T2;
	private int burnTime;
	private int totalTime;
	public int openGui = 0;

	public TileEntityMultiblockWeldingStation() {
		super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);
		LocalDirection[] nodirections = new LocalDirection[0];
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);

		HeatStorage.construction(this);
	}

	@Override
	public void updateEntity() {
		HeatStorage.onUpdateEntity(this, this, 11);
		super.updateEntity();
	}

	@Override
	public void doWork() {
		if (HeatStorage.onDoWork(this))
			super.doWork();
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 11) {
			return HeatStorage.onIsValidInput(itemID);
		}
		return recipes.isValidInput(slot, itemID, getTier());
	}

	@Override
	public void ConsumeFuel(ItemStack stack) {
		HeatStorage.ConsumeFuel(this.worldObj, this, this, this, stack, 11);
	}

	@Override
	public int getScaledHeat(int maxSize) {
		return HeatStorage.getScaledHeat(this, maxSize);
	}

	@Override
	public void tickFuel() {
		if (!this.worldObj.isRemote)
			HeatStorage.tickFuel(this);
	}

	@Override
	public void transferHeat() {
		if (!this.worldObj.isRemote)
			HeatStorage.transferHeat(this);
	}

	@Override
	public int getScaledBurnTime(int size) {
		return HeatStorage.getScaledBurnTime(this, size);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		HeatStorage.onWriteToNBT(this, nbt);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		HeatStorage.onReadFromNBT(this, nbt);
		super.readFromNBT(nbt);
	}

	@Override
	public float getMaxHeat() {
		return 3000;
	}

	@Override
	public float requiredHeatLevel() {
		return 1537;
	}

	@Override
	public float getCoolingFactor() {
		return (float) 0.0008;
	}

	@Override
	public float getHeatFuel() {
		return T2;
	}

	@Override
	public float getHeat() {
		return T1;
	}

	@Override
	public void setHeatFuel(float val) {
		T2 = val;
	}

	@Override
	public void setHeat(float val) {
		T1 = val;
	}

	@Override
	public int getBurnTime() {
		return burnTime;
	}

	@Override
	public void setBurnTime(int val) {
		burnTime = val;
	}

	@Override
	public int getMaxBurnTime() {
		return totalTime;
	}

	@Override
	public void setMaxBurnTime(int val) {
		totalTime = val;
	}
}
