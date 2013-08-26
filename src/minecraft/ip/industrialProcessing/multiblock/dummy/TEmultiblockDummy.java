package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEmultiblockDummy extends TileEntity {
	private TEmultiblockCore core;
	private MultiblockState state = MultiblockState.DISCONNECTED;

	public TEmultiblockDummy() {

	}

	public boolean searchForCore() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
			} else if (neighbour instanceof TEmultiblockCore) {
				TEmultiblockCore te = (TEmultiblockCore) neighbour;
				if (te.isDummyValidForStructure(this)) {
					setCore(te);
				}
			}
		}
		return false;
	}

	private void setCore(TEmultiblockCore te) {
		core = te;
		core.registerDummy(this);
		state = MultiblockState.CONNECTED;
		core.onLayoutChange();
	}
	
	public void setState(MultiblockState state){
		this.state = state;
	}
	
	public void delCore(){
		if (core!= null){
			core.unregisterDummy(this);
			core = null;
			state = MultiblockState.DISCONNECTED;
		}
	}

	public TEmultiblockCore getCore() {
		return core;
	}
}
