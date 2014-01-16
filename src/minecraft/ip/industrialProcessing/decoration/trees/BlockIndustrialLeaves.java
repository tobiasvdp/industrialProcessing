package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialLeaves extends BlockLeaves {

    private Icon[] icons;
    private Icon[] icons_opaque;

    public BlockIndustrialLeaves() {
        super(ConfigBlocks.getLeavesID());
        this.setCreativeTab(ISetupCreativeTabs.tabOres);
        this.setHardness(0.2F).setLightOpacity(1).setStepSound(soundGrassFootstep).setUnlocalizedName("leaves");
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

        r*=2;
        g*=2;
        b*=2;
        
        r += 0x27;
        g += 0x3e;
        b += 0x0a;

        return (r / 3) << 4 + (g / 3) << 2 + b / 3;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ConfigBlocks.getSaplingID();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
        return ret;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    @Override
	public Icon getIcon(int par1, int par2) {
        par2 = par2 % IndustrialTrees.getTreeCount();
        if (this.graphicsLevel)
            return this.icons_opaque[par2];
        else
            return this.icons[par2];
    }

    @Override
    public boolean isOpaqueCube() {
        return graphicsLevel;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return !this.graphicsLevel;
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
                int j2 = par1IBlockAccess.getBiomeGenForCoords(par2 + i2, par4 + l1).getBiomeFoliageColor();
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
                int k1 = this.idDropped(par5, par1World.rand, par7);
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
            }

            j1 = 200;

            if (par7 > 0) {
                j1 -= 10 << par7;

                if (j1 < 40) {
                    j1 = 40;
                }
            }

            if ((par5) == 0 && par1World.rand.nextInt(j1) == 0) {
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.appleRed, 1, 0));
            }
        }
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {
        this.icons = new Icon[IndustrialTrees.getTreeCount()];
        this.icons_opaque = new Icon[IndustrialTrees.getTreeCount()];
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
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
        return true;
    }
}
