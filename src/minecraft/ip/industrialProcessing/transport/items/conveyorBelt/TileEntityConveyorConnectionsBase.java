package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.transport.items.conveyorBelt.util.DataUtils;
import ip.industrialProcessing.transport.items.conveyorBelt.util.SlopeUtils;
import ip.industrialProcessing.utils.DirectionUtils;

import java.util.Arrays;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorConnectionsBase extends TileEntityTransport implements IRotateableEntity {

    protected SlopeState[] slopes = new SlopeState[4];
    protected int[] slopeMasks = new int[4];
    protected ConnectionMode[] connections = new ConnectionMode[6];
    protected Boolean[] canSlope = new Boolean[4];

    protected ForgeDirection forwardDirection = ForgeDirection.NORTH;

    @Override
    public ForgeDirection getForwardDirection() {
        return this.forwardDirection;
    }

    @Override
    public void setForwardDirection(ForgeDirection forward) {
        this.forwardDirection = forward;
        searchForConnections();
        notifyBlockChange();
        if (this.worldObj != null)
            this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType().blockID);
    }

    public TileEntityConveyorConnectionsBase() {
        Arrays.fill(slopes, SlopeState.FLAT);
        Arrays.fill(slopeMasks, SlopeState.FLAT.ordinal());
        Arrays.fill(connections, ConnectionMode.INPUT);
        Arrays.fill(canSlope, false);
        setSlopeMode(LocalDirection.FRONT, true);
        setSlopeMode(LocalDirection.BACK, true);
        setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
        setConnectionMode(LocalDirection.UP, ConnectionMode.NONE);
        setConnectionMode(LocalDirection.DOWN, ConnectionMode.NONE);
    }

    public void setSlopeMode(LocalDirection local, Boolean value) {
        DataUtils.setItem(local, this.canSlope, value, 3);
    }

    public void setConnectionMode(LocalDirection local, ConnectionMode mode) {
        DataUtils.setItem(local, this.connections, mode, 5);
    }

    public ConnectionMode getConnectionMode(ForgeDirection direction) {
        return DataUtils.getItem(direction, connections, ConnectionMode.NONE, this.forwardDirection, 5);
    }

    public ConnectionMode getConnectionMode(LocalDirection local) {
        return DataUtils.getItem(local, connections, ConnectionMode.NONE, 5);
    }

    public SlopeState getSlope(ForgeDirection direction) {
        return DataUtils.getItem(direction, slopes, SlopeState.NONE, this.forwardDirection, 3);
    }

    public SlopeState getSlope(LocalDirection local) {
        return DataUtils.getItem(local, slopes, SlopeState.NONE, 3);
    }

    public boolean setSlope(SlopeState state, ForgeDirection direction) {
        LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
        return setSlope(state, local);
    }

    public boolean setSlope(SlopeState state, LocalDirection local) {
        int index = local.ordinal();
        if (index > 3)
            return false;
        if (SlopeUtils.isInMask(state, slopeMasks[index])) {
            slopes[index] = state;
            return true;
        }
        return false;
    }

    public void toggleSlope() {

        SlopeState oldFront = getSlope(LocalDirection.FRONT);
        SlopeState oldBack = getSlope(LocalDirection.BACK);

        SlopeState[] values = SlopeState.values();
        int totalOrdinal = oldFront.ordinal() + oldBack.ordinal() * 3;
        boolean allOk = false;
        do {
            totalOrdinal++;
            totalOrdinal %= 9;
            int front = totalOrdinal % 3;
            int back = totalOrdinal / 3;

            allOk = (back != front || back == SlopeState.FLAT.ordinal()) && setSlope(values[front], LocalDirection.FRONT) && setSlope(values[back], LocalDirection.BACK);
        } while (!allOk);

        int blockId = this.worldObj.getBlockId(xCoord, yCoord + 1, zCoord);
        this.worldObj.notifyBlockChange(xCoord, yCoord + 1, zCoord, blockId);
        this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType().blockID);
        blockId = this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord);
        this.worldObj.notifyBlockChange(xCoord, yCoord - 1, zCoord, blockId);

        this.notifyBlockChange();
    }

    @Override
    protected void beginConnectionUpdate() {
        boolean canGoDown = ConveyorEnvironment.isAir(this, ForgeDirection.DOWN);
        LocalDirection[] directions = LocalDirection.values();
        for (int i = 0; i < 4; i++) {
            LocalDirection local = directions[i];
            ForgeDirection direction = DirectionUtils.getWorldDirection(local, this.forwardDirection);

            this.slopeMasks[i] = 1 << SlopeState.FLAT.ordinal();
            ConnectionMode mode = this.connections[i];
            if (mode != null && mode != ConnectionMode.NONE && canSlope[i]) {
                this.slopeMasks[i] += checkMask(direction, SlopeState.UP, mode);
                this.slopeMasks[i] += checkMask(direction, SlopeState.DOWN, mode);
            }
        }
    }

    private int checkMask(ForgeDirection direction, SlopeState slope, ConnectionMode mode) {

        TileEntityConveyorConnectionsBase belt = ConveyorEnvironment.getConveyor(this, direction, slope);
        if (belt != null) {
            if (ConveyorEnvironment.canConnect(this, belt, direction, slope, mode, false)) {
                return 1 << slope.ordinal();
            }
        }
        return 0;
    }

    @Override
    protected TileEntity getConnectionNeighbor(ForgeDirection direction) {

        LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);

        ConnectionMode mode = getConnectionMode(local);
        if (mode == ConnectionMode.NONE)
            return null;

        SlopeState slope = getSlope(local);
        return ConveyorEnvironment.getNeighbor(this, direction, slope);

    }

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {

        if (entity instanceof TileEntityConveyorConnectionsBase) {
            TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) entity;

            if (ConveyorEnvironment.canConnect(this, belt, direction, true))
                return TransportConnectionState.TRANSPORT;
        }

        return handleInventoryState(entity, direction);
    }

    protected TransportConnectionState handleInventoryState(TileEntity entity, ForgeDirection direction) {
        return TransportConnectionState.NONE;
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
        super.writeToNBT(par1nbtTagCompound);

        par1nbtTagCompound.setInteger("Forward", this.forwardDirection.ordinal());
        writeToNBT(slopes, par1nbtTagCompound, "Slopes");
        writeToNBT(connections, par1nbtTagCompound, "ConnectionModes");
        par1nbtTagCompound.setIntArray("SlopeMasks", slopeMasks);
        writeToNBT(canSlope, par1nbtTagCompound, "CanSlopes");
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
        super.readFromNBT(par1nbtTagCompound);

        this.forwardDirection = ForgeDirection.getOrientation(par1nbtTagCompound.getInteger("Forward"));

        SlopeState[] possibleSlopeStates = SlopeState.values();
        int[] ordinals = par1nbtTagCompound.getIntArray("Slopes");
        for (int i = 0; i < Math.min(slopes.length, ordinals.length); i++) {
            slopes[i] = possibleSlopeStates[ordinals[i]];
        }

        ConnectionMode[] possibleConnectionModes = ConnectionMode.values();
        ordinals = par1nbtTagCompound.getIntArray("ConnectionModes");
        for (int i = 0; i < Math.min(connections.length, ordinals.length); i++) {
            connections[i] = possibleConnectionModes[ordinals[i]];
        }

        slopeMasks = par1nbtTagCompound.getIntArray("SlopeMasks");

        canSlope = readFromNBT(par1nbtTagCompound, "CanSlopes", canSlope);
    }

    private Boolean[] readFromNBT(NBTTagCompound par1nbtTagCompound, String string, Boolean[] data) {
        byte[] ordinals = par1nbtTagCompound.getByteArray(string);
        for (int i = 0; i < ordinals.length; i++) {
            data[i] = (ordinals[i] != 0);
        }
        return data;
    }

    private <T extends Enum> T[] readFromNBT(NBTTagCompound par1nbtTagCompound, String string, T[] values) {
        int[] ordinals = par1nbtTagCompound.getIntArray(string);
        Enum[] data = new Enum[ordinals.length];
        for (int i = 0; i < ordinals.length; i++) {
            data[i] = values[ordinals[i]];
        }
        return (T[]) data;
    }

    private void writeToNBT(Boolean[] data, NBTTagCompound par1nbtTagCompound, String string) {
        byte[] ordinals = new byte[data.length];
        for (int i = 0; i < ordinals.length; i++) {
            ordinals[i] = (byte) (data[i] ? 1 : 0);
        }
        par1nbtTagCompound.setByteArray(string, ordinals);
    }

    private void writeToNBT(Enum[] data, NBTTagCompound par1nbtTagCompound, String string) {
        int[] ordinals = new int[data.length];
        for (int i = 0; i < ordinals.length; i++) {
            ordinals[i] = data[i].ordinal();
        }
        par1nbtTagCompound.setIntArray(string, ordinals);
    }

    @Override
    public boolean canWrenchRotate() {
        return true;
    }
}
