package ip.industrialProcessing.power.storage;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBatteryBox extends TileEntityPowerGenerator implements IPowerAcceptor {

    public TileEntityBatteryBox() {
	super(10000, 100); 
    }

    private static final LocalDirection inputSide = LocalDirection.LEFT;
    private static final LocalDirection outputSide = LocalDirection.RIGHT;

    int storedPower = 0;
    int storageCapacity = 10000;

    @Override
    public int producePower(int maxAmount) {
	return Math.min(maxAmount, storedPower);
    }

    @Override
    public boolean canProducePower(ForgeDirection opposite) {
	LocalDirection dir = DirectionUtils.GetLocalDirection(opposite, getForwardDirection());
	return dir == outputSide;
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (canAcceptPower(side)) {
	    int amount = Math.min(maxAmount, storageCapacity - storedPower);
	    if (doAccept)
		this.storedPower += amount;
	    return amount;
	}
	return 0;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection dir = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return dir == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) { 
	return false;
    }

}
