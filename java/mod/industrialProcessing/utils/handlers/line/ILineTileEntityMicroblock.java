package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;

public interface ILineTileEntityMicroblock extends ILineTileEntity {
	int getLineID(int side);
	void setLineID(int side, int id);
	MicroBlockType getType();
}
