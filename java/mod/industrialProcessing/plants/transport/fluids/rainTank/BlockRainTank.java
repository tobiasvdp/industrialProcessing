package mod.industrialProcessing.plants.transport.fluids.rainTank;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRainTank extends BlockContainerIPRendered {

    public BlockRainTank() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "tankFeatures","tankSide","fullPipe");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        // no gui
        return false;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        TileEntityRainTank rainTank = (TileEntityRainTank) par1World.getTileEntity(par2, par3, par4);
        rainTank.searchForConnections();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
        TileEntityRainTank rainTank = (TileEntityRainTank) world.getTileEntity(x, y, z);
        rainTank.searchForConnections();
    }
}
