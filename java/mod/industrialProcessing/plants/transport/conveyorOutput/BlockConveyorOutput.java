package mod.industrialProcessing.plants.transport.conveyorOutput;

import java.util.List;

import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorOutput extends BlockConveyorBase {

	public BlockConveyorOutput() {
		super(5.0f,5.0f, Material.iron, Block.soundTypeMetal, "conveyor","tankSide","conveyorHopperFeatures");
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
