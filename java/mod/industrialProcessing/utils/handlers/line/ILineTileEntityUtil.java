package mod.industrialProcessing.utils.handlers.line;

import net.minecraftforge.common.util.ForgeDirection;

public interface ILineTileEntityUtil extends ILineTileEntitySolidBlock {
	ForgeDirection getConnectionDirection();
}
