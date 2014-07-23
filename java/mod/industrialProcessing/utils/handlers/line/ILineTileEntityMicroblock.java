package mod.industrialProcessing.utils.handlers.line;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;

public interface ILineTileEntityMicroblock extends ILineTileEntity {
	int getLineID(int side);
	void setLineID(int side, int id);
	MicroBlockType getType();
	void registerToLine(ForgeDirection dir);
	void unregisterFromLine(ForgeDirection dir);
	int[][] getLineConnectionArray(ForgeDirection dir);
}
