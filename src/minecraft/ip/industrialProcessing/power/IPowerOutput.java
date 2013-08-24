package ip.industrialProcessing.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerOutput extends IPowerEntity {
    boolean canOutputPower(ForgeDirection opposite);
}
