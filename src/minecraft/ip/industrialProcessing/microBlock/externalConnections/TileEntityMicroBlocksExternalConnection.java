package ip.industrialProcessing.microBlock.externalConnections;

import ip.industrialProcessing.microBlock.TileEntityMicroBlock;
import ip.industrialProcessing.microBlock.connectingSides.IMicroBlockInterconnection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMicroBlocksExternalConnection extends TileEntityMicroBlock implements IMicroBlockExternalConnection{
	boolean[][] externalConnections = new boolean[6][4];

	public TileEntityMicroBlocksExternalConnection() {
		super();
		for(int i = 0;i<externalConnections.length;i++){
			for(int j = 0;j<externalConnections[0].length;j++){
				externalConnections[i][j] = false;
			}
		}
	}

	@Override
	public void setSide(ForgeDirection dir, int itemID) {
		super.setSide(dir, itemID);
		updateExtConnections();
	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
		updateExtConnections();
	}
	
	private void updateExtConnections(){
		
	}

	private int[][] rotation = new int[][]{{4,5,2,3},{4,5,3,2},{4,5,1,0},{5,4,1,0},{3,2,1,0},{2,3,1,0}};
	private int getRotated(int i, int j) {
		return rotation[i][j];
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < externalConnections.length; i++) {
			for (int j = 0; j < externalConnections[0].length; j++) {
				externalConnections[i][j] = par1nbtTagCompound.getBoolean("externCon" + i * 10 + j);
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
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public boolean[] getExternalConnections(int side) {
		return externalConnections[side];
	}

	@Override
	public void updateConnections(int i) {
		// TODO Auto-generated method stub
		
	}
}
