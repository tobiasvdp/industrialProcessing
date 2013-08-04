package ip.industrialProcessing.machines.magneticSeparator;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagneticSeparator extends BlockMachine {

	public BlockMagneticSeparator() {
		super(IndustrialProcessingConfig.getMagneticSeparatorBlockID(), Material.iron, 1F,
				Block.soundMetalFootstep, "Ore Filter",
				IndustrialProcessing.tabMachines);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMagneticSeparator();
	}
}
