package mod.industrialProcessing.utils.clusters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ConnectedClusterManagerBase<T extends IClusterItem<T>> implements IClusterManager<T> {

	protected HashMap<UUID, ICluster<T>> clusters = new HashMap<UUID, ICluster<T>>();

	@Override
	public synchronized UUID add(IClusterTileEntity<T> item) {
		// search neighbors if they contain clusters of the same kind
		World world = item.getWorld();
		HashSet<UUID> neighborClusters = getNeighborClusters(item);
		UUID index;
		if (neighborClusters.isEmpty()) {
			ICluster<T> cluster = createCluster(UUID.randomUUID());
			index = cluster.getId();
			addCluster(cluster);
			cluster.addItem(createItem(item));
		} else {
			if (neighborClusters.size() == 1) {
				index = neighborClusters.iterator().next();
				ICluster<T> cluster = getCluster(index);
				cluster.addItem(createItem(item));
			} else {
				ICluster<T> cluster = mergeClusters(world, neighborClusters);
				index = cluster.getId();
				cluster.addItem(createItem(item));
			}
		}

		return index;
	}

	private HashSet<UUID> getNeighborClusters(IClusterTileEntity<T> item) {
		World world = item.getWorld();
		HashSet<UUID> neighborClusters = new HashSet<UUID>();
		for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
			ForgeDirection dir = ForgeDirection.getOrientation(i);
			if (canConnect(item, dir)) { // this one can connect to neighbor
				// find cluster of the neighbor if it can connect to this item.
				UUID neighborCluster = getCluster(world, item.getX() + dir.offsetX, item.getY() + dir.offsetY, item.getZ() + dir.offsetZ, dir.getOpposite());

				if (neighborCluster != null) {
					neighborClusters.add(neighborCluster);
				}
			}
		}
		return neighborClusters;
	}

	private ICluster<T> mergeClusters(World world, HashSet<UUID> neighborClusters) {
		ICluster<T> newCluster = createCluster(UUID.randomUUID());

		for (UUID oldClusterID : neighborClusters) {

			ICluster<T> oldCluster = getCluster(oldClusterID);
			if (oldCluster != null) {
				transferItems(oldCluster, newCluster);
				UUID id = oldCluster.getId();
				removeCluster(id);
			}
		}
		addCluster(newCluster);
		return newCluster;
	}

	private void addCluster(ICluster<T> newCluster) {
		this.clusters.put(newCluster.getId(), newCluster);
	}

	private void transferItems(ICluster<T> oldCluster, ICluster<T> newCluster) {
		for (T iCluster : oldCluster) {
			newCluster.addItem(iCluster);
		}
	}

	private void removeCluster(UUID key) {

		ICluster<T> cluster = this.clusters.remove(key);
		cluster.onRemoved();
	}

	private UUID getCluster(World worldObj, int i, int j, int k, ForgeDirection neighborDirection) {
		TileEntity te = worldObj.getTileEntity(i, j, k);
		T item = getClusterItemFromTE(te);
		if (item == null)
			return null;
		IClusterTileEntity<T> entity = item.getEntity();
		if (entity == null)
			return null;

		if (!canConnect(entity, neighborDirection))
			return null;
		return item.getClusterID();
	}

	protected abstract boolean canConnect(IClusterTileEntity<T> item, ForgeDirection dir);

	protected abstract ICluster<T> createCluster(UUID id);

	protected abstract T getClusterItemFromTE(TileEntity te);

	protected abstract T createItem(IClusterTileEntity<T> entity);

	@Override
	public synchronized void remove(IClusterTileEntity<T> item) {
		UUID clusterId = item.getClusterId();

		ICluster<T> cluster = clusters.get(clusterId);
		cluster.removeItem(createItem(item));

		// verify if cluster is still connected.
	}

	@Override
	public ICluster<T> getCluster(UUID id) {
		return this.clusters.get(id);
	}

	@Override
	public synchronized void load(IClusterTileEntity<T> item) {

		UUID id = item.getClusterId();
		ICluster<T> cluster = getCluster(id);

		if (cluster == null) {
			cluster = createCluster(id);
			addCluster(cluster);
		}
		cluster.loadItem(createItem(item));

		// TODO: check if cluster is touching other clusters, and merge those.
	}

}
