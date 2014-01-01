package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBloomery extends BLmultiblockCore implements IRecipeBlock{

	private Icon[] icons = new Icon[1];

	public BlockBloomery() {
		super(ConfigMachineBlocks.getBlockBloomeryID(), "BlockBloomery", IndustrialProcessing.tabMultiblocks);
		this.setTickRandomly(true);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityBloomery te = new TileEntityBloomery();
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererBloomeryId();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Bloomery");
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityBloomery te = (TileEntityBloomery) par1World.getBlockTileEntity(par2, par3, par4);
		if (te.getHeat() > 1538) {
			double d0 = (double) ((float) par2 + 0.5F);
			double d1 = (double) ((float) par3 + 0.1F);
			double b1 = (double) ((float) par3 + 0.8F);
			double d2 = (double) ((float) par4 + 0.5F);
			par1World.spawnParticle("smoke", d0, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0 - 0.1f, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0 + 0.1f, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0, b1, d2 + 0.1f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0, b1, d2 - 0.1f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 - 0.2f, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 + 0.2f, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2 + 0.2f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2 - 0.2f, 0.0D, 0.0D, 0.0D);
		}
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntityBloomery te = (TileEntityBloomery) world.getBlockTileEntity(x, y, z);
		if (te.getHeat() > 1538) {
			return 10;
		}
		return 0;
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityBloomery.recipesStatic;
	}

}
