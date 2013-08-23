package ip.industrialProcessing.multiblock.extended.inventory.tank.worker.power;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.worker.power.TileEntityMultiblockCoreInvWorkerPowered;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.power.IPowerAcceptor;

public abstract class TileEntityMultiblockBlockTankWorkerPowered extends TileEntityMultiblockBlockInv implements IPowerAcceptor {

	public TileEntityMultiblockBlockTankWorkerPowered() {
		super();

	}

	@Override
	public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
		if (getCore() != null && state == MultiblockState.COMPLETED) {
			if (canAcceptPower(side)) {
				int accept = PowerWorkerHelper.acceptPower(getCore().getPowerCapacity(), getCore().getPowerStorage(), maxAmount);
				if (doAccept) {
					getCore().incPowerStorage(accept);
				}
				return accept;
			}
			return 0;
		} else {
			return 0;
		}
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		return true;
	}
	@Override
	public TileEntityMultiblockCoreTankWorkerPowered getCore() {
		return (TileEntityMultiblockCoreTankWorkerPowered) worldObj.getBlockTileEntity(xCore, yCore, zCore);
	}
}
