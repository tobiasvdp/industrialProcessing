package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.utils.UUIDUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ClusterTileEntityBase<T extends IClusterItem<T, U>, U extends ICluster<T, U>> extends TileEntityBlockContainerIP implements IClusterTileEntity<T, U> {

	@Override
	public boolean canUpdate() {
		return false;
	}

	private UUID clusterId;
	private T clusterItem;

	@Override
	public World getWorld() {
		return this.worldObj;
	}

	@Override
	public int getX() {
		return xCoord;
	}

	@Override
	public int getY() {
		return yCoord;
	}

	@Override
	public int getZ() {
		return zCoord;
	}

	@Override
	public void onClusterChanged() {
		this.clusterId = this.clusterItem.getClusterID();
		System.out.println("Changed ID to " + this.clusterId);
		notifyBlockChange();
	}

	@Override
	public void onClusterLoaded() {
		this.clusterId = this.clusterItem.getClusterID();
	}

	@Override
	public UUID getClusterId() {
		return this.clusterId;
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {
		super.readFromNBT(p_145839_1_);
		if (p_145839_1_.hasKey("ClusterID")) {
			this.clusterId = UUIDUtil.getUUID(p_145839_1_.getByteArray("ClusterID"));
		} else
			this.clusterId = new UUID(0, 0);
	}

	@Override
	public void setWorldObj(World p_145834_1_) {
		super.setWorldObj(p_145834_1_);
		if (this.clusterItem == null)
			this.clusterItem = getManager(p_145834_1_).load(this);
	}

	protected abstract IClusterManager<T, U> getManager(World p_145834_1_);

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);

		byte[] data = UUIDUtil.getBytes(this.clusterId);
		if (data != null)
			p_145841_1_.setByteArray("ClusterID", data);
	}

	public boolean canConnect(ForgeDirection dir) {
		return true;
	}

	@Override
	public void onChunkUnload() {
		super.onChunkUnload();
		unregisterEntity();
	}

	public void unregisterEntity() {
		if (this.clusterItem != null)
			this.clusterItem.unregisterEntity(this);
		this.clusterItem = null;
	}

	protected U getCluster() {

		return (U) this.clusterItem.getCluster();
	}
 

	@Override
	public T getClusterItem() {
		return this.clusterItem;
	}

	@Override
	public void setClusterItem(T item) {
		this.clusterItem = item;
	}
}
