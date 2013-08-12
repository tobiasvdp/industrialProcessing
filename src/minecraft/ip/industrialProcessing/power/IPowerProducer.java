package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerProducer extends IPowerEntity{

    // TODO: make this sided
    int producePower(int maxAmount, boolean doProduce);

    boolean canProducePower(ForgeDirection opposite);

}
