package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class AirTree extends FluidTree {

    @Override
    protected boolean validateSize(int tx, int ty, int tz, World world, int wx, int wy, int wz) {
        if (tx < -halfSize || tx > halfSize)
            return false;
        if (tz < -halfSize || tz > halfSize)
            return false;
        // air may be from this level, all the way down to bedrock
        if ((ty + wy) < 0 || ty > 0)
            return false;

        return true;
    }

    @Override
    protected boolean validateCandidate(FluidCoordinate current, World world, int x, int y, int z) {
        if (current.blockId == 0)
            return true; 
        if (current.blockId > 0 && current.blockId < Block.blocksList.length) {
            return !FluidUtils.isFullFluidBlock(current.blockId, world, x + current.x, y + current.y, z + current.z);
        }
        return current.blockId == 0;
    }

    @Override
    protected boolean validateBlock(int id) {
        return id == 0 || super.validateBlock(id);
    }
}
