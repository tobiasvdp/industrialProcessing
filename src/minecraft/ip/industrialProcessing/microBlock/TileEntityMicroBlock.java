package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.utils.packets.PacketIP005DestroyBlock;

import java.util.Arrays;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMicroBlock extends TileEntity implements IMicroBlock {
	protected int[] sides = new int[6];

	public TileEntityMicroBlock() {
		Arrays.fill(sides, -1);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.customParam1);
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		sides = par1nbtTagCompound.getIntArray("sidesMicro");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setIntArray("sidesMicro", sides);	
	}
	
	@Override
	public boolean canUpdate() {
		return false;
	}

	@Override
	public boolean isSideFree(ForgeDirection dir) {
		return isSideFree(dir.ordinal());
	}
	
	@Override
	public boolean isSideFree(int dir) {
		return sides[dir] == -1;
	}

	@Override
	public void setSide(ForgeDirection dir, int itemID) {
		sides[dir.ordinal()] = itemID;
		if(!isValidSide(dir)){
			unsetSide(dir, null);
		}
		System.out.println(dir + " is now set to " + itemID + "(" + ((BlockMicroBlock) Block.blocksList[itemID]).getMicroBlockType() + ")."+this.worldObj);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void unsetSide(ForgeDirection dir,EntityPlayer player) {
		sides[dir.ordinal()] = -1;
		System.out.println(dir + " is now unset.");
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		if(countSetSides() == 0){
			System.out.println("remove block");
			worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
		}
		
	}
	
	private int countSetSides(){
		int count = 0;
		for(int i =0;i<sides.length;i++){
			if(sides[i] != -1){
				count++;
			}
		}
		return count;
	}

	@Override
	public int[] getSides() {
		return sides;
	}

	@Override
	public void refresh() {
		for(int i = 0;i<sides.length;i++){
			ForgeDirection dir = ForgeDirection.values()[i];
			if(!isValidSide(dir)){
				unsetSide(dir, null);
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	private boolean isValidSide(ForgeDirection dir) {
		if(!isSideFree(dir)){
			if(worldObj.isBlockSolidOnSide(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ, dir.getOpposite())){
				return true;
			}
			return false;
		}
		return true;
	}
}
