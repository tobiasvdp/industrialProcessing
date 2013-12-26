package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.block.weldingStation.RecipesWeldingStation;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.IBreakable;
import ip.industrialProcessing.utils.IHeatStorage;

public class TileEntityBloomery extends TEmultiblockCoreTankWorker implements IHeatStorage, IBreakable {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static RecipesMachine recipes = new RecipesBloomery();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 1, 0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockBloomery.blockID);

		layout.setBlockID(1, 0, 0, i++, 0, 0, IndustrialProcessing.blockBellows.blockID);

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

	private int liveTime;
	private int totalLiveTime;

	public TileEntityBloomery() {
		super(structure, tierRequirments, recipes);
		LocalDirection[] nodirections = new LocalDirection[0];
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, true, false);

		T1 = 20;
		T2 = 20;
		burnTime = 0;
		totalTime = 1;

		SetLiveTime(15000);
	}

	@Override
	public void updateEntity() {
		transferHeat();
		tickFuel();
		if (burnTime == 0)
			ConsumeFuel(getStackInSlot(2));
		if (getHeat() > 1538)
			if (TickLiveTime())
				destroyBlock();

		super.updateEntity();
	}

	@Override
	public void doWork() {
		if (getHeat() > 1538)
			super.doWork();
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 2 && itemID == Item.coal.itemID) {
			return true;
		}
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public void ConsumeFuel(ItemStack stack) {
		if (stack != null && stack.itemID == Item.coal.itemID && stack.stackSize > 0) {
			this.removeFromSlot(2, stack.itemID, 1);
			burnTime = 3600;
			totalTime = 3600;
			T2 = 2700;
		}
	}

	@Override
	public float getHeat() {
		return T1;
	}

	@Override
	public float getMaxHeat() {
		return 3000;
	}

	@Override
	public float getCoolingFactor() {
		return (float) 0.0016;
	}

	@Override
	public int getScaledHeat(int maxSize) {
		return (int) (getHeat() * maxSize / getMaxHeat());
	}

	@Override
	public void tickFuel() {
		if (burnTime > 0)
			burnTime--;
	}

	@Override
	public float getHeatFuel() {
		return T2;
	}

	@Override
	public void transferHeat() {
		T1 = T1 - getCoolingFactor() * (T1 - T2);
		if (burnTime > 0)
			T2 = (float) (T2 * 0.99995);
		else
			T2 = T2 - getCoolingFactor() * (T2 - 20);
	}

	@Override
	public int getScaledBurnTime(int size) {
		return burnTime * size / totalTime;
	}

	@Override
	public void SetLiveTime(int time) {
		totalLiveTime = time;
		liveTime = totalLiveTime;
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
		this.destroyMultiblock();
		this.worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
		worldObj.setBlockToAir(xCoord, yCoord, zCoord);
	}

	@Override
	public int getScaledLiveTime(int scale) {
		return liveTime * scale / totalLiveTime;
	}
	
@Override
public void writeToNBT(NBTTagCompound nbt) {
	nbt.setInteger("T1",(int)T1);
	nbt.setInteger("T2",(int)T2);
	nbt.setInteger("burnTime",burnTime);
	nbt.setInteger("totalTime",totalTime);

	nbt.setInteger("liveTime",liveTime);
	nbt.setInteger("totalLiveTime",totalLiveTime);
	super.writeToNBT(nbt);
}
@Override
public void readFromNBT(NBTTagCompound nbt) {
	T1 = nbt.getInteger("T1");
	T2 = nbt.getInteger("T2");
	burnTime = nbt.getInteger("burnTime");
	totalTime = nbt.getInteger("totalTime");

	liveTime = nbt.getInteger("liveTime");
	totalLiveTime = nbt.getInteger("totalLiveTime");
	super.readFromNBT(nbt);
}

}
