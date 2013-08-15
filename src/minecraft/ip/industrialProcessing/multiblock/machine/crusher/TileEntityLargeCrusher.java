package ip.industrialProcessing.multiblock.machine.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.MultiblockStructure;
import ip.industrialProcessing.multiblock.utils.MultiblockUtils;

public class TileEntityLargeCrusher extends TileEntityMultiblockCore {

	private static MultiblockLayout structure;

	static { 
		int inputId = ConfigMachineBlocks.getMultiMachineInputBlockID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
				
		structure = new MultiblockLayout();
		
		MultiblockStructure layout = new MultiblockStructure(1, 1, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockLargeCrusher.blockID);
		layout.addBlockIDRelative(-1, 0, 0, inputId);
		layout.fillLayer(-1, 0, -1, frameId);
		
		
		structure.commit(layout);	
	}

	public TileEntityLargeCrusher() {
		super(structure);
	}
	 

}
