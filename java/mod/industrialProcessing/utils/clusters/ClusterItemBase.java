package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class ClusterItemBase<T extends ClusterItemBase<T, U>, U extends ClusterBase<T, U>> implements IClusterItem<T, U> {

	int xCoord;
	int yCoord;
	int zCoord;
	UUID clusterId;
	private IClusterTileEntity<T, U> registeredEntity;
	private U cluster;

	public ClusterItemBase(int x, int y, int z) {
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
	}

	public int getX() {
		return xCoord;
	}

	public int getY() {
		return yCoord;
	}

	public int getZ() {
		return zCoord;
	}

	public IClusterTileEntity<T, U> getEntity(World world) {
		TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);

		return getClusterTileEntity(entity);
	}

	public void registerEntity(IClusterTileEntity<T, U> entity) {
		this.registeredEntity = entity;
	}

	public void unregisterEntity(IClusterTileEntity<T, U> entity) {
		if (registeredEntity == entity)
			this.registeredEntity = null;
	}

	public IClusterTileEntity<T, U> getRegisteredEntity() {
		return registeredEntity;
	}

	protected abstract IClusterTileEntity<T, U> getClusterTileEntity(TileEntity entity);

	@Override
	public void onAddedToCluster(U cluster) {
		this.clusterId = cluster.getId();
		this.cluster = cluster;
		IClusterTileEntity<T, U> entity = getRegisteredEntity();
		if (entity != null)
			entity.onClusterChanged();
		else
			System.err.println("Line entity unloaded!");
	}
	 

	@Override
	public void onLoadedToCluster(U cluster) {
		this.clusterId = cluster.getId();
		this.cluster = cluster;
		IClusterTileEntity<T, U> entity = getRegisteredEntity();
		if (entity != null)
			entity.onClusterLoaded();
		else
			System.err.println("Line entity unloaded!");
	}

	@Override
	public void onRemovedFromCluster(U cluster) {
		this.clusterId = null;
		this.cluster = null;
		IClusterTileEntity<T, U> entity = getRegisteredEntity();
		if (entity != null)
			entity.onClusterChanged();
		else
			System.err.println("Line entity unloaded!");
	}

	@Override
	public UUID getClusterID() {
		return clusterId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClusterItemBase<?, ?>) {
			ClusterItemBase<?, ?> other = (ClusterItemBase<?, ?>) obj;
			return other.xCoord == xCoord && other.yCoord == yCoord && other.zCoord == zCoord;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return shift(xCoord, 0, 3) ^ shift(yCoord, 1, 3) ^ shift(zCoord, 2, 3);
	}

	private int shift(int bits, int i, int j) {
		int k = Integer.SIZE / j * i;
		return (bits >>> k) | (bits << (Integer.SIZE - k));
	}
	
	@Override
	public U getCluster() { 
		return this.cluster;
	}
}
