package ip.industrialProcessing.subMod.logic.network.microblock;

import java.lang.reflect.Array;
import java.util.Arrays;

import ip.industrialProcessing.microBlock.BlockMicroBlock;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.TileEntityMicroBlock;
import ip.industrialProcessing.microBlock.connectingSides.TileEntityMicroBlockConnectingSides;
import ip.industrialProcessing.microBlock.connectionCorners.TileEntityMicroBlockConnectionCorners;
import ip.industrialProcessing.microBlock.connections.TileEntityMicroBlockConnection;
import ip.industrialProcessing.subMod.logic.network.ILogicTransport;
import ip.industrialProcessing.utils.registry.HandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityLogicTransport extends TileEntityMicroBlockConnectionCorners implements ILogicTransport {

	int[] lineID = new int[6];

	public TileEntityLogicTransport() {
		Arrays.fill(lineID, -1);
	}

	@Override
	public int getLineID() {
		return getLineID(0);
	}

	@Override
	public int getLineID(int subBlock) {
		return lineID[subBlock];
	}
	
	@Override
	public void setLineID(int id) {
		lineID[0] = id;
	}

	@Override
	public void setLineID(int subBlock, int id) {
		lineID[subBlock] = id;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		lineID = par1nbtTagCompound.getIntArray("lineID");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setIntArray("lineID", lineID);
	}
		
	@Override
	public void onPostSideSet(ForgeDirection dir, int itemID) {
		super.onPostSideSet(dir, itemID);
		HandlerRegistry.addToLogicLine(this, false);
		for(int i = 0;i<6;i++)
			System.out.println(i+" "+lineID[i]);
	}

	@Override
	public void onPostSideUnset(ForgeDirection dir) {
		super.onPostSideUnset(dir);
		HandlerRegistry.removeFromLogicLine(this);
	}

}
