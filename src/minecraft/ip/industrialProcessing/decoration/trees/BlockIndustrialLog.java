package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialLog extends BlockLog {

    private Icon[] tree_side;
    private Icon[] tree_top;

    public BlockIndustrialLog() {
        super(ConfigBlocks.getLogID());
        this.setCreativeTab(ISetupCreativeTabs.tabOres);
        this.setHardness(2.0F).setStepSound(soundWoodFootstep).setUnlocalizedName("log");
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.tree_side = new Icon[IndustrialTrees.getTreeCount()];
        this.tree_top = new Icon[IndustrialTrees.getTreeCount()];

        for (int i = 0; i < this.tree_side.length; ++i) {
            this.tree_side[i] = par1IconRegister.registerIcon(IndustrialTrees.getLogSideTexture(i));
            this.tree_top[i] = par1IconRegister.registerIcon(IndustrialTrees.getLogTopTexture(i));
        }
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * The icon for the side of the block.
     */
    protected Icon getSideIcon(int par1)
    {
        return this.tree_side[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * The icon for the tops and bottoms of the block.
     */
    protected Icon getEndIcon(int par1)
    {
        return this.tree_top[par1];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood
     * returns 4 blocks, this returns 1 block)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
        return true;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.blockID;
    }

    @Override
    public int idPicked(World par1World, int par2, int par3, int par4) {
        return this.blockID;
    }

    @Override
	public int damageDropped(int par1) {
        return par1;
    }
}
