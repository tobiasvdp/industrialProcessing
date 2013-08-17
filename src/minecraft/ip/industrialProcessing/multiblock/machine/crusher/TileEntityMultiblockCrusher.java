package ip.industrialProcessing.multiblock.machine.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;

public class TileEntityMultiblockCrusher extends TileEntityMultiblockCoreInv {

	private static MultiblockLayout structure;

	static { 
		int inputId = ConfigMachineBlocks.getMultiMachineInputBlockID();
		int outputId = ConfigMachineBlocks.getMultiMachineOutputBlockID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
				
		structure = new MultiblockLayout();
		
		MultiblockStructure layout = new MultiblockStructure(1, 1, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockLargeCrusher.blockID);
		layout.addBlockIDRelative(-1, 0, 0, inputId);
		layout.addBlockIDRelative(1, 0, 0, outputId);
		layout.fillLayer(-1, 0, -1, frameId);
		
		
		structure.commit(layout);	
	}

	public TileEntityMultiblockCrusher() {
		super(structure);
		itemStacks.add(new MultiblockItemStack(true,false,0));
		itemStacks.add(new MultiblockItemStack(false,true,1));
	}
}
