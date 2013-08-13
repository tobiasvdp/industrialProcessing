package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerProducer extends IPowerEntity{ 
    int producePower(int maxAmount, boolean doProduce); 
    boolean canOutputPower(ForgeDirection opposite);

}
