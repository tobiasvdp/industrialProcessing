package ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAsphaltBlower  extends BlockMachineRendered {

	public BlockAsphaltBlower() {
		super(ConfigMachineBlocks.getAsphaltBlowerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "AsphaltBlower", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityAsphaltBlower te = new TileEntityAsphaltBlower();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererAsphaltBlowerId();
    }

}
