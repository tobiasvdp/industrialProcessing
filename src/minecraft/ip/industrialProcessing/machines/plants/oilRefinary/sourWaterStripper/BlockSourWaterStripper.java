package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.electrolyser.TileEntityElectrolyser;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSourWaterStripper extends BlockMachineRendered {

	public BlockSourWaterStripper() {
		super(ConfigMachineBlocks.getSourWaterStripperBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "SourWaterStripper", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySourWaterStripper();
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererSourWaterStripperId();
    }

}
