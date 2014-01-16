package ip.industrialProcessing.decoration.trees;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPineLog extends Block {

    private Icon top_icon;
    private Icon side_icon;
    private Icon side_carved_icon;

    public BlockPineLog() {
        super(ConfigBlocks.getPineLogID(), Material.wood);
        this.setHardness(2.0F).setStepSound(soundWoodFootstep).setUnlocalizedName("pine log");
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

        ItemStack playerStack = par5EntityPlayer.inventory.getCurrentItem();
        if (playerStack != null) {
            if (playerStack.itemID == ISetupItems.itemKnife.itemID) {
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
    public Icon getIcon(int par1, int par2) {
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
    public void registerIcons(IconRegister par1IconRegister) {
        this.side_icon = par1IconRegister.registerIcon(IndustrialTrees.getLogSideTexture(1));
        this.top_icon = par1IconRegister.registerIcon(IndustrialTrees.getLogTopTexture(1));
        this.side_carved_icon = par1IconRegister.registerIcon(IndustrialTrees.getSpecialLogSideTexture(1, "carved"));
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
        return true;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
	public int idDropped(int par1, Random par2Random, int par3) {
        return ConfigBlocks.getLogID();
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
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        byte b0 = 4;
        int j1 = b0 + 1;

        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1)) {
            for (int k1 = -b0; k1 <= b0; ++k1) {
                for (int l1 = -b0; l1 <= b0; ++l1) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

                        if (Block.blocksList[j2] != null) {
                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                        }
                    }
                }
            }
        }
    }

}
