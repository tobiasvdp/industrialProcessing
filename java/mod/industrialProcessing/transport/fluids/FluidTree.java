package mod.industrialProcessing.transport.fluids;

import java.util.HashSet;

import mod.industrialProcessing.fluids.BlockFluid;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidBlock;

public class FluidTree {
    HashSet<FluidCoordinate> candidateSet = new HashSet<FluidCoordinate>();
    HashSet<FluidCoordinate> closedSet = new HashSet<FluidCoordinate>();
    HashSet<FluidCoordinate> openSet = new HashSet<FluidCoordinate>();
    protected int halfSize = 64;

    public FluidTree() {
        openSet.add(new FluidCoordinate(0, 0, 0, null, 0));
    }

    public void reset() {
        candidateSet.clear();
        closedSet.clear();
        openSet.clear();
        openSet.add(new FluidCoordinate(0, 0, 0, null, 0));
    }

    public boolean iterate(World world, int x, int y, int z) {
        if (!openSet.isEmpty()) {
            FluidCoordinate current = getClosest(openSet);
            closedSet.add(current);
            if (validateCandidate(current, world, x, y, z)) {
                candidateSet.add(current);
            } 
            for (int i = 0; i < 6; i++) {
                ForgeDirection direction = ForgeDirection.getOrientation(i);
                FluidCoordinate neighbor = getNeighbor(current, direction, world, x, y, z);

                if (neighbor != null) {
                    if (closedSet.contains(neighbor))
                        continue;
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }

            }
            return true;
        } 
        return false;
    }

    protected boolean validateCandidate(FluidCoordinate current, World world, int x, int y, int z) {
        Block blockId = current.blockId;
        // id >= 0 && !air .. results in id > 0
        return FluidUtils.canDrainBlock(blockId, world, x + current.x, y + current.y, z + current.z);
    }

    public boolean adjust(World worldObj, int xCoord, int yCoord, int zCoord) {
        if (openSet.isEmpty()) {
            if (closedSet.isEmpty()) {
                openSet.add(new FluidCoordinate(0, 0, 0, null, 0));
            } else
                openSet = (HashSet<FluidCoordinate>) closedSet.clone();
        }
        return iterate(worldObj, xCoord, yCoord, zCoord);
    }

    public void add(FluidCoordinate add, World world, int x, int y, int z) {
        if (validateSize(add.x, add.y, add.z, world, x, y, z)) {
            if (validateBlock(add.blockId)) {
                closedSet.add(add);
                openSet.add(add);
            }
        }
    }

    private FluidCoordinate getNeighbor(FluidCoordinate current, ForgeDirection direction, World world, int x, int y, int z) {

        int tx = current.x + direction.offsetX;
        int ty = current.y + direction.offsetY;
        int tz = current.z + direction.offsetZ;
        if (validateSize(tx, ty, tz, world, x, y, z)) {
            Block id = world.getBlock(tx + x, ty + y, tz + z);
            if (validateBlock(id)) {
                float score = current.score + 1;
                return new FluidCoordinate(tx, ty, tz, id, score);
            }
        }

        return null;
    }

    protected boolean validateSize(int tx, int ty, int tz, World world, int wx, int wy, int wz) {

        if (tx < -halfSize || tx > halfSize)
            return false;
        if (tz < -halfSize || tz > halfSize)
            return false;
        // fluids may be the same level up to the sky
        if ((ty + wy) > 128 || ty < 0)
            return false;

        return true;
    }

    protected boolean validateBlock(Block id) {
            Block block = id;
            if (block == null)
                return true;
            if (block instanceof IFluidBlock)
                return true;
            if (block instanceof BlockFluid)
                return true;
        return false;
    }

    private FluidCoordinate getClosest(HashSet<FluidCoordinate> openSet2) {

        float currentDistance = 0;
        FluidCoordinate lowest = null;
        for (FluidCoordinate fluidCoordinate : openSet2) {
            float dist = fluidCoordinate.score;
            if (lowest == null || dist < currentDistance) {
                lowest = fluidCoordinate;
                currentDistance = dist;
            }
        }
        openSet2.remove(lowest);
        return lowest;
    }

    private FluidCoordinate getFarest(HashSet<FluidCoordinate> openSet2) {
        float currentDistance = 0;
        FluidCoordinate lowest = null;
        for (FluidCoordinate fluidCoordinate : openSet2) {
            float dist = fluidCoordinate.score;
            if (lowest == null || dist > currentDistance) {
                lowest = fluidCoordinate;
                currentDistance = dist;
            }
        }
        openSet2.remove(lowest);
        return lowest;
    }

    public FluidCoordinate getClosest() {
        return getClosest(candidateSet);
    }

    public FluidCoordinate getFarest() {
        return getFarest(candidateSet);
    }
}
