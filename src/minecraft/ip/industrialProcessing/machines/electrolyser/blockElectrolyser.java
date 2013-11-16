package ip.industrialProcessing.machines.electrolyser;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class blockElectrolyser extends BlockMachineRendered {

	public blockElectrolyser() {
		super(ConfigMachineBlocks.getElectrolyserBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Electrolyser", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityElectrolyser te = new TileEntityElectrolyser();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererElectrolyserId();
    }
}
