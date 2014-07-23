package mod.industrialProcessing.utils.handlers.line;

public interface ILineTileEntitySolidBlock extends ILineTileEntity {
	int[] getLineConnectionArray();
	int getLineId();
	void registerToLine();
	void unregisterFromLine();
}
