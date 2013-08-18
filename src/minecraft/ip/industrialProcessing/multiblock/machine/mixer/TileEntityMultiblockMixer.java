package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;

public class TileEntityMultiblockMixer extends TileEntityMultiblockCoreTank{
	private static MultiblockLayout structure;

	static { 
		int inputTankId = ConfigMachineBlocks.getBlockMultiblockTankInputID();
		int outputTankId = ConfigMachineBlocks.getBlockMultiblockTankOutputID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
		int outputInvId = ConfigMachineBlocks.getMultiMachineOutputBlockID(); 
		int inputInvId = ConfigMachineBlocks.getMultiMachineInputBlockID();
				
		structure = new MultiblockLayout();
		
		MultiblockStructure layout = new MultiblockStructure(2, 2, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockMultiblockMixer.blockID);
		layout.addBlockIDRelative(-1, 0, 0, inputTankId);
		layout.addBlockIDRelative(1, 0, 0, outputTankId);
		layout.addBlockIDRelative(0, 0, -1, inputInvId);
		layout.addBlockIDRelative(0, 0, 1, outputInvId);
		layout.fillLayer(-1, 0,-1, frameId);
		
		
		structure.commit(layout);	
	}
	public TileEntityMultiblockMixer() {
		super(structure);
		itemStacks.add(new MultiblockItemStack(true,false,0));
		itemStacks.add(new MultiblockItemStack(false,true,1));
		itemStacks.add(new MultiblockItemStack(true,false,2));
		itemStacks.add(new MultiblockItemStack(false,true,3));
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, false, true);
	}
    @Override
    public void updateEntity() {
    	addBucketToTank(0, 1, 0);
		getBucketFromTank(2, 3, 1);
	super.updateEntity();
    };
}
