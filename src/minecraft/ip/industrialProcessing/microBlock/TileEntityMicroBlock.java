package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.multiblock.IMicroBlock;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMicroBlock extends TileEntity implements IMicroBlock {
	int[] sides = new int[6];

	public TileEntityMicroBlock() {
		Arrays.fill(sides, -1);
	}

	@Override
	public boolean canUpdate() {
		return false;
	}

	@Override
	public boolean isSideFree(ForgeDirection dir) {
		return sides[dir.ordinal()] == -1;
	}

	@Override
	public void setSide(ForgeDirection dir, int itemID) {
		sides[dir.ordinal()] = itemID;
		System.out.println(dir + " is now set to " + itemID + "(" + ((BlockMicroBlock) Block.blocksList[itemID]).getMicroBlockType() + ")");
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		sides = par1nbtTagCompound.getIntArray("sidesMicro");
		super.readFromNBT(par1nbtTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		par1nbtTagCompound.setIntArray("sidesMicro", sides);
		super.writeToNBT(par1nbtTagCompound);
	}
}
