package mod.industrialProcessing.plants.todo.core.hotPress;

import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;

public class TEmultiblockHotPress extends TileEntityMultiblockCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 2, 0, 0, 0);
		
		int i = 0;
		layout.setCoreID(i++,0, 0, ISetupMachineBlocks.BLmultiblockHotPress.blockID);

		layout.setBlockID(0, 0, 1,i++, 0, 0, ISetupMachineBlocks.BlockFrame.blockID);
		layout.setBlockID(0, 0, 2,i++, 0, 0, ISetupMachineBlocks.BlockFrame.blockID);
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

		tierRequirments = new TierCollection(0);
	}

	public TEmultiblockHotPress() {
		super(structure,tierRequirments);
	}

}
