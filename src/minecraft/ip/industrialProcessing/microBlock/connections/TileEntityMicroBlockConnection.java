package ip.industrialProcessing.microBlock.connections;

import ip.industrialProcessing.microBlock.BlockMicroBlock;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.TileEntityMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMicroBlockConnection extends TileEntityMicroBlock implements IMicroBlockConnection{
	boolean[][] externalConnections = new boolean[6][4];
	boolean[][] interConnections = new boolean[6][4];

	public TileEntityMicroBlockConnection() {
		super();
		for(int i = 0;i<externalConnections.length;i++){
			for(int j = 0;j<externalConnections[0].length;j++){
				externalConnections[i][j] = false;
			}
		}
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
		updateExtConnections();
	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
		updateSideConnections();
		updateExtConnections();
	}
	
	private void updateExtConnections(){
		for(int i = 0;i<6;i++){
			ForgeDirection dir = ForgeDirection.values()[i];
			int id =worldObj.getBlockId(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
			if (id != 0){
				if(Block.blocksList[id] instanceof BlockMicroBlock){
					if(((BlockMicroBlock)Block.blocksList[id]).getMicroBlockType() == ((BlockMicroBlock)this.getBlockType()).getMicroBlockType())
						setExternalConnectionForSide(i,(IMicroBlock) this.worldObj.getBlockTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ));
				}else{
					setExternalConnectionForSide(i,null);
				}
			}else{
				setExternalConnectionForSide(i,null);
			}
		}
	}
	
	private static final int[][] externalDirections = new int[][]{{3,3,3,3},{2,2,2,2},{1,0,3,2},{1,0,2,3},{1,0,0,0},{1,0,1,1}};
	
	private void setExternalConnectionForSide(int i, IMicroBlock te) {
		if(te != null){
			int[] sides = rotation[i];
			for(int j = 0;j<sides.length;j++){
				if(!te.isSideFree(sides[j]))
					externalConnections[sides[j]][externalDirections[sides[j]][j]] = true;
				else
					externalConnections[sides[j]][externalDirections[sides[j]][j]] = false;
			}	
		}else{
			int[] sides = rotation[i];
			for(int j = 0;j<sides.length;j++){
				externalConnections[sides[j]][externalDirections[sides[j]][j]] = false;
			}
		}
	}
	
	private static final int[][] rotation = new int[][]{{4,5,2,3},{4,5,3,2},{4,5,1,0},{5,4,1,0},{3,2,1,0},{2,3,1,0}};
	private int getRotated(int i, int j) {
		return rotation[i][j];
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
}
