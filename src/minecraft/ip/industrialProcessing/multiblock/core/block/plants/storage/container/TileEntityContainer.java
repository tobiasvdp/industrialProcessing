package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;

public class TileEntityContainer extends TileEntityMultiblockCoreInv {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 0, 5, 1, 1);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockContainer.blockID);
		for (int j = 0; j < 6; j++) {
			layout.setBlockIDwithGroup(1, 0, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(-1, 0, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(0, +1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(1, +1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(-1, +1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(0, -1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(1, -1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			layout.setBlockIDwithGroup(-1, -1, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
			if (j == 5)
				layout.setBlockIDwithGroup(0, 0, -j, i++, 0, 0,0, IndustrialProcessing.blockContainerWall.blockID);
		}

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityContainer() {
		super(structure, tierRequirments, null);
		LocalDirection[] nodirections = new LocalDirection[0];
		setInventoryGroupArray(1);
		for (int i = 0; i < 117; i++)
			addStack(null,0, new LocalDirection[]{LocalDirection.BACK,LocalDirection.DOWN,LocalDirection.FRONT,LocalDirection.LEFT,LocalDirection.RIGHT,LocalDirection.UP}, true, true);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return true;
	}

}
