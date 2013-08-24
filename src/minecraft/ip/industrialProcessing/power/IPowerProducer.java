package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerProducer extends IPowerEntity{ 
    float getCharge(float amount); 
    float getVoltage();
}
