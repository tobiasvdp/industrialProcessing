package ip.industrialProcessing.transport.items.conveyorInput;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorInput extends BlockConveyorBase{

	public BlockConveyorInput() {
		super(ConfigMachineBlocks.getBLtransportConveyorBeltInput(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Input", ISetupCreativeTabs.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorInput();
	}

	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererConveyorInputID();
	}
	
	@Override
	public boolean renderAsNormalBlock() {
	    return false;
	}
}
