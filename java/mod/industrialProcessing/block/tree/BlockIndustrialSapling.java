package mod.industrialProcessing.block.tree;

import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import mod.industrialProcessing.block.ConfigBlocks;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialSapling extends BlockSapling {

	private IIcon[] saplingIcon;

	public BlockIndustrialSapling() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2) {
		par2 %= this.saplingIcon.length;
		return this.saplingIcon[par2];
	}


	@Override
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.saplingIcon = new IIcon[IndustrialTrees.getTreeCount()];

		for (int i = 0; i < this.saplingIcon.length; ++i) {
			this.saplingIcon[i] = par1IconRegister.registerIcon(IndustrialTrees.getSaplingTexture(i));
		}
	}

	/**
	 * Determines if the same sapling is present at the given location.
	 */	
	@Override
	public boolean func_149851_a(World par1World, int par2, int par3, int par4, boolean par5) {
		return par1World.getBlock(par2, par3, par4) == this && par5;
	}

	@Override
	public void func_149853_b(World par1World, Random par5Random, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			if (par5Random.nextInt(5) == 0) {
				this.func_149852_a(par1World, par5Random, par3, par4, par2);
			}
		}
	}

	/**
	 * Attempts to grow a sapling into a tree
	 */
	@Override
	public boolean func_149852_a(World par1World, Random par5Random, int par2, int par3, int par4) {
		if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4))
			return false;

		int meta = par1World.getBlockMetadata(par2, par3, par4);
		WorldGenIndustrialTree tree = WorldGenIndustrialTree.Create(meta);
		return tree.generate(par1World, par5Random, par2, par3, par4);
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return true;
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}
}
