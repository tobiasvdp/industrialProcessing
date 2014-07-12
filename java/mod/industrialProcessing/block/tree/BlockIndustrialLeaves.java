package mod.industrialProcessing.block.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import mod.industrialProcessing.block.ConfigBlocks;
import mod.industrialProcessing.block.ISetupBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialLeaves extends BlockLeaves {

	private IIcon[] icons;
	private IIcon[] icons_opaque;

	public BlockIndustrialLeaves() {
		super();
		this.setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass);
	}

	@SideOnly(Side.CLIENT)
	@Override
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	public int getRenderColor(int par1) {

		int color = IndustrialTrees.getColor(par1);

		int r = (color >> 4) & 255;
		int g = (color >> 2) & 255;
		int b = color & 255;

		r *= 2;
		g *= 2;
		b *= 2;

		r += 0x27;
		g += 0x3e;
		b += 0x0a;

		return (r / 3) << 4 + (g / 3) << 2 + b / 3;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(ISetupBlocks.blockSapling);
	}

	@Override
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
		super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	@Override
	public IIcon getIcon(int par1, int par2) {
		par2 = par2 % IndustrialTrees.getTreeCount();
		if (this.field_150121_P)
			return this.icons_opaque[par2];
		else
			return this.icons[par2];
	}

	@Override
	public boolean isOpaqueCube() {
		return field_150121_P;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return !this.field_150121_P;
	}

	@Override
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		int color = IndustrialTrees.getColor(meta);
		int i1 = ((color >> 16) & 255) * 6;
		int j1 = ((color >> 8) & 255) * 6;
		int k1 = (color & 255) * 6;

		for (int l1 = -1; l1 <= 1; ++l1) {
			for (int i2 = -1; i2 <= 1; ++i2) {
				int j2 = par1IBlockAccess.getBiomeGenForCoords(par2 + i2, par4 + l1).getBiomeFoliageColor(par2 + i2, par3, par4 + l1);
				i1 += (j2 & 16711680) >> 16;
				j1 += (j2 & 65280) >> 8;
				k1 += j2 & 255;
			}
		}

		return (i1 / 15 & 255) << 16 | (j1 / 15 & 255) << 8 | k1 / 15 & 255;
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		if (!par1World.isRemote) {
			int j1 = 20;

			if (par7 > 0) {
				j1 -= 2 << par7;

				if (j1 < 10) {
					j1 = 10;
				}
			}

			if (par1World.rand.nextInt(j1) == 0) {
				Item k1 = this.getItemDropped(par5, par1World.rand, par7);
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
			}

			j1 = 200;

			if (par7 > 0) {
				j1 -= 10 << par7;

				if (j1 < 40) {
					j1 = 40;
				}
			}

			if ((par5) == 0 && par1World.rand.nextInt(j1) == 0) {
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.apple, 1, 0));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.icons = new IIcon[IndustrialTrees.getTreeCount()];
		this.icons_opaque = new IIcon[IndustrialTrees.getTreeCount()];
		for (int i = 0; i < icons.length; i++) {
			this.icons[i] = par1IconRegister.registerIcon(IndustrialTrees.getLeavesTexture(i, false));
			this.icons_opaque[i] = par1IconRegister.registerIcon(IndustrialTrees.getLeavesTexture(i, true));
		}
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return true;
	}

	@Override
	public String[] func_150125_e() {
		return null;
	}
}
