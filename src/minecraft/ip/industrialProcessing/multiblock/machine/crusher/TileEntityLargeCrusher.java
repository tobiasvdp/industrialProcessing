package ip.industrialProcessing.multiblock.machine.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.multiblock.MultiblockStructure;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.MultiblockUtils;

public class TileEntityLargeCrusher extends TileEntityMultiblockCore {

	private static MultiblockLayout structure;

	static { 
		int inputId = ConfigMachineBlocks.getMultiMachineInputBlockID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
				
		structure = new MultiblockLayout();
		
		MultiblockStructure layout = new MultiblockStructure(2, 1, 1, 1, 1, 1);
		layout.setCoreID(IndustrialProcessing.blockLargeCrusher.blockID);
		layout.addBlockIDRelative(-1, 0,  0,inputId);
		layout.addBlockIDRelative(-2, 0,  0,inputId);
		layout.addBlockIDRelative(1,  0,  0,inputId);
		layout.addBlockIDRelative(0, -1,  0,inputId);
		layout.addBlockIDRelative(0,  1,  0,inputId);
		layout.addBlockIDRelative(0,  0, -1,inputId);
		layout.addBlockIDRelative(0,  0,  1,inputId);
		layout.fillBlockID(frameId);
		
		structure.commit(layout);	
	}

	public TileEntityLargeCrusher() {
		super(structure);
	}
	 

}
