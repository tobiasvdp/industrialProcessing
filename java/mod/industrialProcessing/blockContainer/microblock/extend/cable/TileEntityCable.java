package mod.industrialProcessing.blockContainer.microblock.extend.cable;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.microblock.IMicroBlock;
import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.blockContainer.microblock.extend.connectionCorners.TileEntityMicroBlockConnectionCorners;
import mod.industrialProcessing.items.ItemMicroBlock;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntityMicroblock;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntitySolidBlock;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import mod.industrialProcessing.utils.registry.MicroBlockConnectionRegistry;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityCable extends TileEntityMicroBlockConnectionCorners implements ILineTileEntityMicroblock {

	protected int[] lineID = new int[6];
	protected int lineLength = 0;
	protected boolean isLoaded = false;

	public TileEntityCable() {
		int[] lineID = new int[6];
		Arrays.fill(lineID, -1);
	}

	@Override
	public boolean hasMultipleLineSupport() {
		return true;
	}

	@Override
	public boolean isMicroblock() {
		return true;
	}

	@Override
	public boolean isInLine() {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (lineID[i] != -1)
				count++;
		}
		return count != 0;
	}

	@Override
	public boolean isPartOfLine(int lineID) {
		for (int i = 0; i < 6; i++) {
			if (lineID == this.lineID[i])
				return true;
		}
		return false;
	}

	@Override
	public int getXCoord() {
		return this.xCoord;
	}

	@Override
	public int getYCoord() {
		return this.yCoord;
	}

	@Override
	public int getZCoord() {
		return this.zCoord;
	}

	@Override
	public int getLineID(int side) {
		return lineID[side];
	}

	@Override
	public MicroBlockType getType() {
		return MicroBlockType.cable;
	}

	@Override
	public void setLineID(int side, int id) {
		lineID[side] = id;
	}

	@Override
	public void onPostSideSet(ForgeDirection dir, ItemMicroBlock itemMicroBlock) {
		super.onPostSideSet(dir, itemMicroBlock);
		registerToLine(dir);
	}

	@Override
	public void onPostSideUnset(ForgeDirection dir) {
		super.onPostSideUnset(dir);
		unregisterFromLine(dir);
	}
	
	@Override
	protected void notifyOnCreation() {
		super.notifyOnCreation();
		for(int i = 0;i<6;i++){
			if(sidesMicroblockItemID[i] != -1){
				registerToLine(ForgeDirection.values()[i]);
			}
		}
	}

	@Override
	public void registerToLine(ForgeDirection dir) {
		HandlerRegistry.registerToLineHandler("logic", this, dir);
	}

	@Override
	public void unregisterFromLine(ForgeDirection dir) {
		HandlerRegistry.unregisterFromLineHandler("logic", this, dir);
	}

	@Override
	public int[] getLineConnectionArray(ForgeDirection dir) {
		int[] result = new int[12];
		int k = 0;
		// innerconnections
		for (int i = 0; i < 4; i++) {
			if (interConnections[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				result[k++] = getLineID(side);
			} else {
				result[k++] = -2;
			}
		}
		// external connections
		for (int i = 0; i < 4; i++) {
			if (externalConnections[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				ForgeDirection nextDir = ForgeDirection.values()[side];
				TileEntity nextTe = worldObj.getTileEntity(xCoord + nextDir.offsetX, yCoord + nextDir.offsetY, zCoord + nextDir.offsetZ);
				if (nextTe instanceof ILineTileEntityMicroblock) {
					result[k++] = ((ILineTileEntityMicroblock) nextTe).getLineID(dir.ordinal());
				} else if (nextTe instanceof ILineTileEntitySolidBlock) {
					result[k++] = ((ILineTileEntitySolidBlock) nextTe).getLineId();
				} else {
					result[k++] = -3;
				}

			} else {
				result[k++] = -2;
			}
		}

		// cornerConnections
		for (int i = 0; i < 4; i++) {
			if (externalConnectionExtentions[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				ForgeDirection nextDir = ForgeDirection.values()[side];
				TileEntity nextTe = worldObj.getTileEntity(xCoord + nextDir.offsetX + dir.offsetX, yCoord + nextDir.offsetY + dir.offsetY, zCoord + nextDir.offsetZ + dir.offsetZ);
				if (nextTe instanceof ILineTileEntityMicroblock) {
					result[k++] = ((ILineTileEntityMicroblock) nextTe).getLineID(nextDir.getOpposite().ordinal());
				} else if (nextTe instanceof ILineTileEntitySolidBlock) {
					result[k++] = ((ILineTileEntitySolidBlock) nextTe).getLineId();
				} else {
					result[k++] = -3;
				}

			} else {
				result[k++] = -2;
			}
		}

		return result;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setIntArray("lineID", lineID);
		par1nbtTagCompound.setInteger("lineLength", lineLength);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		
		lineID = par1nbtTagCompound.getIntArray("lineID");
		if(lineID == null || lineID.length == 0){
			lineID = new int[6];
			Arrays.fill(lineID, -1);
		}
		lineLength = par1nbtTagCompound.getInteger("lineLength");
		
		if(!isLoaded){
			HandlerRegistry.registerToLineHandlerFromNBT("logic", this);
			isLoaded = true;
		}
	}

	@Override
	public boolean isLineNull() {
		if(lineID == null)
			return true;
		if(lineID.length == 0)
			return true;
		return false;
	}

	@Override
	public void setLineLength(int length) {
		lineLength = length;
	}

	@Override
	public int getLineLength() {
		return lineLength;
	}

}
