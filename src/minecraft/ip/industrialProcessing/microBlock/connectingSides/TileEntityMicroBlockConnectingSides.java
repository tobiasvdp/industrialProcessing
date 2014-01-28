package ip.industrialProcessing.microBlock.connectingSides;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.TileEntityMicroBlock;

public class TileEntityMicroBlockConnectingSides extends TileEntityMicroBlock implements IMicroBlockInterconnection{
	boolean[][] interConnections = new boolean[6][4];

	public TileEntityMicroBlockConnectingSides() {
		super();
		for(int i = 0;i<interConnections.length;i++){
			for(int j = 0;j<interConnections[0].length;j++){
				interConnections[i][j] = false;
			}
		}
	}

	@Override
	public void setSide(ForgeDirection dir, int itemID) {
		super.setSide(dir, itemID);
		updateSideConnections();
	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
		updateSideConnections();
	}

	private void updateSideConnections() {
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] != -1) {
				for(int j = 0;j<interConnections[i].length;j++){
					interConnections[i][j] = sides[getRotated(i, j)] != -1;
				}
			}
		}
	}

	private int[][] rotation = new int[][]{{4,5,2,3},{4,5,3,2},{4,5,1,0},{5,4,1,0},{3,2,1,0},{2,3,1,0}};
	private int getRotated(int i, int j) {
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
}
