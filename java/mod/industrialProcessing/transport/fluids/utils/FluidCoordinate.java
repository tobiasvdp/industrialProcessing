package mod.industrialProcessing.transport.fluids.utils;

import net.minecraft.block.Block;

public class FluidCoordinate {
    public FluidCoordinate(int x, int y, int z, Block blockId, float score) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blockId = blockId;
        this.score = score;
    }

    public Block blockId;
    public int x;
    public int y;
    public int z;
    public float score;

    @Override
    public int hashCode() {

        int bx = (x & 255);
        int by = (y & 255);
        int bz = (z & 255);

        return x << 16 + y << 8 + z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FluidCoordinate) {
            FluidCoordinate other = (FluidCoordinate) obj;
            return other.x == x && other.y == y && other.z == z;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + " " + x + ", " + y + ", " + z + " = " + blockId + " (" + score + ")";
    }

    public float getLengthSquared() {
        return x * x + y * y * +z * z;
    }
}
