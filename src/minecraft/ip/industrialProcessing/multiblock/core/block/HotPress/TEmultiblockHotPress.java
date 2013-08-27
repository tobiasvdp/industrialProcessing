package ip.industrialProcessing.multiblock.core.block.hotPress;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.MultiblockTierRequirements;

public class TEmultiblockHotPress extends TEmultiblockCore {
	static StructureMultiblock structure;
	static MultiblockTierRequirements tierRequirments;
	static {
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 2, 0, 0, 0);
		
		int i = 0;
		layout.setCoreID(i++,0, 0, IndustrialProcessing.BLmultiblockHotPress.blockID);

		layout.setBlockID(0, 0, 1,i++, 0, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(0, 0, 2,i++, 0, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(-1, 0, 0, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(1, 0, 0, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(-1, 0, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(0, 0, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(1, 0, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(-1, 1, 0, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(0, 1, 0, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(1, 1, 0, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(-1, 1, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(0, 1, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);
		// layout.setBlockID(1, 1, -1, 0,0,
		// IndustrialProcessing.BLmultiblockFrame.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		tierRequirments = new MultiblockTierRequirements(0);
	}

	public TEmultiblockHotPress() {
		super(structure,tierRequirments);
	}

}
