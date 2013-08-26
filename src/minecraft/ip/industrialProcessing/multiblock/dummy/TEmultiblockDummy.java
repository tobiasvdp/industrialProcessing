package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEmultiblockDummy extends TileEntity {
	private TEmultiblockCore core;

	public TEmultiblockDummy() {

	}

	public boolean searchForCore() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
			} else if (neighbour instanceof TEmultiblockCore) {
				TEmultiblockCore te = (TEmultiblockCore) neighbour;
				if (te.isDummyValidForstructure(this)) {
					setCore(te);
				}
			}
		}
		return false;
	}

	private void setCore(TEmultiblockCore te) {
		core = te;
		core.registerDummy(this);
	}
	
	public void delCore(){
		core.unregisterDummy(this);
		core = null;
	}
}
