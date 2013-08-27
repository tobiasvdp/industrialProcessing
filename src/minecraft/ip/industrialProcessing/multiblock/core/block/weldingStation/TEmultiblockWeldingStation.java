package ip.industrialProcessing.multiblock.core.block.weldingStation;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;

public class TEmultiblockWeldingStation extends TEmultiblockCore{
	static StructureMultiblock structure;
	static{
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(1, 0, 0, 0, 1, 0);
		layout.setCoreID(0,1, IndustrialProcessing.BLmultiblockWeldingStation.blockID);
		
		layout.setBlockID(-1, 0, 0, 0,0, IndustrialProcessing.BLmultiblockWeldingTableExt.blockID);
		layout.setBlockID(0, 1, 0, 0,0, IndustrialProcessing.BLmultiblockScreen.blockID);
		layout.setBlockID(-1, 1, 0, 0,1, IndustrialProcessing.BLmultiblockScreen.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

	}
	public TEmultiblockWeldingStation() {
		super(structure);
	}

}
