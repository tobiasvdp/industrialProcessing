package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public abstract class ClusterItemBase<T extends ClusterItemBase<T>> implements IClusterItem<T> {

	int dimension;
	int xCoord;
	int yCoord;
	int zCoord;
	UUID clusterId;

	private World getWorld() {
		return DimensionManager.getWorld(dimension);
	}

	public IClusterTileEntity<T> getEntity() {
		World world = getWorld();
		TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);

		return getClusterTileEntity(entity);
	}

	protected abstract IClusterTileEntity<T> getClusterTileEntity(TileEntity entity);

	@Override
	public void onAddedToCluster(ICluster<T> cluster) {
		IClusterTileEntity<T> entity = getEntity();
		if (entity != null)
			entity.onAddedToCluster(cluster.getId());
		else
			System.err.println("Line entity unloaded!");
	}

	@Override
	public void onLoadedToCluster(ICluster<T> cluster) {
		IClusterTileEntity<T> entity = getEntity();
		if (entity != null)
			entity.onLoadedToCluster(cluster.getId());
		else
			System.err.println("Line entity unloaded!");
	}
	@Override
	public void onRemovedFromCluster(ICluster<T> cluster) {
		IClusterTileEntity<T> entity = getEntity();
		if (entity != null)
			entity.onRemovedFromCluster(cluster.getId());
		else
			System.err.println("Line entity unloaded!");
	}

	@Override
	public void onClusterIdChanged(UUID newID) {
		this.clusterId = newID;

		IClusterTileEntity<T> entity = getEntity();
		if (entity != null)
			entity.onClusterIdChanged(newID);
		else
			System.err.println("Line entity unloaded!");
	}

	@Override
	public UUID getClusterID() {
		return clusterId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClusterItemBase<?>) {
			ClusterItemBase<?> other = (ClusterItemBase<?>) obj;
			return other.xCoord == xCoord && other.yCoord == yCoord && other.zCoord == zCoord && other.dimension == dimension;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return shift(xCoord, 0, 4) ^ shift(yCoord, 1, 4) ^ shift(zCoord, 2, 4) ^ shift(dimension, 3, 4);
	}

	private int shift(int bits, int i, int j) {
		int k = Integer.SIZE / j * i;
		return (bits >>> k) | (bits << (Integer.SIZE - k));
	}
}
