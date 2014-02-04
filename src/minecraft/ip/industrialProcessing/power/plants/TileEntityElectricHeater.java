package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.PowerTransfers;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityElectricHeater extends TileEntityMachine implements IPoweredMachine, IPowerAcceptor {

    private static final LocalDirection POWER_INPUT_SIDE = LocalDirection.LEFT;
    private static final int STORAGE_CAPACITY = 0;
    private SimplePowerStorage powerStorage;

    public TileEntityElectricHeater() {
        addStack(null, (LocalDirection) null, true, false);
        this.powerStorage = new SimplePowerStorage(STORAGE_CAPACITY);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        if (slot == 0) {
            return PowerTransfers.isBattery(new ItemStack(itemID, 1, 0));
        }
        return false;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
        return PowerHelper.getResistanceForStorage(this.powerStorage);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
        ForgeDirection inputSide = DirectionUtils.getWorldDirection(POWER_INPUT_SIDE, this.getForwardDirection());
        if (inputSide == side) {
            this.powerStorage.fillPower(PowerHelper.getEnergy(coulombs, voltage), true);
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
        // TODO Auto-generated method stub
        return null;
    }

}
