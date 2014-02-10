package ip.industrialProcessing.power;

public interface IPowerProducer extends IPowerEntity{ 
    float getCharge(float amount); 
    float getVoltage();
}
