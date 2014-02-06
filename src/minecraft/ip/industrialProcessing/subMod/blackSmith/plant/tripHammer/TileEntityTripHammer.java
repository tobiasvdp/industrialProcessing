package ip.industrialProcessing.subMod.blackSmith.plant.tripHammer;

import net.minecraft.block.Block;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInvWorker;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.RecipesBloomery;

public class TileEntityTripHammer extends TileEntityMultiblockCoreInvWorker{
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesTripHammer();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 3, 1, 1, 1);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupBlackSmith.blockTripHammer.blockID);

		layout.setBlockID(1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(-1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(1, 1, 0, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(-1, 1, 0, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(1, 0, 1, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(-1, 0, 1, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(1, 1, 1, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		layout.setBlockID(-1, 1, 1, i++, 0, 0, ISetupBlackSmith.blockWoodenWheel.blockID);
		
		layout.setBlockID(0, 1, 0, i++, 0, 0, ISetupBlackSmith.blockWoodenBar.blockID);
		layout.setBlockID(0, 1, -1, i++, 0, 0, ISetupBlackSmith.blockWoodenBar.blockID);
		layout.setBlockID(0, 1, -2, i++, 0, 0, ISetupBlackSmith.blockWoodenBar.blockID);
		layout.setBlockID(0, 1, -3, i++, 0, 0, ISetupBlackSmith.blockWoodenHammer.blockID);
		layout.setBlockID(0, 0, -3, i++, 0, 0, Block.wood.blockID);
		layout.setBlockID(1, -1, -2, i++, 0, 0, Block.waterStill.blockID);
		layout.setBlockID(-1, -1, -2, i++, 0, 0, Block.waterStill.blockID);
		layout.setBlockID(1, -1, -1, i++, 0, 0, Block.waterMoving.blockID);
		layout.setBlockID(-1, -1, -1, i++, 0, 0, Block.waterMoving.blockID);
		layout.setBlockID(1, -1, 0, i++, 0, 0, Block.waterMoving.blockID);
		layout.setBlockID(-1, -1, 0, i++, 0, 0, Block.waterMoving.blockID);
		layout.setBlockID(1, -1, 1, i++, 0, 0, Block.waterMoving.blockID);
		layout.setBlockID(-1, -1, 1, i++, 0, 0, Block.waterMoving.blockID);
		

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TileEntityTripHammer() {
		super(structure, tierRequirments, recipes);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}
	
}
