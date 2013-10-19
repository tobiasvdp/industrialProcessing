package ip.industrialProcessing.power.wire;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.rendering.BlockModelUtils;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWireWood extends BlockWire {

    public BlockWireWood() {
        super(ConfigMachineBlocks.getWireWoodBlockID(), Material.wood, Block.soundWoodFootstep, "Wood-embedded Wire");
    }

    public void getSubBlocks(int par1, net.minecraft.creativetab.CreativeTabs par2CreativeTabs, List par3List) {
        BlockModelUtils.getWoodSubBlocks(par1, par2CreativeTabs, par3List);
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
}
