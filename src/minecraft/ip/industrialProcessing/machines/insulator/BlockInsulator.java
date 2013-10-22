package ip.industrialProcessing.machines.insulator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class BlockInsulator extends BlockMachineRendered{
	public BlockInsulator() {
		super(ConfigMachineBlocks.getInsulatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Insulator", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityInsulator();
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererInsulatorID();
    }
}
