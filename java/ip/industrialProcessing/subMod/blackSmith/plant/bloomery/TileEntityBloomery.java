package ip.industrialProcessing.subMod.blackSmith.plant.bloomery;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.utils.IBreakable;
import ip.industrialProcessing.utils.handler.heat.HeatStorage;
import ip.industrialProcessing.utils.handler.heat.IHeatStorage;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBloomery extends TileEntityMultiblockCoreTankWorker implements IHeatStorage, IBreakable {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesBloomery();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 1, 0, 0, 1, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupBlackSmith.blockBloomery.blockID);

		layout.setBlockID(1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockBellows.blockID);
		layout.setBlockID(0, 1, 0, i++, 0, 0, ISetupBlackSmith.blockIronBowl.blockID, -1);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(2);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
		tier = new Tier();
		tier.setBlockIDPresent(2, ISetupBlackSmith.blockIronBowl.blockID);
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

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 3) {
			return HeatStorage.onIsValidInput(itemID);
		}
		return recipes.isValidInput(slot, itemID,getTier());
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
		this.getBlockType().removeBlockByPlayer(worldObj, null, xCoord, yCoord, zCoord);
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
