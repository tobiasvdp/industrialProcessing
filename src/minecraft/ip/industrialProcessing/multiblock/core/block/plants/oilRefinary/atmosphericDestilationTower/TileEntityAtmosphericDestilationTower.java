package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;

public class TileEntityAtmosphericDestilationTower extends TEmultiblockCoreTankWorkerPowered{
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesAtmosphericDestilationTower recipes = new RecipesAtmosphericDestilationTower();
	
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 1, 1, 1, 0);
		int tankPlating = IndustrialProcessing.blockTankPlating.blockID;
		
		int i = 0;
		layout.setCoreID(i++,0,1, IndustrialProcessing.blockAtmosphericDestilationTower.blockID);
		
		layout.setBlockID(-1, 0, -1,i++, 0,0, tankPlating);
		layout.setBlockID(-1, 0, 0,i++, 0,0, tankPlating);
		layout.setBlockID(-1, 0, 1,i++, 0,0, tankPlating);
		
		layout.setBlockID(1, 0, -1,i++, 0,0, tankPlating);
		layout.setBlockID(1, 0, 0,i++, 0,0, tankPlating);
		layout.setBlockID(1, 0, 1,i++, 0,0, tankPlating);
		
		layout.setBlockID(0, 0, -1,i++, 0,0, tankPlating);
		layout.setBlockID(0, 0, 1,i++, 0,0, tankPlating);
		
		layout.setBlockID(-1, 1, -1,i++, 0,0, tankPlating);
		layout.setBlockID(-1, 1, 0,i++, 0,0, tankPlating);
		layout.setBlockID(-1, 1, 1,i++, 0,0, tankPlating);
		
		layout.setBlockID(1, 1, -1,i++, 0,0, tankPlating);
		layout.setBlockID(1, 1, 0,i++, 0,0, tankPlating);
		layout.setBlockID(1, 1, 1,i++, 0,0, tankPlating);
		
		layout.setBlockID(0, 1, -1,i++, 0,0, tankPlating);
		layout.setBlockID(0, 1, 1,i++, 0,0, tankPlating);
		layout.setBlockID(0, 1, 0,i++, 0,0, IndustrialProcessing.blockDestilationTray.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);
		
		
		//set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	
	public TileEntityAtmosphericDestilationTower(){
		super(structure, tierRequirments,recipes, LocalDirection.LEFT,10000,100);
		
		LocalDirection[] nodirections = new LocalDirection[0];
		
		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);
		this.addTank(10000, 0, new ForgeDirection[]{ForgeDirection.NORTH}, true, false);
		this.addTank(10000, 0, new ForgeDirection[]{ForgeDirection.WEST}, false, true);
	}
	
	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0);
		super.updateEntity();
	};
	
	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) { // fluid input container input slot, only filled
			// containers with correct fluid
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}
	
	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

	@Override
	public boolean tankContains(int slot, int itemId, int amount) {
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
	
}
