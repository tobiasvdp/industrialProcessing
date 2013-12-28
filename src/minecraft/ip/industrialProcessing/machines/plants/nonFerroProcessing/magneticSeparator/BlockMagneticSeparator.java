package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagneticSeparator extends BlockMachineRendered {

	public BlockMagneticSeparator() {
		super(ConfigMachineBlocks.getMagneticSeparatorBlockID(), Material.iron, 1F,
				Block.soundMetalFootstep, "Magnetic Ore Separator",
				IndustrialProcessing.tabOreProcessing);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityMagneticSeparator te = new TileEntityMagneticSeparator();
		te.setName(getLocalizedName());
		return te;
	}
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererMagneticSeperatorId();
    }
}