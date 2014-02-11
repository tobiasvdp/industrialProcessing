package mod.industrialProcessing.blocks.tree;

import java.util.Random;

import mod.industrialProcessing.blocks.BlockIP;
import mod.industrialProcessing.blocks.ConfigBlocks;
import mod.industrialProcessing.blocks.ISetupBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPineLog extends BlockIP {

	private IIcon top_icon;
	private IIcon side_icon;
	private IIcon side_carved_icon;

	public BlockPineLog() {
		super(1.0f, 1.0f, Material.wood, Block.soundTypeWood);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		ItemStack playerStack = par5EntityPlayer.inventory.getCurrentItem();
		if (playerStack != null) {
			if (playerStack == ISetupItems.itemKnife) {
				if (par6 > 1) {
					int meta = par1World.getBlockMetadata(par2, par3, par4);

					int bit = (1 << (par6 - 2));

					if ((meta & bit) == 0) {
						meta = meta | bit;
						playerStack.damageItem(1, par5EntityPlayer);
						par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 3);
					}
				}
			}
		}
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

	public static boolean isCarved(World par1World, int i, int j, int k, int par5) {
		int meta = par1World.getBlockMetadata(i, j, k);
		return isSideCarved(par5, meta);
	}

	public static boolean isSideCarved(int side, int meta) {
		if (side < 2)
			return false;
		return (meta & 1 << side - 2) != 0;
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		if (par1 <= 1)
			return top_icon;
		else {
			if (!isSideCarved(par1, par2))
				return side_icon;
			else
				return side_carved_icon;
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.side_icon = par1IconRegister.registerIcon(IndustrialTrees.getLogSideTexture(1));
		this.top_icon = par1IconRegister.registerIcon(IndustrialTrees.getLogTopTexture(1));
		this.side_carved_icon = par1IconRegister.registerIcon(IndustrialTrees.getSpecialLogSideTexture(1, "carved"));
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return true;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(ISetupBlocks.blockLog);
	}

	@Override
	public int damageDropped(int par1) {
		return 1; // PINE TREE LOGS
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block p_149749_5_, int p_149749_6_) {
		byte b0 = 4;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1)) {
			for (int k1 = -b0; k1 <= b0; ++k1) {
				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						Block j2 = par1World.getBlock(par2 + k1, par3 + l1, par4 + i2);

						if (j2 != null) {
							j2.beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}

}
