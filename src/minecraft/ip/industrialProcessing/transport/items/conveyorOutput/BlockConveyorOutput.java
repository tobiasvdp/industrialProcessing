package ip.industrialProcessing.transport.items.conveyorOutput;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorOutput extends BlockConveyorBase {

	public BlockConveyorOutput() {
		super(ConfigMachineBlocks.getBLtransportConveyorBeltOutput(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Output", IndustrialProcessing.tabPower);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererConveyorOutputID();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorOutput();
	}

}
