package mod.industrialProcessing.blockContainer;

import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBlockContainerIP extends TileEntity implements IRotateableEntity {

	 private ForgeDirection forwardDirection;
	
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
		forwardDirection = forward;
	}

	@Override
	public boolean canWrenchRotate() {
		return true;
	}
}
