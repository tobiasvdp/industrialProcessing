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
import ip.industrialProcessing.utils.handler.fuel.IBurner;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.ServerWorker;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityElectricHeater extends TileEntityMachine implements IPoweredMachine, IPowerAcceptor, IWorkHandler, IBurner {

    private static final LocalDirection POWER_INPUT_SIDE = LocalDirection.LEFT;
    private static final int STORAGE_CAPACITY = 0;
    private SimplePowerStorage powerStorage;
    private ServerWorker worker;

    public TileEntityElectricHeater() {
        addStack(null, (LocalDirection) null, true, false);
        this.powerStorage = new SimplePowerStorage(STORAGE_CAPACITY);
        this.worker = new ServerWorker(this, 100);
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
        ForgeDirection inputSide = DirectionUtils.getWorldDirection(POWER_INPUT_SIDE, this.getForwardDirection());
        return (inputSide == side);
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
        return this.powerStorage;
    }

    @Override
    public int getBurnTime() {
        return 0;
    }

    @Override
    public int getMaxBurnTime() {
        return 0;
    }

    @Override
    public boolean hasWork() {
        return false;
    }

    @Override
    public boolean canWork() {
        return false;
    }

    @Override
    public void workDone() {

    }

    @Override
    public void prepareWork() {
        // TODO Auto-generated method stub

    }

    @Override
    public void workCancelled() {
        // TODO Auto-generated method stub

    }

    @Override
    public void workProgressed(int amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beginWork() {
        // TODO Auto-generated method stub

    }

    @Override
    public TileEntity getTileEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IWorker getWorker() {
        // TODO Auto-generated method stub
        return null;
    }

}
