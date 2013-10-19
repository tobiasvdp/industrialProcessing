package ip.industrialProcessing.transport.fluids;

import java.util.List;

import ip.industrialProcessing.config.ConfigTransportBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTransportFluidsStone extends BlockTransportFluids {

    public BlockTransportFluidsStone() {
        super(ConfigTransportBlocks.getBlockTransportFluidsStoneID(), Material.rock, Block.soundStoneFootstep, "Stone-embedded Fluid Pipe");
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
        setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
        AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
        if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
            par6List.add(axisalignedbb1);
        }
    }

    @Override
    public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int colour) {
        return false;
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }
    
    public void getSubBlocks(int par1, net.minecraft.creativetab.CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0)); // smoothstone
        par3List.add(new ItemStack(par1, 1, 1)); // cobblestone
        par3List.add(new ItemStack(par1, 1, 2)); // mossy cobblestone
        par3List.add(new ItemStack(par1, 1, 3)); // stone brick
        par3List.add(new ItemStack(par1, 1, 4)); // mossy stone brick
        par3List.add(new ItemStack(par1, 1, 5)); // cracked stone brick
        par3List.add(new ItemStack(par1, 1, 6)); // carved stone brick
        par3List.add(new ItemStack(par1, 1, 7)); // clay brick
    };

    @Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        return par9;
    }
}
