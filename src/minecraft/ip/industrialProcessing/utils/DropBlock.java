package ip.industrialProcessing.utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class DropBlock {
	public static void doDispense(World par0World, ItemStack par1ItemStack, int par2, ForgeDirection forge, int x, int y, int z) {
		if (!par0World.isRemote) {
			EnumFacing par3EnumFacing = toEnum(forge);
			double d0 = x;
			double d1 = y + 1;
			double d2 = z;
			EntityItem entityitem = new EntityItem(par0World, d0, d1 - 0.3D, d2, par1ItemStack);
			double d3 = par0World.rand.nextDouble() * 0.1D + 0.2D;
			entityitem.motionX = (double) par3EnumFacing.getFrontOffsetX() * d3;
			entityitem.motionY = 0.20000000298023224D;
			entityitem.motionZ = (double) par3EnumFacing.getFrontOffsetZ() * d3;
			entityitem.motionX += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
			entityitem.motionY += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
			entityitem.motionZ += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
			par0World.spawnEntityInWorld(entityitem);
		}
	}

	private static EnumFacing toEnum(ForgeDirection forge) {
		switch(forge){
		case DOWN:
			return EnumFacing.DOWN;
		case EAST:
			return EnumFacing.EAST;
		case NORTH:
			return EnumFacing.NORTH;
		case SOUTH:
			return EnumFacing.SOUTH;
		case UNKNOWN:
			return EnumFacing.UP;
		case UP:
			return EnumFacing.UP;
		case WEST:
			return EnumFacing.WEST;
		default:
			return EnumFacing.UP;
		}
	}
}
