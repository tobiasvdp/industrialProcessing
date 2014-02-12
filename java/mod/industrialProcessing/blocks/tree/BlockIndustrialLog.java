package mod.industrialProcessing.blocks.tree;

import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialLog extends BlockLog {

	private IIcon[] tree_side;
	private IIcon[] tree_top;

	public BlockIndustrialLog() {
		super();
	}

	/**
	 * When this method is called, your block should register all the icons it
	 * needs with the given IconRegister. This is the only chance you get to
	 * register icons.
	 */
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.tree_side = new IIcon[IndustrialTrees.getTreeCount()];
		this.tree_top = new IIcon[IndustrialTrees.getTreeCount()];

		for (int i = 0; i < this.tree_side.length; ++i) {
			this.tree_side[i] = par1IconRegister.registerIcon(IndustrialTrees.getLogSideTexture(i));
			this.tree_top[i] = par1IconRegister.registerIcon(IndustrialTrees.getLogTopTexture(i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * The icon for the side of the block.
	 */
	protected IIcon getSideIcon(int par1) {
		return this.tree_side[par1];
	}

	@SideOnly(Side.CLIENT)
	/**
	 * The icon for the tops and bottoms of the block.
	 */
	protected IIcon getEndIcon(int par1) {
		return this.tree_top[par1];
	}
	
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.tree_top[p_150161_1_];
    }

	@Override
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
		super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return true;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}
}
