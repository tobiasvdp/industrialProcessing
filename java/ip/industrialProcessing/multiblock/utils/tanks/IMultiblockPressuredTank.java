package ip.industrialProcessing.multiblock.utils.tanks;

import net.minecraftforge.common.ForgeDirection;

public interface IMultiblockPressuredTank {
    float getPressure(int multiblockID, ForgeDirection from);
}
