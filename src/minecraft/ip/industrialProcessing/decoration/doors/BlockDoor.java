package ip.industrialProcessing.decoration.doors;

import java.util.List;
import java.util.Random;

import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorDoor;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDoor extends Block {

	public BlockDoor(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean canRenderInPass(int pass) {
		// this looks weird??????
		// Set the static var in the client proxy
		ClientProxy.renderPass = pass;
		// the block can render in both passes, so return true always
		return true;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;// super.canPlaceTorchOnTop(world, x, y, z);
	}

	public static boolean isTopDoor(IBlockAccess world, int x, int y, int z, int blockID) {
		if (world.getBlockId(x, y - 1, z) == blockID) {
			return true;
		}
		return false;
	}

	public static boolean isDoorOpen(IBlockAccess world, int x, int y, int z, int blockID) {
		if (world.getBlockMetadata(x, y, z) / 4 == 1 || world.getBlockMetadata(x, y, z) / 4 == 3)
			return true;
		return false;
	}

	public static boolean isSideDoor(IBlockAccess world, int x, int y, int z, int blockID) {
		if (world.getBlockMetadata(x, y, z) / 8 == 1)
			return true;
		return false;
	}

	public static boolean hasSideDoor(IBlockAccess world, int x, int y, int z, int blockID, int dir) {
		ForgeDirection right = getForwardFromMetadata(dir % 4).getRotation(ForgeDirection.DOWN);
		if (world.getBlockId(x + right.offsetX, y + right.offsetY, z + right.offsetZ) == blockID) {
			if (world.getBlockMetadata(x + right.offsetX, y + right.offsetY, z + right.offsetZ) % 4 == dir % 4) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkIfSideDoor(IBlockAccess world, int x, int y, int z, int blockID, int dir) {
		ForgeDirection left = getForwardFromMetadata(dir).getRotation(ForgeDirection.UP);
		if (world.getBlockId(x + left.offsetX, y + left.offsetY, z + left.offsetZ) == blockID) {
			if (world.getBlockMetadata(x + left.offsetX, y + left.offsetY, z + left.offsetZ) == dir) {
				if (BlockDoor.isTopDoor(world, x, y, z, blockID) && BlockDoor.isTopDoor(world, x + left.offsetX, y + left.offsetY, z + left.offsetZ, blockID))
					return true;
				if (!BlockDoor.isTopDoor(world, x, y, z, blockID) && !BlockDoor.isTopDoor(world, x + left.offsetX, y + left.offsetY, z + left.offsetZ, blockID))
					return true;
			}
		}
		return false;
	}

	public static ForgeDirection getForwardFromMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return null;
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		if ((par1World.getBlockId(par2, par3 - 1, par4) == this.blockID && BlockDoor.isTopDoor(par1World, par2, par3 - 1, par4, this.blockID)))
			return false;
		if ((par1World.getBlockId(par2, par3 - 1, par4) != this.blockID) && !par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP))
			return false;
		if (BlockDoor.isTopDoor(par1World, par2, par3, par4, this.blockID))
			return true;
		if (par1World.getBlockId(par2, par3 + 1, par4) != 0)
			return false;
		return super.canPlaceBlockAt(par1World, par2, par3, par4);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int dir = MathHelper.floor_double((par5EntityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;

		if (checkIfSideDoor(par1World, par2, par3, par4, this.blockID, dir))
			dir += 8;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, dir, 2);
		par1World.setBlock(par2, par3 + 1, par4, this.blockID);
		par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, par1World.getBlockMetadata(par2, par3, par4), 3);
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		if (isDoorOpen(par1World, par2, par3, par4, this.blockID)) {
			meta = meta - 4;
			par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 3);
			if (isTopDoor(par1World, par2, par3, par4, this.blockID)) {
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, meta, 3);
				if (isSideDoor(par1World, par2, par3, par4, this.blockID)) {
					ForgeDirection left = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.UP);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ) - 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY - 1, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY - 1, par4 + left.offsetZ) - 4, 3);
				}
				if (hasSideDoor(par1World, par2, par3, par4, this.blockID, meta)) {
					ForgeDirection right = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.DOWN);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ) - 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY - 1, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY - 1, par4 + right.offsetZ) - 4, 3);
				}
			} else {
				par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, meta, 3);
				if (isSideDoor(par1World, par2, par3, par4, this.blockID)) {
					ForgeDirection left = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.UP);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ) - 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY + 1, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY + 1, par4 + left.offsetZ) - 4, 3);
				}
				if (hasSideDoor(par1World, par2, par3, par4, this.blockID, meta)) {
					ForgeDirection right = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.DOWN);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ) - 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY + 1, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY + 1, par4 + right.offsetZ) - 4, 3);
				}
			}
		} else {
			meta = meta + 4;
			par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 3);
			if (isTopDoor(par1World, par2, par3, par4, this.blockID)) {
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, meta, 3);
				if (isSideDoor(par1World, par2, par3, par4, this.blockID)) {
					ForgeDirection left = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.UP);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ) + 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY - 1, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY - 1, par4 + left.offsetZ) + 4, 3);
				}
				if (hasSideDoor(par1World, par2, par3, par4, this.blockID, meta)) {
					ForgeDirection right = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.DOWN);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ) + 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY - 1, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY - 1, par4 + right.offsetZ) + 4, 3);
				}
			} else {
				par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, meta, 3);
				if (isSideDoor(par1World, par2, par3, par4, this.blockID)) {
					ForgeDirection left = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.UP);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY, par4 + left.offsetZ) + 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + left.offsetX, par3 + left.offsetY + 1, par4 + left.offsetZ, par1World.getBlockMetadata(par2 + left.offsetX, par3 + left.offsetY + 1, par4 + left.offsetZ) + 4, 3);
				}
				if (hasSideDoor(par1World, par2, par3, par4, this.blockID, meta)) {
					ForgeDirection right = getForwardFromMetadata(meta % 4).getRotation(ForgeDirection.DOWN);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY, par4 + right.offsetZ) + 4, 3);
					par1World.setBlockMetadataWithNotify(par2 + right.offsetX, par3 + right.offsetY + 1, par4 + right.offsetZ, par1World.getBlockMetadata(par2 + right.offsetX, par3 + right.offsetY + 1, par4 + right.offsetZ) + 4, 3);
				}
			}
		}

		return true;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		if (BlockDoor.isTopDoor(par1World, par2, par3, par4, this.blockID)) {
			par1World.destroyBlock(par2, par3 - 1, par4, false);
		} else {
			if (par1World.getBlockId(par2, par3 + 1, par4) == this.blockID)
				par1World.destroyBlock(par2, par3 + 1, par4, false);
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		if (!isDoorOpen(par1World, par2, par3, par4, this.blockID)) {
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}

	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		switch (l) {
		case 0:
		case 2:
		case 8:
		case 10:
			this.setBlockBounds(0.0F, 0.0F, 0.46F, 1.0F, 1.0F, 0.54F);
			break;
		case 1:
		case 3:
		case 9:
		case 11:
			this.setBlockBounds(0.46F, 0.0F, 0.0F, 0.54F, 1.0F, 1.00F);
			break;
		case 6:
			this.setBlockBounds(0.00F, 0.00F, -0.50F, 0.08F, 1.00F, 0.50F);
			break;
		case 12:
			this.setBlockBounds(0.00F, 0.00F, 0.50F, 0.08F, 1.00F, 1.50F);
			break;
		case 5:
			this.setBlockBounds(-0.50F, 0.00F, 0.92F, 0.50F, 1.00F, 1.00F);
			break;
		case 15:
			this.setBlockBounds(0.50F, 0.00F, 0.92F, 1.50F, 1.00F, 1.00F);
			break;
		case 4:
			this.setBlockBounds(0.92F, 0.00F, 0.50F, 1.00F, 1.00F, 1.50F);
			break;
		case 14:
			this.setBlockBounds(0.92F, 0.00F, -0.50F, 1.00F, 1.00F, 0.50F);
			break;
		case 7:
			this.setBlockBounds(0.50F, 0.00F, 0.00F, 1.50F, 1.00F, 0.08F);
			break;
		case 13:
			this.setBlockBounds(-0.50F, 0.00F, 0.00F, 0.50F, 1.00F, 0.08F);
			break;
		}
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if (!canBlockStay(par1World, par2, par3, par4)) {
			par1World.destroyBlock(par2, par3, par4, true);
		}
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		if (!BlockDoor.isTopDoor(par1World, par2, par3, par4, this.blockID)) {
			return par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP);
		}
		return super.canBlockStay(par1World, par2, par3, par4);
	}
}
