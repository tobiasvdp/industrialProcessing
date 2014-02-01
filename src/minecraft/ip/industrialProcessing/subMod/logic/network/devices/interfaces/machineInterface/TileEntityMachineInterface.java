package ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.network.microblock.TileEntityLogicNode;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMachineInterface extends TileEntityLogicNode {

	public TileEntityMachineInterface() {
		overrideSolidSide = true;
	}

	@Override
	public boolean isValidID(int itemID) {
		if (itemID == IPLogic.blockMachineInterface.blockID)
			return true;
		if (itemID == IPLogic.blockDataBus.blockID)
			return true;
		return false;
	}

	@Override
	public boolean isValidMicroBlockType(MicroBlockType other, MicroBlockType me) {
		if (other == MicroBlockType.wire)
			return true;
		return false;
	}

	@Override
	public boolean isValidPlacingSide(ForgeDirection dir, int itemID) {
		if (itemID == IPLogic.blockDataBus.blockID)
			return true;
		if (dir == ForgeDirection.NORTH || dir == ForgeDirection.SOUTH || dir == ForgeDirection.WEST || dir == ForgeDirection.EAST) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (te instanceof TileEntityMachine)
				return true;
		}
		return false;
	}
}
