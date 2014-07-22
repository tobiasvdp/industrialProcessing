package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.world.World;

public interface ILineTileEntity{
	boolean hasMultipleLines();
	boolean isMicroblock();
	int getLineId();
	boolean isInLine();
	boolean isPartOfLine(int lineID);
	void formConnections();
	World getWorldObj();
	int getXCoord();
	int getYCoord();
	int getZCoord();
}
