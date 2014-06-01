package mod.industrialProcessing.blockContainer;

import org.apache.commons.io.filefilter.CanReadFileFilter;

import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBlockContainerIP extends TileEntity implements IRotateableEntity {

	private ForgeDirection forwardDirection = ForgeDirection.NORTH;
	protected boolean canRotate = true;

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (this.forwardDirection != null)
			nbt.setByte("ForwardDirection", (byte) this.forwardDirection.ordinal());
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("ForwardDirection"))
			this.forwardDirection = ForgeDirection.VALID_DIRECTIONS[nbt.getByte("ForwardDirection")];
	};

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	protected void notifyBlockChange() {
		if (!this.worldObj.isRemote) {
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];
			String methodName = e.getMethodName();
			String className = e.getClassName();
		}

	}

	@Override
	public ForgeDirection getForwardDirection() {
		return forwardDirection;
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		if (canRotate)
			forwardDirection = forward;
		else
			forwardDirection = ForgeDirection.NORTH;
	}

	@Override
	public boolean canWrenchRotate() {
		return true;
	}

	protected int[][] rotationMatrix = new int[][] { { 0 }, { 0 }, { 0, 1, 3, 2, 5, 4 }, { 0, 1, 2, 3, 4, 5 }, { 0, 1, 4, 5, 3, 2 }, { 0, 1, 5, 4, 2, 3 } };
	protected int[][] rotationMatrixExternal = new int[][] { { 0 }, { 0 }, { 0, 1, 3, 2, 5, 4 }, { 0, 1, 2, 3, 4, 5 }, { 0, 1, 5, 4, 2, 3 }, { 0, 1, 4, 5, 3, 2 } };

	@Override
	public LocalDirection getLocalDirection(ForgeDirection dir) {
		if (getForwardDirection() != null)
			return LocalDirection.VALID_DIRECTIONS[rotationMatrix[getForwardDirection().ordinal()][dir.ordinal()]];
		return LocalDirection.FRONT;
	}

	@Override
	public LocalDirection getLocalDirection(int dir) {
		return getLocalDirection(ForgeDirection.VALID_DIRECTIONS[dir]);
	}

	@Override
	public ForgeDirection getExternalDirection(LocalDirection dir) {
		return ForgeDirection.VALID_DIRECTIONS[rotationMatrixExternal[getForwardDirection().ordinal()][dir.ordinal()]];
	}

}
