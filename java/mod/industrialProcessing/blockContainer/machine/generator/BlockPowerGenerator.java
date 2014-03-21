package mod.industrialProcessing.blockContainer.machine.generator;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public abstract class BlockPowerGenerator extends BlockContainerIPRendered {

	public BlockPowerGenerator(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness,resistance,material,soundtype,iconNames);
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		TileEntityPowerGenerator generator = (TileEntityPowerGenerator) par1World.getTileEntity(par2, par3, par4);
		generator.searchForPowerAcceptors();
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	}
}
