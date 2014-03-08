package ip.industrialProcessing.power;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPowerOutput extends IPowerEntity {
    boolean canOutputPower(ForgeDirection opposite);
}
