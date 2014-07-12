package mod.industrialProcessing.blockContainer.machine.power.generator;

import java.util.Random;

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
		par1World.scheduleBlockUpdate(par2, par3, par4, this, 1);
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random p_149674_5_) {
		TileEntityPowerGenerator generator = (TileEntityPowerGenerator) par1World.getTileEntity(par2, par3, par4);
		generator.searchForPowerAcceptors();
		super.updateTick(par1World, par2, par3, par4, p_149674_5_);
	}
}
