package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.power.IPoweredMachine;

public class PowerHandler extends ProgressHandlerBase {

    private IPoweredMachine machine;

    public PowerHandler(IPoweredMachine machine) { 
	super(1);
	this.machine = machine;
    }

    @Override
    public void readFromEntity() {
	IPowerStorage storage =  machine.getMainPowerStorage();
	
	int value = storage.getStoredPower();
	int max = storage.getPowerCapacity();
	
	this.setValues(value, max);
    } 
}
