package mod.industrialProcessing.plants.transport.conveyorChute;

import java.util.List;

import javax.swing.Icon;

import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorBase;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorChute extends BlockConveyorBase {

    public BlockConveyorChute() {
        super(5.0f,5.0f, Material.iron, Block.soundTypeMetal, "conveyor","conveyorHopperFeatures","chute");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
        setBlockBounds(0, 0, 0, 1, 1, 1);       
    }
    
    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
         
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }
    
}
