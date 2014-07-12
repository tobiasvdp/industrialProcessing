package mod.industrialProcessing.transport.items.conveyorBelt.tileEntity;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.transport.CornerState;
import mod.industrialProcessing.blockContainer.transport.TileEntityTransport;
import mod.industrialProcessing.blockContainer.transport.TransportConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConnectionMode;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import mod.industrialProcessing.transport.items.conveyorBelt.util.DataUtils;
import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeState;
import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeUtils;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityConveyorConnectionsBase extends TileEntityTransport implements IRotateableEntity {

    protected SlopeState[] slopes = new SlopeState[6];
    protected int[] slopeMasks = new int[6];
    protected ConnectionMode[] connections = new ConnectionMode[6];
    protected Boolean[] canSlope = new Boolean[6];

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
	    this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
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

    @Override
    public void updateCorners() {
	CornerState corner = getCornerState(states);
	this.corner = corner;
	setLineID(HandlerRegistry.addToConveyorLine(this, false));
    }

    @Override
    protected CornerState getCornerState(TransportConnectionState[] states) {
	int count = 0;
	for (int i = 0; i < states.length; i++)
	    if (isConnection(states[i]))
		count++;
	if (count == 3) {
	    return CornerState.multi;
	}
	if (count == 2) {
	    int back = getForwardDirection().getOpposite().ordinal();
	    if (isConnection(states[back])) {
		int right = getForwardDirection().getRotation(ForgeDirection.UP).ordinal();
		int left = getForwardDirection().getRotation(ForgeDirection.DOWN).ordinal();
		if (isConnection(states[left])) {
		    return CornerState.right;
		}
		if (isConnection(states[right])) {
		    return CornerState.left;
		}
		return CornerState.straight;
	    }
	}
	if (count == 4) {
	    return CornerState.crossing;
	}
	return CornerState.invalid;
    }

    @Override
    protected CornerState getCornerState(LocalDirection localdir) {
	ForgeDirection dir = DirectionUtils.getWorldDirection(localdir, getForwardDirection());
	TileEntity te = this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
	if (te != null && te instanceof TileEntityConveyorConnectionsBase) {
	    return ((TileEntityConveyorConnectionsBase) te).getCornerState();
	}
	return null;
    }

    @Override
	public int isValidLineConnection(LocalDirection localdir, boolean forward) {
	ForgeDirection dir = getExternalDirection(localdir);
	int offsetSlope = getOffsetfromSlope(localdir);
	TileEntity te = this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY + offsetSlope, zCoord + dir.offsetZ);
	if (te != null && te instanceof TileEntityConveyorConnectionsBase) {
	    dir = dir.getOpposite();
	    LocalDirection localdir2 = DirectionUtils.getLocalDirection(dir, ((TileEntityConveyorConnectionsBase) te).getForwardDirection());
	    CornerState corner = ((TileEntityConveyorConnectionsBase) te).getCornerState();
	    if (forward)
		return isLineInput(localdir2, corner, ((TileEntityConveyorConnectionsBase) te));
	    else if (localdir2 == LocalDirection.BACK)
		return ((TileEntityConveyorConnectionsBase) te).getLineID();
	}
	return -1;
    }

    public int getOffsetfromSlope(LocalDirection localdir) {
	switch (slopes[localdir.ordinal()]) {
	case DOWN:
	    return -1;
	case FLAT:
	    return 0;
	case NONE:
	    return 0;
	case UP:
	    return 1;
	default:
	    return 0;
	}
    }

    private int isLineInput(LocalDirection localdir2, CornerState corner, TileEntityConveyorConnectionsBase te) {
	switch (corner) {
	case crossing:
	case straight:
	case multi:
	case invalid:
	    if (localdir2 == LocalDirection.FRONT)
		return te.getLineID();
	    break;
	case left:
	    if (localdir2 == LocalDirection.RIGHT)
		return te.getLineID();
	    break;
	case right:
	    if (localdir2 == LocalDirection.LEFT)
		return te.getLineID();
	    break;
	default:
	    break;
	}
	return -1;
    }

    private boolean isConnection(TransportConnectionState state) {
	return (state == TransportConnectionState.TRANSPORT || state == TransportConnectionState.INPUT || state == TransportConnectionState.OUTPUT);
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
	return DataUtils.getItem(direction, slopes, SlopeState.NONE, this.forwardDirection, 5);
    }

    public SlopeState getSlope(LocalDirection local) {
	return DataUtils.getItem(local, slopes, SlopeState.NONE, 5);
    }

    public boolean setSlope(SlopeState state, ForgeDirection direction) {
	LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
	return setSlope(state, local);
    }

    public boolean setSlope(SlopeState state, LocalDirection local) {
	int index = local.ordinal();
	if (index > 5)
	    return false;
	if (SlopeUtils.isInMask(state, slopeMasks[index])) {
	    slopes[index] = state;
	    System.out.println(index + " :" + state);
	    return true;
	}
	return false;
    }

    public void toggleSlope(EntityPlayer player) {

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

	Block blockId = this.worldObj.getBlock(xCoord, yCoord + 1, zCoord);
	this.worldObj.notifyBlockChange(xCoord, yCoord + 1, zCoord, blockId);
	this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
	blockId = this.worldObj.getBlock(xCoord, yCoord - 1, zCoord);
	this.worldObj.notifyBlockChange(xCoord, yCoord - 1, zCoord, blockId);

	this.notifyBlockChange();
	HandlerRegistry.removeFromConveyorLine((TileEntityConveyorTransportBase) this);
	HandlerRegistry.addToConveyorLine(this, false);
	this.searchForConnections();
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

	LocalDirection local = getLocalDirection(direction);

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

	HandlerRegistry.addToConveyorLine(this, true);
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
