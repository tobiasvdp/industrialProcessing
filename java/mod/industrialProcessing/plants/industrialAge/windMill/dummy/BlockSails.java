package mod.industrialProcessing.plants.industrialAge.windMill.dummy;

import java.util.List;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSails extends BlockMultiblockDummy {

	public BlockSails() {
		super(1.0f, 1.0f, Material.wood, Block.soundTypeWood, "Bronze", "Planks2", "Canvas");
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		TileEntitySails te = (TileEntitySails) world.getTileEntity(x, y, z);
		te.destroyEntity();
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
		// TODO Auto-generated method stub
		super.setBlockBoundsBasedOnState(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_);
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		ForgeDirection dir = ((IRotateableEntity) par1World.getTileEntity(par2, par3, par4)).getForwardDirection();
		switch (dir) {
		case NORTH:
		default:
			setBlockBounds(-1.5f, -1.5f, 0f, 2.5f, 2.5f, 1f);
		}
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

}
