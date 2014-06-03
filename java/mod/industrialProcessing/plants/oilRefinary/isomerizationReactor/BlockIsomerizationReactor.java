package ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockIsomerizationReactor  extends BlockMachineRendered {

	public BlockIsomerizationReactor() {
		super(ConfigMachineBlocks.getIsomerizationReactorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "IsomerizationReactor", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityIsomerizationReactor te= new TileEntityIsomerizationReactor();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererIsomerizationReactorId();
    }

}
