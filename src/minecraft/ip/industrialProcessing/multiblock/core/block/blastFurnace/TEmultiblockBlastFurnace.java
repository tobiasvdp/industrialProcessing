package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;

public class TEmultiblockBlastFurnace extends TEmultiblockCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 1, 0);
		
		int i = 0;
		layout.setCoreID(i++,0,0, IndustrialProcessing.BLmultiblockBlastFurnace.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);
		
		
		//set tiers
		tierRequirments = new TierCollection(1);
		
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);

	}
	public TEmultiblockBlastFurnace() {
		super(structure, tierRequirments);
	}
}
