package ip.industrialProcessing.machines.multiblock;

import ip.industrialProcessing.utils.Position;

public interface IMultiblockTileEntityFrame {
	int getCoreX();
	int getCoreY();
	int getCoreZ();
	int getFrameX();
	int getFrameY();
	int getFrameZ();
	
	boolean hasCore();
	
	//void setCore(int x, int y, int z);
	void removeCore();
	void setCore(IMultiblockTileEntityCore core);
	void setState(MachineFrameState state);
}
