package ip.industrialProcessing.power;

public interface IPoweredMachine  extends IPowerAcceptor{
    int getStoredPower();
    int getPowerCapacity();
}
