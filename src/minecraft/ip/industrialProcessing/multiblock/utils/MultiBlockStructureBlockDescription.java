package ip.industrialProcessing.multiblock.utils;

import java.util.Arrays;

import net.minecraft.world.World;

public class MultiBlockStructureBlockDescription {

	private int x;
	private int y;
	private int z;
	private int[] blockIDs;

	public MultiBlockStructureBlockDescription(int x, int y, int z, int... blockIDs) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockIDs = blockIDs;
	}
	public MultiBlockStructureBlockDescription copy(int x,int y,int z){
		return new MultiBlockStructureBlockDescription(x,y,z,this.blockIDs);
	}

	public int getX() {
		return x;
	}	
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	
	public boolean isPresent(World worldObj, int xCoord, int yCoord, int zCoord) {
		int block = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);
		return containsBlock(block);
	}

	public boolean breakBlock(World worldObj, int xCoord, int yCoord, int zCoord) {
		if (isPresent(worldObj, xCoord, yCoord, zCoord)) {
			return worldObj.setBlockToAir(xCoord + x, yCoord + y, zCoord + z);
		}
		return false;
	}

	public boolean isPart(int x2, int y2, int z2, int xCoord, int yCoord,
			int zCoord, int blockId2) {
		return x2 == x + xCoord && y2 == y + yCoord && z2 == z + zCoord
				&& containsBlock(blockId2);
	}

	public boolean containsBlock(int block)
	{
		for(int i = 0; i < this.blockIDs.length; i++)
		{
			if(this.blockIDs[i] == block) return true;
		}
		return false;
	}
}
