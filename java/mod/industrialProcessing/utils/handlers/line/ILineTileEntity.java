package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.world.World;

public interface ILineTileEntity{
	int getLineId();
	boolean isInLine();
	boolean isPartOfLine(int lineID);
	boolean isValidConnection(LocalDirection dir);
	boolean canConnectWith(LocalDirection dir);
	World getWorldObj();
	int getXCoord();
	int getYCoord();
	int getZCoord();
}
