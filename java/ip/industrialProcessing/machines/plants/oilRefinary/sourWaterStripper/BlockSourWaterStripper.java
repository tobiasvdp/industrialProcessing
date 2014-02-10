package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSourWaterStripper extends BlockMachineRendered {

	public BlockSourWaterStripper() {
		super(ConfigMachineBlocks.getSourWaterStripperBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "SourWaterStripper", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntitySourWaterStripper te = new TileEntitySourWaterStripper();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererSourWaterStripperId();
    }

}
