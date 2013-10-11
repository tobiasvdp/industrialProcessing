package ip.industrialProcessing.multiblock.core.block.weldingStation;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
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

public class TEmultiblockWeldingStation extends TEmultiblockCoreTankWorkerPowered{
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static RecipesMachine recipes = new RecipesWeldingStation();
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(2, 0, 0, 0, 1, 0);
		
		int i = 0;
		layout.setCoreID(i++,0,1, IndustrialProcessing.BLmultiblockWeldingStation.blockID);
		
		layout.setBlockID(-1, 0, 0,i++, 0,0, IndustrialProcessing.BLmultiblockWeldingTableExt.blockID);
		layout.setBlockID(0, 1, 0,i++, 0,0, IndustrialProcessing.BLmultiblockScreen.blockID);
		layout.setBlockID(-1, 1, 0,i++, 0,1, IndustrialProcessing.BLmultiblockScreen.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);
		
		
		//set tiers
		tierRequirments = new TierCollection(1);
		
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TEmultiblockWeldingStation() {
		super(structure, tierRequirments,recipes, LocalDirection.LEFT,10000,100);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.RIGHT, false, true);	
		
		this.addTank(10000, 0, new ForgeDirection[]{ForgeDirection.NORTH}, true, false);
	}
	@Override
	public void updateEntity() {
	    System.out.println(worldObj + " work :" + getWorker().getWorkDone() + "/" + getWorker().getTotalWork());
	super.updateEntity();
	}
	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
	    return true;
	}
	@Override
	public boolean tankContains(int slot, int itemId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean tankHasRoomFor(int slot, FluidStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean tankHasRoomFor(int slot, int itemId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addToTank(int index, int itemId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeFromTank(int index, int itemId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}
}
