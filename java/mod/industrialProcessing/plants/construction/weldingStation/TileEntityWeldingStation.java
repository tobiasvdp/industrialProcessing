package mod.industrialProcessing.plants.construction.weldingStation;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.utils.handlers.heat.HeatStorage;
import mod.industrialProcessing.utils.handlers.heat.IHeatStorage;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityWeldingStation extends TileEntityMultiblockCoreTankWorkerPowered implements IHeatStorage {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesWeldingStation();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(2, 0, 0, 0, 1, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockWeldingStation);

		layout.setBlockID(-1, 0, 0, i++, 0, 1, IndustrialProcessing.blockWeldingTable);
		layout.setBlockID(0, 1, 0, i++, 0, 0, IndustrialProcessing.blockScreen);
		layout.setBlockID(-1, 1, 0, i++, 0, 1, IndustrialProcessing.blockScreen);

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

	public TileEntityWeldingStation() {
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
