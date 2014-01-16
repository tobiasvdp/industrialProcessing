package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorBelt extends BlockConveyorBase {

	public BlockConveyorBelt() {
		super(ConfigMachineBlocks.getBlockTransportConveyorBelt(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor", ISetupCreativeTabs.tabPower);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorBelt();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererConveyorBeltID();
	}

}
