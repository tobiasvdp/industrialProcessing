package mod.industrialProcessing.power;


public interface IPoweredMachine  extends IPowerAcceptor{
    IPowerStorage getMainPowerStorage();
}
