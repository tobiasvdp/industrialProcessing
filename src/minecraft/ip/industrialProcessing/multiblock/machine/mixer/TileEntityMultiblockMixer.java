package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;

public class TileEntityMultiblockMixer extends TileEntityMultiblockCoreTank{
	private static MultiblockLayout structure;

	static { 
		int inputId = ConfigMachineBlocks.getBlockMultiblockTankInputID();
		int outputId = ConfigMachineBlocks.getBlockMultiblockTankOutputID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
				
		structure = new MultiblockLayout();
		
		MultiblockStructure layout = new MultiblockStructure(2, 2, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockMultiblockMixer.blockID);
		layout.addBlockIDRelative(-1, 0, 0, inputId);
		layout.addBlockIDRelative(1, 0, 0, outputId);
		layout.fillLayer(-1, 0,-1, frameId);
		
		
		structure.commit(layout);	
	}
	public TileEntityMultiblockMixer() {
		super(structure);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, false, true);
	}
}
