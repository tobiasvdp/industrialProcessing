package mod.industrialProcessing.plants.logic.wire.cable;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.microblock.IMicroBlock;
import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.blockContainer.microblock.extend.connectionCorners.TileEntityMicroBlockConnectionCorners;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntityMicroblock;
import mod.industrialProcessing.utils.registry.MicroBlockConnectionRegistry;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;

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
	public int getLineId() {
		return -1;
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
	public void formConnections() {
		for (int i = 0; i < 6; i++) {
			if (getLineID(i) == -1) {
				if (!isSideFree(i)) {
					// check internal connections for line
					for (int j = 0; j < 4; j++) {
						if (interConnections[i][j]) {
							int side = getRotated(i, j);
							if (getLineID(side) != -1) {
								if (getLineID(i) == -1) {
									setLineID(side, getLineID(side));
								} else {
									if((getLineID(i)>(getLineID(side)){
										setLineID(side, getLineID(side));
										translateTo
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void setLineID(int side, int id) {
		lineID[side] = id;
	}

}
