package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.IndustrialProcessing;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockIndustrialLog extends BlockLog {

	private String[] woodType = new String[] { "rubber" };
	private Icon[] tree_side;
	private Icon[] tree_top;

	protected BlockIndustrialLog(int par1) {
		super(par1);
		this.setCreativeTab(IndustrialProcessing.tabOres);
	}

	/**
	 * When this method is called, your block should register all the icons it
	 * needs with the given IconRegister. This is the only chance you get to
	 * register icons.
	 */
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.tree_side = new Icon[woodType.length];
		this.tree_top = new Icon[woodType.length];

		for (int i = 0; i < this.tree_side.length; ++i) {
			this.tree_side[i] = par1IconRegister.registerIcon(this.func_111023_E() + "_" + woodType[i]);
			this.tree_top[i] = par1IconRegister.registerIcon(this.func_111023_E() + "_" + woodType[i] + "_top");
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	protected Icon func_111048_c(int par1) {
		return this.tree_side[par1];
	}

	@SideOnly(Side.CLIENT)
	@Override
	protected Icon func_111049_d(int par1) {
		return this.tree_top[par1];
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks, this returns 1 block)
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
}
