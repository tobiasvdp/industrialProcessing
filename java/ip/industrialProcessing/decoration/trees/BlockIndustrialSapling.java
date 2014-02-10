package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;

import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndustrialSapling extends BlockSapling {

    private Icon[] saplingIcon;

    public BlockIndustrialSapling() {
        super(ConfigBlocks.getSaplingID());
        this.setCreativeTab(ISetupCreativeTabs.tabOres);
        this.setHardness(0.0F).setStepSound(soundGrassFootstep).setUnlocalizedName("sapling");
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2) {
        par2 %= this.saplingIcon.length;
        return this.saplingIcon[par2];
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < IndustrialTrees.getTreeCount(); i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {
        this.saplingIcon = new Icon[IndustrialTrees.getTreeCount()];

        for (int i = 0; i < this.saplingIcon.length; ++i) {
            this.saplingIcon[i] = par1IconRegister.registerIcon(IndustrialTrees.getSaplingTexture(i));
        }
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    @Override
	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
        return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4)) == par5;
    }

    @Override
    public void markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            if (par5Random.nextInt(5) == 0) {
                this.growTree(par1World, par2, par3, par4, par5Random);
            }
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    @Override
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4))
            return;

        int meta = par1World.getBlockMetadata(par2, par3, par4); 
        WorldGenIndustrialTree tree =  WorldGenIndustrialTree.Create(meta);
        tree.generate(par1World, par5Random, par2, par3, par4);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
        return true;
    }

    @Override
	public int damageDropped(int par1) {
        return par1;
    }
}
