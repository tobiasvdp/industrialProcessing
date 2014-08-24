package mod.industrialProcessing.plants.industrialAge.windMill;

import net.minecraft.init.Blocks;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.plants.middleAge.tripHammer.RecipesTripHammer;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;

public class TileEntityWindMill extends TileEntityMultiblockCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 1, 0, 0, 4);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockWindMill);

		layout.setBlockID(0, -1, 0, i++, 0, 0, IndustrialProcessing.blockWoodenSupport);
		layout.setBlockID(0, -2, 0, i++, 0, 0, IndustrialProcessing.blockWoodenSupport);
		layout.setBlockID(0, -3, 0, i++, 0, 1, IndustrialProcessing.blockWoodenSupport);
		layout.setBlockID(0, -4, 0, i++, 0, 2, IndustrialProcessing.blockWoodenSupport);
		
		layout.setBlockID(0, 0, 1, i++, 0, 0, IndustrialProcessing.blockSails);
		

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TileEntityWindMill() {
		super(structure, tierRequirments);
	}
}
