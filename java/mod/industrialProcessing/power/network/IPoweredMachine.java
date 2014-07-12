package mod.industrialProcessing.power.network;


public interface IPoweredMachine  extends IPowerAcceptor{
    IPowerStorage getMainPowerStorage();
}
