package mod.industrialProcessing.power.network;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPowerOutput extends IPowerEntity {
    boolean canOutputPower(ForgeDirection opposite);
}
