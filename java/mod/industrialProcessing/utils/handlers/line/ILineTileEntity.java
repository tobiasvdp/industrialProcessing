package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public interface ILineTileEntity{
	boolean isLineNull();
	void setLineLength(int length);
	int getLineLength();
	boolean hasMultipleLineSupport();
	boolean isMicroblock();
	boolean isInLine();
	boolean isPartOfLine(int lineID);
	World getWorldObj();
	int getXCoord();
	int getYCoord();
	int getZCoord();
	int[] getLineConnectionArray(ForgeDirection dir);
}
