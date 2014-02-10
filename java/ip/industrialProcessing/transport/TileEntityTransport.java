package ip.industrialProcessing.transport;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.transport.items.IConveyorLine;
import ip.industrialProcessing.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import ip.industrialProcessing.transport.items.conveyorBelt.CornerState;
import ip.industrialProcessing.utils.ConnectedTileUtils;

import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityTransport extends TileEntitySynced implements IConnectedTile, IConveyorLine {

	protected TransportConnectionState[] states = new TransportConnectionState[6];
	protected CornerState corner = CornerState.invalid;
	private boolean unverified = false;

	public TileEntityTransport() {
		Arrays.fill(states, TransportConnectionState.NONE);
	}

	@Override
	public int isValidLineConnection(LocalDirection localdir, boolean forward) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (unverified)
			updateConnections();
	}

	protected abstract TransportConnectionState getState(TileEntity entity, ForgeDirection direction);

	public void searchForConnections() {
		this.unverified = true;
		// detect bends
	}

	protected void updateConnections() {
		boolean modified = false;
		beginConnectionUpdate();
		for (int i = 0; i < this.states.length; i++) {
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			TransportConnectionState newState = getNeighborState(direction);
			if (newState == TransportConnectionState.NONE)
				newState = getSupportState(direction);
			TransportConnectionState currentState = this.states[i];
			if (newState != currentState) {
				this.states[i] = newState;
				modified = true;
			}
		}
		// if the network changed, update the map
		if (modified)
			updateNetwork();
		updateCorners();
		this.unverified = false;
	}

	public void updateCorners() {

	}

	protected CornerState getCornerState(TransportConnectionState[] states) {
		// corners are based on rotation, needs to be on a higher level
		return CornerState.invalid;
	}

	public CornerState getCornerState() {
		return corner;
	}

	protected CornerState getCornerState(LocalDirection dir) {
		// corners are based on rotation, needs to be on a higher level
		return null;
	}

	private TransportConnectionState getSupportState(ForgeDirection direction) {
		if (this.worldObj.isBlockFullCube(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ)) {
			return TransportConnectionState.SUPPORTED;
		}
		return TransportConnectionState.NONE;
	}

	protected void beginConnectionUpdate() {
	}

	public TransportConnectionState getTransportConnection(ForgeDirection direction) {
		return states[direction.ordinal()];
	}

	/**
	 * Sets the block ID and metadata at a given location. Args: X, Y, Z, new
	 * block ID, new metadata, flags. Flag 1 will cause a block update. Flag 2
	 * will send the change to clients (you almost always want this). Flag 4
	 * prevents the block from being re-rendered, if this is a client world.
	 * Flags can be added together.
	 */
	protected void updateNetwork() {
		notifyBlockChange();
	}

	public TransportConnectionState getNeighborState(ForgeDirection direction) {
		TileEntity entity = getConnectionNeighbor(direction);
		if (entity == null)
			return TransportConnectionState.NONE;
		return getState(entity, direction);
	}

	protected TileEntity getConnectionNeighbor(ForgeDirection direction) {
		return this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		return this.states[direction.ordinal()].getConnectionState();
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		ConnectedTileUtils.writeToNBT(par1nbtTagCompound, this.states);
		par1nbtTagCompound.setInteger("conveyorLine", conveyorLine);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		ConnectedTileUtils.readFromNBT(par1nbtTagCompound, this.states);
		conveyorLine = par1nbtTagCompound.getInteger("conveyorLine");
	}

	public void setBounds() {

		float xMin = -2 / 16f;
		float yMin = -2 / 16f;
		float zMin = -2 / 16f;
		float xMax = 2 / 16f;
		float yMax = 2 / 16f;
		float zMax = 2 / 16f;

		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			TransportConnectionState state = this.states[i];
			if (state.isConnected()) {
				float dx = direction.offsetX / 2f;
				float dz = direction.offsetZ / 2f;
				float dy = direction.offsetY / 2f;

				xMin = Math.min(xMin, dx);
				yMin = Math.min(yMin, dy);
				zMin = Math.min(zMin, dz);

				xMax = Math.max(xMax, dx);
				yMax = Math.max(yMax, dy);
				zMax = Math.max(zMax, dz);

			}
		}

		this.getBlockType().setBlockBounds(xMin + 0.5f, yMin + 0.5f, zMin + 0.5f, xMax + 0.5f, yMax + 0.5f, zMax + 0.5f);
	}

	public void addCollisionBoxesToList(AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			TransportConnectionState state = this.states[i];
			if (state.isConnected()) {

				double xMin = -2 / 16f;
				double yMin = -2 / 16f;
				double zMin = -2 / 16f;
				double xMax = 2 / 16f;
				double yMax = 2 / 16f;
				double zMax = 2 / 16f;

				double dx = direction.offsetX / 2f;
				double dz = direction.offsetZ / 2f;
				double dy = direction.offsetY / 2f;

				xMin = Math.min(xMin, dx) + xCoord + 0.5f;
				yMin = Math.min(yMin, dy) + yCoord + 0.5f;
				zMin = Math.min(zMin, dz) + zCoord + 0.5f;

				xMax = Math.max(xMax, dx) + xCoord + 0.5f;
				yMax = Math.max(yMax, dy) + yCoord + 0.5f;
				zMax = Math.max(zMax, dz) + zCoord + 0.5f;

				AxisAlignedBB bbx = AxisAlignedBB.getBoundingBox(xMin, yMin, zMin, xMax, yMax, zMax);
				if (bbx.intersectsWith(par5AxisAlignedBB)) {
					par6List.add(bbx);
				}
			}
		}
	}

	protected int conveyorLine = -1;

	@Override
	public int getConveyorLineID() {
		return conveyorLine;
	}

	@Override
	public void setConveyorLineID(int ID) {
		conveyorLine = ID;
		if(this.worldObj != null && worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord) != null){
			TileEntity te = worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord);
			if (te instanceof TileEntityConveyorBeltPowerInput){
				((TileEntityConveyorBeltPowerInput)(te)).conveyorLineSet(ID);
			}
		}
	}
}
