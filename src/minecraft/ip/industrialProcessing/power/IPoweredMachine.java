package ip.industrialProcessing.power;

import ip.industrialProcessing.machines.IPowerStorage;

public interface IPoweredMachine  extends IPowerAcceptor{
    IPowerStorage getMainPowerStorage();
}
