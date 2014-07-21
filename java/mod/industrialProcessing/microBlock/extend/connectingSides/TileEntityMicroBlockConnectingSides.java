package mod.industrialProcessing.microBlock.extend.connectingSides;

import mod.industrialProcessing.items.ItemMicroBlock;
import mod.industrialProcessing.microBlock.core.TileEntityMicroBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMicroBlockConnectingSides extends TileEntityMicroBlock implements IMicroBlockInterconnection {
	boolean[][] interConnections = new boolean[6][4];

	public TileEntityMicroBlockConnectingSides() {
		super();
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				interConnections[i][j] = false;
			}
		}
	}

	@Override
	public void setSide(ForgeDirection dir, ItemMicroBlock itemMicroBlock, EntityPlayer player) {
		super.setSide(dir, itemMicroBlock, player);
		updateSideConnections();
	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
		updateSideConnections();
	}

	private void updateSideConnections() {
		for (int i = 0; i < sidesMicroblock.length; i++) {
			if (sidesMicroblock[i] != -1) {
				for (int j = 0; j < interConnections[i].length; j++) {
					interConnections[i][j] = sidesMicroblock[getRotated(i, j)] != -1;
				}
			}
		}
	}

	private int[][] rotation = new int[][] { { 4, 5, 2, 3 }, { 4, 5, 3, 2 }, { 4, 5, 1, 0 }, { 5, 4, 1, 0 }, { 3, 2, 1, 0 }, { 2, 3, 1, 0 } };

	@Override
	public int getRotated(int i, int j) {
		return rotation[i][j];
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				interConnections[i][j] = par1nbtTagCompound.getBoolean("interCon" + i * 10 + j);
			}
		}
		super.readFromNBT(par1nbtTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < interConnections.length; i++) {
			for (int j = 0; j < interConnections[0].length; j++) {
				par1nbtTagCompound.setBoolean("interCon" + i * 10 + j, interConnections[i][j]);
			}
		}
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public boolean[] getInterConnections(int side) {
		return interConnections[side];
	}

	@Override
	public void refresh() {
		super.refresh();
		updateSideConnections();
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
}
