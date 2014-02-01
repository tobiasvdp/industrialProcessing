package ip.industrialProcessing.subMod.logic.network.microblock;

import java.util.Arrays;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.connectionCorners.TileEntityMicroBlockConnectionCorners;
import ip.industrialProcessing.subMod.logic.network.ILogicNode;
import ip.industrialProcessing.utils.registry.HandlerRegistry;

public abstract class TileEntityLogicNode extends TileEntityMicroBlockConnectionCorners implements ILogicNode{
	int[] lineID = new int[6];

	public TileEntityLogicNode() {
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
		if(worldObj == null){
			HandlerRegistry.addToLogicLine(this, true);
		}
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
