package mod.industrialProcessing.plants.logic.wire.cable;

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
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCable extends TileEntityMicroBlockConnectionCorners implements ILineTileEntityMicroblock {

	protected int[] lineID = new int[6];

	public TileEntityCable() {
		Arrays.fill(lineID, -1);
	}

	@Override
	public boolean hasMultipleLines() {
		int count = 0;
		int current = -1;
		for (int i = 0; i < 6; i++) {
			if (-1 != this.lineID[i] && current != this.lineID[i]) {
				current = this.lineID[i];
				count++;
			}
		}
		return count > 1;
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
	public int[][] getLineConnectionArray(ForgeDirection dir) {
		int[][] result = new int[3][4];
		// innerconnections
		for (int i = 0; i < 4; i++) {
			if (interConnections[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				result[0][i] = getLineID(side);
			} else {
				result[0][i] = -2;
			}
		}
		// external connections
		for (int i = 0; i < 4; i++) {
			if (externalConnections[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				ForgeDirection nextDir = ForgeDirection.values()[side];
				TileEntity nextTe = worldObj.getTileEntity(xCoord + nextDir.offsetX, yCoord + nextDir.offsetY, zCoord + nextDir.offsetZ);
				if (nextTe instanceof ILineTileEntityMicroblock) {
					result[1][i] = ((ILineTileEntityMicroblock) nextTe).getLineID(dir.ordinal());
				} else if (nextTe instanceof ILineTileEntitySolidBlock) {
					result[1][i] = ((ILineTileEntitySolidBlock) nextTe).getLineId();
				} else {
					result[1][i] = -3;
				}

			} else {
				result[1][i] = -2;
			}
		}

		// cornerConnections
		for (int i = 0; i < 4; i++) {
			if (externalConnectionExtentions[dir.ordinal()][i]) {
				int side = getRotated(dir.ordinal(), i);
				ForgeDirection nextDir = ForgeDirection.values()[side];
				TileEntity nextTe = worldObj.getTileEntity(xCoord + nextDir.offsetX + dir.offsetX, yCoord + nextDir.offsetY + dir.offsetY, zCoord + nextDir.offsetZ + dir.offsetZ);
				if (nextTe instanceof ILineTileEntityMicroblock) {
					result[2][i] = ((ILineTileEntityMicroblock) nextTe).getLineID(nextDir.getOpposite().ordinal());
				} else if (nextTe instanceof ILineTileEntitySolidBlock) {
					result[2][i] = ((ILineTileEntitySolidBlock) nextTe).getLineId();
				} else {
					result[2][i] = -3;
				}

			} else {
				result[2][i] = -2;
			}
		}

		return result;
	}

}
