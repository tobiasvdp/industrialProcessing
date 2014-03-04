package mod.industrialProcessing.gui.containers.handlers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.power.IPoweredMachine;

public class PowerHandler extends ProgressHandlerBase {

    private IPoweredMachine machine;

    public PowerHandler(IPoweredMachine machine) {
        super(100f);
        this.machine = machine;
    }

    @Override
    public void readFromEntity() {
        IPowerStorage storage = machine.getMainPowerStorage();

        int value = (int) storage.getStoredPower();
        int max = (int) storage.getPowerCapacity();

        this.setValues(value, max);
    }
}
