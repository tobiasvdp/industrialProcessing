package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;

public class BlockGenerator extends BlockPowerGenerator {

	public BlockGenerator() {
		super(ConfigMachineBlocks.getGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Generator", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGenerator();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererBCGeneratorId();
	}
}
