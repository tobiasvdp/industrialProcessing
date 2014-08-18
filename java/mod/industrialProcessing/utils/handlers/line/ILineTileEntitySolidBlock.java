package mod.industrialProcessing.utils.handlers.line;

import net.minecraftforge.common.util.ForgeDirection;

public interface ILineTileEntitySolidBlock extends ILineTileEntity {
	int getLineId();
	void setLineID(int id);
	void registerToLine();
	void unregisterFromLine();
}
