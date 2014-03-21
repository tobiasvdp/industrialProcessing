package mod.industrialProcessing.power.network;

public interface IPowerProducer extends IPowerEntity{ 
    float getCharge(float amount); 
    float getVoltage();
}
