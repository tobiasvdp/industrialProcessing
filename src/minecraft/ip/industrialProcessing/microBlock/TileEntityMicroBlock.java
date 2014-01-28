package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.utils.packets.PacketIP005DestroyBlock;

import java.util.Arrays;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMicroBlock extends TileEntity implements IMicroBlock {
	protected int[] sides = new int[6];

	public TileEntityMicroBlock() {
		Arrays.fill(sides, -1);
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
		System.out.println(dir + " is now set to " + itemID + "(" + ((BlockMicroBlock) Block.blocksList[itemID]).getMicroBlockType() + ").");
		worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void unsetSide(ForgeDirection dir,EntityPlayer player) {
		sides[dir.ordinal()] = -1;
		System.out.println(dir + " is now unset.");
		worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
		if(countSetSides() == 0){
			System.out.println("remove block");
			PacketDispatcher.sendPacketToServer(new PacketIP005DestroyBlock(xCoord, yCoord, zCoord, false).getCustom250Packet());
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
}
