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

public class TileEntityAtmosphericDestilationTower extends TEmultiblockCoreTankWorkerPowered {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesAtmosphericDestilationTower recipes = new RecipesAtmosphericDestilationTower();

	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 1, 1, 6, 0);
		int tankPlating = IndustrialProcessing.blockTankPlating.blockID;

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockAtmosphericDestilationTower.blockID);

		layout.setBlockIDwithGroup(-1, 0, -1, i++, 0, 0,1, tankPlating);
		layout.setBlockIDwithGroup(-1, 0, 0, i++, 0, 0,1, tankPlating);
		layout.setBlockIDwithGroup(-1, 0, 1, i++, 0, 0,1, tankPlating);

		layout.setBlockIDwithGroup(1, 0, -1, i++, 0, 0,1, tankPlating);
		layout.setBlockIDwithGroup(1, 0, 0, i++, 0, 0,1, tankPlating);
		layout.setBlockIDwithGroup(1, 0, 1, i++, 0, 0,1, tankPlating);

		layout.setBlockIDwithGroup(0, 0, -1, i++, 0, 0,1, tankPlating);
		layout.setBlockIDwithGroup(0, 0, 1, i++, 0, 0,1, tankPlating);

		// layer 1
		layout.setBlockIDwithGroup(-1, 1, -1, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(-1, 1, 0, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(-1, 1, 1, i++, 0, 0,2, tankPlating);

		layout.setBlockIDwithGroup(1, 1, -1, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(1, 1, 0, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(1, 1, 1, i++, 0, 0,2, tankPlating);

		layout.setBlockIDwithGroup(0, 1, -1, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(0, 1, 1, i++, 0, 0,2, tankPlating);
		layout.setBlockIDwithGroup(0, 1, 0, i++, 0, 0,2, IndustrialProcessing.blockDestilationTray.blockID);

		// layer 2
		layout.setBlockIDwithGroup(-1, 2, -1, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(-1, 2, 0, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(-1, 2, 1, i++, 0, 0,3, tankPlating);

		layout.setBlockIDwithGroup(1, 2, -1, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(1, 2, 0, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(1, 2, 1, i++, 0, 0,3, tankPlating);

		layout.setBlockIDwithGroup(0, 2, -1, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(0, 2, 1, i++, 0, 0,3, tankPlating);
		layout.setBlockIDwithGroup(0, 2, 0, i++, 0, 0,3, IndustrialProcessing.blockDestilationTray.blockID);

		// layer 3
		layout.setBlockIDwithGroup(-1, 3, -1, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(-1, 3, 0, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(-1, 3, 1, i++, 0, 0,4, tankPlating);

		layout.setBlockIDwithGroup(1, 3, -1, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(1, 3, 0, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(1, 3, 1, i++, 0, 0,4, tankPlating);

		layout.setBlockIDwithGroup(0, 3, -1, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(0, 3, 1, i++, 0, 0,4, tankPlating);
		layout.setBlockIDwithGroup(0, 3, 0, i++, 0, 0,4, IndustrialProcessing.blockDestilationTray.blockID);

		// layer 4
		layout.setBlockIDwithGroup(-1, 4, -1, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(-1, 4, 0, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(-1, 4, 1, i++, 0, 0,5, tankPlating);

		layout.setBlockIDwithGroup(1, 4, -1, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(1, 4, 0, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(1, 4, 1, i++, 0, 0,5, tankPlating);

		layout.setBlockIDwithGroup(0, 4, -1, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(0, 4, 1, i++, 0, 0,5, tankPlating);
		layout.setBlockIDwithGroup(0, 4, 0, i++, 0, 0,5, IndustrialProcessing.blockDestilationTray.blockID);

		// layer 5
		layout.setBlockIDwithGroup(-1, 5, -1, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(-1, 5, 0, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(-1, 5, 1, i++, 0, 0,6, tankPlating);

		layout.setBlockIDwithGroup(1, 5, -1, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(1, 5, 0, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(1, 5, 1, i++, 0, 0,6, tankPlating);

		layout.setBlockIDwithGroup(0, 5, -1, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(0, 5, 1, i++, 0, 0,6, tankPlating);
		layout.setBlockIDwithGroup(0, 5, 0, i++, 0, 0,6, IndustrialProcessing.blockDestilationTray.blockID);

		// layer 6
		layout.setBlockIDwithGroup(-1, 6, -1, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(-1, 6, 0, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(-1, 6, 1, i++, 0, 0,7, tankPlating);

		layout.setBlockIDwithGroup(1, 6, -1, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(1, 6, 0, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(1, 6, 1, i++, 0, 0,7, tankPlating);

		layout.setBlockIDwithGroup(0, 6, -1, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(0, 6, 1, i++, 0, 0,7, tankPlating);
		layout.setBlockIDwithGroup(0, 6, 0, i++, 0, 0,8, tankPlating);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityAtmosphericDestilationTower() {
		super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);

		LocalDirection[] nodirections = new LocalDirection[0];

		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);
		this.addTank(10000, 1, ForgeDirection.VALID_DIRECTIONS, true, false);
		this.addTank(5000, 0, new ForgeDirection[] { ForgeDirection.DOWN }, false, true);
		this.addTank(10000, 2, ForgeDirection.VALID_DIRECTIONS, false, true);
		this.addTank(10000, 3, ForgeDirection.VALID_DIRECTIONS, false, true);
		this.addTank(10000, 4, ForgeDirection.VALID_DIRECTIONS, false, true);
		this.addTank(10000, 5, ForgeDirection.VALID_DIRECTIONS, false, true);
		this.addTank(10000, 6, ForgeDirection.VALID_DIRECTIONS, false, true);
		this.addTank(5000, 8, new ForgeDirection[] { ForgeDirection.UP }, false, true);
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
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		if(groupid == -1)
			return recipes.isValidFluidInput(slot, fluidId);
		else{
			if(getTankInSlot(slot).getMultiblockID() == groupid){
				return recipes.isValidFluidInput(slot, fluidId);
			}else{
				return false;
			}
		}
	}

}
