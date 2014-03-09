package mod.industrialProcessing.power;

public interface IPowerProducer extends IPowerEntity{ 
    float getCharge(float amount); 
    float getVoltage();
}
