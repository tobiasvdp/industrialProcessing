package ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class BlockTricklingFilter extends BlockMachineRendered{
	public BlockTricklingFilter() {
		super(ConfigMachineBlocks.getTricklingFilterID(), Material.iron, 1F, Block.soundMetalFootstep, "TricklingFilter", IndustrialProcessing.tabOreProcessing);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTricklingFilter();
	}
	
    @Override
    public int getRenderType()
    {
        return 0;
    }
}