package ip.industrialProcessing.transport.items.conveyorBelt.util;

import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ConveyorEnvironment {
    public static TileEntity getNeighbor(TileEntity ent, ForgeDirection direction, SlopeState slope) {
        if (slope == SlopeState.NONE)
            slope = SlopeState.FLAT;
        return getNeighbor(ent, direction.offsetX, direction.offsetY + (slope.ordinal() - 1), direction.offsetZ);
    }

    public static TileEntity getNeighbor(TileEntity ent, ForgeDirection direction) {
        return getNeighbor(ent, direction.offsetX, direction.offsetY, direction.offsetZ);
    }

    public static TileEntity getNeighbor(TileEntity ent, int dx, int dy, int dz) {
        int x = ent.xCoord + dx;
        int y = ent.yCoord + dy;
        int z = ent.zCoord + dz;
        return ent.worldObj.getBlockTileEntity(x, y, z);
    }

    public static TileEntityConveyorConnectionsBase getConveyor(TileEntity ent, ForgeDirection direction, SlopeState slope) {
        TileEntity other = getNeighbor(ent, direction, slope);
        if (other instanceof TileEntityConveyorConnectionsBase)
            return (TileEntityConveyorConnectionsBase) other;
        return null;
    }

    public static boolean isAir(TileEntity ent, int dx, int dy, int dz) {
        int x = ent.xCoord + dx;
        int y = ent.yCoord + dy;
        int z = ent.zCoord + dz;
        return ent.worldObj.isAirBlock(x, y, z);
    }

    public static boolean isAir(TileEntity ent, ForgeDirection direction) {
        return isAir(ent, direction.offsetX, direction.offsetY, direction.offsetZ);
    }

    public static boolean isAir(TileEntity ent, ForgeDirection direction, SlopeState slope) {
        return isAir(ent, direction.offsetX, direction.offsetY + (slope.ordinal() - 1), direction.offsetZ);
    }

    public static boolean canConnect(TileEntityConveyorConnectionsBase a, TileEntityConveyorConnectionsBase b, ForgeDirection direction, SlopeState aSlope, ConnectionMode aMode, boolean dubbleCheck) {

        ForgeDirection bDirection = direction.getOpposite();
        if (aMode == ConnectionMode.NONE)
            return false;
        ConnectionMode bMode = b.getConnectionMode(bDirection);
        if (bMode == ConnectionMode.NONE)
            return false;
        SlopeState bSlope = b.getSlope(bDirection);

        if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN) {
            // vertical: ignore slopes
            return aMode.canConnect(bMode);
        } else {
            int aY = a.yCoord;
            int bY = b.yCoord;

            if (bY == (aY + aSlope.ordinal() - 1) && (!dubbleCheck || aY == (bY + bSlope.ordinal() - 1))) {
                if (aMode.canConnect(bMode)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean canConnect(TileEntityConveyorConnectionsBase a, TileEntityConveyorConnectionsBase b, ForgeDirection direction, boolean dubbleCheck) {

        ConnectionMode aMode = a.getConnectionMode(direction);
        SlopeState aSlope = a.getSlope(direction);
        return canConnect(a, b, direction, aSlope, aMode, dubbleCheck);
    }
}
