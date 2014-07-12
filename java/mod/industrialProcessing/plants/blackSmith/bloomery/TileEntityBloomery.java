package mod.industrialProcessing.plants.blackSmith.bloomery;

import java.util.Iterator;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.utils.block.IBreakable;
import mod.industrialProcessing.utils.handlers.heat.HeatStorage;
import mod.industrialProcessing.utils.handlers.heat.IHeatStorage;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;

public class TileEntityBloomery extends TileEntityMultiblockCoreTankWorker implements IHeatStorage, IBreakable {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesBloomery();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 1, 0, 0, 1, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockBloomery);

		layout.setBlockID(1, 0, 0, i++, 0, 0, IndustrialProcessing.blockBellows);
		layout.setBlockID(0, 1, 0, i++, 0, 0, IndustrialProcessing.blockIronBowl, IndustrialProcessing.blocktransparent);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(2);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
		tier = new Tier();
		tier.setBlockIDPresent(2, IndustrialProcessing.blockIronBowl);
		tierRequirments.addTier(tier, Tiers.Tier1);
	}

	private float T1;
	private float T2;
	private int burnTime;
	private int totalTime;

	private int liveTime;
	private int totalLiveTime;

	public TileEntityBloomery() {
		super(structure, tierRequirments, new RecipesBloomery());
		LocalDirection[] nodirections = new LocalDirection[0];
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);

		HeatStorage.construction(this);

		SetTotalLifeTime(15000);
		SetLifeTime(15000);
	}

	@Override
	public Iterator<RecipeMultiblock> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	public void updateEntity() {
		HeatStorage.onUpdateEntity(this, this, 3);
		if (getHeat() > requiredHeatLevel())
			if (TickLiveTime())
				destroyBlock();

		super.updateEntity();
	}

	@Override
	public void doWork() {
		if (HeatStorage.onDoWork(this))
			super.doWork();
	}

	//burner management
	@Override
	public void ConsumeFuel(ItemStack stack) {
		HeatStorage.ConsumeFuel(this.worldObj,this,this, this, stack,3);
	}

	@Override
	public int getScaledHeat(int maxSize) {
		return HeatStorage.getScaledHeat(this, maxSize);
	}

	@Override
	public void tickFuel() {
		HeatStorage.tickFuel(this);
	}

	@Override
	public void transferHeat() {
		HeatStorage.transferHeat(this);
	}

	@Override
	public int getScaledBurnTime(int size) {
		return HeatStorage.getScaledBurnTime(this, size);
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
		return (float) 0.0016;
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

	@Override
	public boolean TickLiveTime() {
		liveTime--;
		if (liveTime <= 0)
			return true;
		return false;
	}

	@Override
	public void destroyBlock() {
		this.getBlockType().removedByPlayer(worldObj, null, xCoord, yCoord, zCoord);
	}

	@Override
	public int getScaledLiveTime(int scale) {
		return liveTime * scale / totalLiveTime;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		HeatStorage.onWriteToNBT(this, nbt);

		nbt.setInteger("liveTime", liveTime);
		nbt.setInteger("totalLiveTime", totalLiveTime);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		HeatStorage.onReadFromNBT(this, nbt);

		liveTime = nbt.getInteger("liveTime");
		totalLiveTime = nbt.getInteger("totalLiveTime");
		super.readFromNBT(nbt);
	}
	//end of burner management

	@Override
	public int getTotalLifetime() {
		return totalLiveTime;
	}

	@Override
	public void SetTotalLifeTime(int time) {
		totalLiveTime = time;
		
	}

	@Override
	public int getLifetime() {
		return liveTime;
	}

	@Override
	public void SetLifeTime(int time) {
		liveTime = time;
	} 

}
