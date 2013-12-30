package ip.industrialProcessing.multiblock.core.block.weldingStation;

import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.machines.mixer.RecipesMixer;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.TierRequirement;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;
import ip.industrialProcessing.multiblock.utils.TEmultiblockItemStackType;
import ip.industrialProcessing.multiblock.utils.blockSide;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.IHeatStorage;

public class TEmultiblockWeldingStation extends TEmultiblockCoreTankWorkerPowered implements IHeatStorage {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static RecipesMachine recipes = new RecipesWeldingStation();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(2, 0, 0, 0, 1, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.BLmultiblockWeldingStation.blockID);

		layout.setBlockID(-1, 0, 0, i++, 0, 0, IndustrialProcessing.BLmultiblockWeldingTableExt.blockID);
		layout.setBlockID(0, 1, 0, i++, 0, 0, IndustrialProcessing.BLmultiblockScreen.blockID);
		layout.setBlockID(-1, 1, 0, i++, 0, 1, IndustrialProcessing.BLmultiblockScreen.blockID);

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

	public TEmultiblockWeldingStation() {
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

		T1 = 20;
		T2 = 20;
		burnTime = 0;
		totalTime = 1;
	}

	@Override
	public void updateEntity() {
		transferHeat();
		tickFuel();
		if (burnTime == 0)
			ConsumeFuel(getStackInSlot(14));
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
		if (slot == 14 && itemID == Item.coal.itemID) {
			return true;
		}
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public void ConsumeFuel(ItemStack stack) {
		if (stack != null && stack.itemID == Item.coal.itemID && stack.stackSize > 0) {
			this.removeFromSlot(14, stack.itemID, 1);
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
		return (float) 0.0008;
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
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("T1", (int) T1);
		nbt.setInteger("T2", (int) T2);
		nbt.setInteger("burnTime", burnTime);
		nbt.setInteger("totalTime", totalTime);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		T1 = nbt.getInteger("T1");
		T2 = nbt.getInteger("T2");
		burnTime = nbt.getInteger("burnTime");
		totalTime = nbt.getInteger("totalTime");
		super.readFromNBT(nbt);
	}
}
