package ip.industrialProcessing.machines.multiblock;

import net.minecraft.world.World;

public class MultiBlockStructureBlockDescription {

	private int x;
	private int y;
	private int z;
	private int blockID;

	public MultiBlockStructureBlockDescription(int x, int y, int z, int blockID) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockID = blockID;
	}

	public boolean isPresent(World worldObj, int xCoord, int yCoord, int zCoord) {
		return worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z) == this.blockID;
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
				&& blockId2 == blockID;
	}

}
