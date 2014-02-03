package ip.industrialProcessing.microBlock.extend.connections;

import ip.industrialProcessing.items.ItemMicroBlock;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import ip.industrialProcessing.microBlock.core.TileEntityMicroBlock;
import ip.industrialProcessing.microBlock.extend.externalConnections.IMicroBlockExternalConnection;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMicroBlockConnection extends TileEntityMicroBlock implements IMicroBlockConnection {
	protected boolean[][] externalConnections = new boolean[6][4];
	protected boolean[][] interConnections = new boolean[6][4];

	public TileEntityMicroBlockConnection() {
		super();
		for (int i = 0; i < externalConnections.length; i++) {
			for (int j = 0; j < externalConnections[0].length; j++) {
				externalConnections[i][j] = false;
			}
		}
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				interConnections[i][j] = false;
			}
		}
	}

	@Override
	public void setSide(ForgeDirection dir, ItemMicroBlock itemMicroBlock,EntityPlayer player) {
		super.setSide(dir, itemMicroBlock,player);
		updateSideConnections();
		updateExtConnections();
		onPostSideSet(dir,itemMicroBlock);
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void onPostSideSet(ForgeDirection dir, ItemMicroBlock itemMicroBlock) {

	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
		updateSideConnections();
		updateExtConnections();
		onPostSideUnset(dir);
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void onPostSideUnset(ForgeDirection dir) {

	}

	protected void updateExtConnections() {
		System.out.println("trigger recheck external");
		for (int i = 0; i < 6; i++) {
			ForgeDirection dir = ForgeDirection.values()[i];
			int id = worldObj.getBlockId(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (id != 0) {
				if (Block.blocksList[id] instanceof BlockMicroBlock) {
					if (this.getBlockType() != null && isValidMicroBlockType(((BlockMicroBlock) Block.blocksList[id]).getMicroBlockType(),((BlockMicroBlock) this.getBlockType()).getMicroBlockType()))
						setExternalConnectionForSide(i, (IMicroBlock) this.worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ), true);
				} else {
					setExternalConnectionForSide(i, null, true);
				}
			} else {
				setExternalConnectionForSide(i, null, true);
			}
		}
	}

	public boolean isValidMicroBlockType(MicroBlockType other, MicroBlockType me){
		return true;
	}

	protected static final int[][] externalDirections = new int[][] { { -1, -1, 2, 3, 0, 1 }, { -1, -1, 3, 2, 0, 1 }, { 3, 2, -1, -1, 0, 1 }, { 3, 2, -1, -1, 1, 0 }, { 3, 2, 1, 0, -1, -1 }, { 3, 2, 0, 1, -1, -1 } };

	protected void setExternalConnectionForSide(int i, IMicroBlock te, boolean repeat) {
		if (te != null) {
			int[] sides = rotation[i];
			for (int j = 0; j < sides.length; j++) {
				if (!te.isSideFree(sides[j])) {
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
				} else {
					if (hasDiagonalConnection(sides[j], i, te, repeat))
						externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
					else
						externalConnections[sides[j]][externalDirections[sides[j]][i]] = false;
				}
			}
			if (repeat && te instanceof IMicroBlockExternalConnection) {
				((IMicroBlockExternalConnection) te).updateConnections(BlockMicroBlock.invertSide(i));
			}
		} else {
			int[] sides = rotation[i];
			for (int j = 0; j < sides.length; j++) {
				if (hasDiagonalConnection(sides[j], i, te, repeat))
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
				else
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = false;
			}
		}
	}

	protected boolean hasDiagonalConnection(int face, int side, IMicroBlock te, boolean repeat) {
		return false;
	}

	protected static final int[][] rotation = new int[][] { { 4, 5, 2, 3 }, { 4, 5, 3, 2 }, { 4, 5, 1, 0 }, { 5, 4, 1, 0 }, { 3, 2, 1, 0 }, { 2, 3, 1, 0 } };

	public int getRotated(int i, int j) {
		return rotation[i][j];
	}

	protected void updateSideConnections() {
		for (int i = 0; i < sidesMicroblock.length; i++) {
			if (sidesMicroblock[i] != -1) {
				for (int j = 0; j < interConnections[i].length; j++) {
					interConnections[i][j] = sidesMicroblock[getRotated(i, j)] != -1;
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < externalConnections.length; i++) {
			for (int j = 0; j < externalConnections[0].length; j++) {
				externalConnections[i][j] = par1nbtTagCompound.getBoolean("externCon" + i * 10 + j);
			}
		}
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				interConnections[i][j] = par1nbtTagCompound.getBoolean("interCon" + i * 10 + j);
			}
		}
		super.readFromNBT(par1nbtTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < externalConnections.length; i++) {
			for (int j = 0; j < externalConnections[0].length; j++) {
				par1nbtTagCompound.setBoolean("externCon" + i * 10 + j, externalConnections[i][j]);
			}
		}
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				par1nbtTagCompound.setBoolean("interCon" + i * 10 + j, interConnections[i][j]);
			}
		}
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public boolean[] getExternalConnections(int side) {
		return externalConnections[side];
	}

	@Override
	public boolean[] getInterConnections(int side) {
		return interConnections[side];
	}

	@Override
	public void updateConnections(int i) {
		ForgeDirection dir = ForgeDirection.values()[i];
		TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
		if (te != null && te instanceof IMicroBlock)
			setExternalConnectionForSide(i, (IMicroBlock) te, false);
		else
			setExternalConnectionForSide(i, null, false);
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void updateConnections(int x, int y, int z) {
		int dx = x - xCoord;
		int dy = y - yCoord;
		int dz = z - zCoord;
		ForgeDirection dir = getForgeDirection(dx, dy, dz);
		updateConnections(dir.ordinal());
	}

	private ForgeDirection getForgeDirection(int dx, int dy, int dz) {
		if (dx < 0) {
			return ForgeDirection.WEST;
		}
		if (dx > 0) {
			return ForgeDirection.EAST;
		}
		if (dx == 0) {
			if (dy < 0) {
				return ForgeDirection.DOWN;
			}
			if (dy > 0) {
				return ForgeDirection.UP;
			}
			if (dy == 0) {
				if (dz < 0) {
					return ForgeDirection.NORTH;
				}
				if (dz > 0) {
					return ForgeDirection.SOUTH;
				}
			}
		}

		return ForgeDirection.UNKNOWN;
	}
	
	@Override
	public void refresh() {
		super.refresh();
		updateSideConnections();
		updateExtConnections();
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
}

