package mod.industrialProcessing.plants.todo.core.plants.storage.container;

import net.minecraft.item.Item;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreInv;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class TileEntityContainer extends TileEntityMultiblockCoreInv {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 0, 5, 1, 1);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockContainer);
		for (int j = 0; j < 6; j++) {
			layout.setBlockIDwithGroup(1, 0, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(-1, 0, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(0, +1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(1, +1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(-1, +1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(0, -1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(1, -1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			layout.setBlockIDwithGroup(-1, -1, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
			if (j == 5)
				layout.setBlockIDwithGroup(0, 0, -j, i++, 0, 0, 0, IndustrialProcessing.blockContainerWall);
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
		for (int i = 0; i < 98; i++)
			addStack(null, 0, new LocalDirection[] { LocalDirection.BACK, LocalDirection.DOWN, LocalDirection.FRONT, LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.UP }, true, true);
	}

	@Override
	protected boolean isValidInput(int slot, Item itemID) {
		return true;
	}

}
