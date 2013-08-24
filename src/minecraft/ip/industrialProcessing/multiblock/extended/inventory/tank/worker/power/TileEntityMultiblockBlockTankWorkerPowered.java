package ip.industrialProcessing.multiblock.extended.inventory.tank.worker.power;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.PowerWorkerHelper;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.worker.power.TileEntityMultiblockCoreInvWorkerPowered;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.PowerHelper;

public abstract class TileEntityMultiblockBlockTankWorkerPowered extends TileEntityMultiblockBlockInv implements IPowerAcceptor {

    public TileEntityMultiblockBlockTankWorkerPowered() {
	super();

    }

    @Override
    public float getResistance(ForgeDirection side) {
	if (canAcceptPower(side)) {
	    TileEntityMultiblockCoreTankWorkerPowered core = getCore();
	    int storage = core.getPowerStorage();
	    int capacity = core.getPowerCapacity();
	    return PowerHelper.getResistanceForStorage(storage, capacity);
	}
	return Float.POSITIVE_INFINITY;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	if (canAcceptPower(side)) {
	    TileEntityMultiblockCoreTankWorkerPowered core = getCore();
	    int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
	    core.incPowerStorage(joules);
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
