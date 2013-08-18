package ip.industrialProcessing.multiblock.interfaces;

import net.minecraft.world.World;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.utils.Position;

public interface ITileEntityMultiblockBlock {
	boolean[] connectedSides = new boolean[6];
	
	int getCoreX();
	int getCoreY();
	int getCoreZ();
	int getFrameX();
	int getFrameY();
	int getFrameZ();
	MultiblockState getState();
	
	boolean hasCore();
	
	void setCore(ITileEntityMultiblockCore core);
	void setState(MultiblockState state);
	ITileEntityMultiblockCore getCore();
	void destroyBlock();
	void neighbourChanged();	
	ITileEntityMultiblockCore searchForCore();
	void onStateChanged();
	public void checkConnectedSides();
}
