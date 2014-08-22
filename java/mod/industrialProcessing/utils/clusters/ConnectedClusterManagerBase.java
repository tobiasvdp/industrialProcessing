package mod.industrialProcessing.utils.clusters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class ConnectedClusterManagerBase<T extends IClusterItem<T, U>, U extends ICluster<T, U>> implements IClusterManager<T, U> {

	protected HashMap<UUID, U> clusters = new HashMap<UUID, U>();

	@Override
	public synchronized T add(IClusterTileEntity<T, U> item) {
		// search neighbors if they contain clusters of the same kind
		World world = item.getWorld();
		HashSet<UUID> neighborClusters = getNeighborClusters(item);
		T clusterItem = createItem(item);
		bind(clusterItem, item);
		UUID index;
		if (neighborClusters.isEmpty()) {
			U cluster = createCluster(UUID.randomUUID());
			index = cluster.getId();
			addCluster(cluster);
			cluster.addItem(clusterItem);
			System.out.println("No neighbors found, created new cluster " + index);
		} else {
			if (neighborClusters.size() == 1) {
				index = neighborClusters.iterator().next();
				U cluster = getCluster(index);
				cluster.addItem(clusterItem);
				System.out.println("One neighbor found, used cluster " + index);
			} else {
				U cluster = mergeClusters(world, neighborClusters);
				index = cluster.getId();
				cluster.addItem(clusterItem);
				System.out.println("Multiple neighbors found, created new cluster " + index);
			}
		}

		return clusterItem;
	}

	private HashSet<UUID> getNeighborClusters(IClusterTileEntity<T, U> item) {
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

	private HashSet<T> getNeighbors(IClusterTileEntity<T, U> item) {
		World world = item.getWorld();
		HashSet<T> neighborClusters = new HashSet<T>();
		for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
			ForgeDirection dir = ForgeDirection.getOrientation(i);
			if (canConnect(item, dir)) { // this one can connect to neighbor
				// find cluster of the neighbor if it can connect to this item.
				IClusterTileEntity<T, U> neighborCluster = getNeighbor(world, item.getX() + dir.offsetX, item.getY() + dir.offsetY, item.getZ() + dir.offsetZ, dir.getOpposite());

				if (neighborCluster != null) {
					neighborClusters.add(neighborCluster.getClusterItem());
				}
			}
		}
		return neighborClusters;
	}

	private U mergeClusters(World world, HashSet<UUID> neighborClusters) {
		U newCluster = createCluster(UUID.randomUUID());

		for (UUID oldClusterID : neighborClusters) {

			U oldCluster = getCluster(oldClusterID);
			if (oldCluster != null) {
				transferItems(oldCluster, newCluster);
				UUID id = oldCluster.getId();
				removeCluster(id);
			}
		}
		addCluster(newCluster);
		return newCluster;
	}

	private void addCluster(U newCluster) {
		this.clusters.put(newCluster.getId(), newCluster);
	}

	private void transferItems(U oldCluster, U newCluster) {
		for (T iCluster : oldCluster) {
			newCluster.addItem(iCluster);
		}
	}

	private void removeCluster(UUID key) {

		U cluster = this.clusters.remove(key);
		if (cluster != null)
			cluster.onRemoved();
	}

	private UUID getCluster(World worldObj, int i, int j, int k, ForgeDirection neighborDirection) {
		IClusterTileEntity<T, U> entity = getNeighbor(worldObj, i, j, k, neighborDirection);
		if (entity == null)
			return null;
		return entity.getClusterId();
	}

	private IClusterTileEntity<T, U> getNeighbor(World worldObj, int i, int j, int k, ForgeDirection neighborDirection) {
		TileEntity te = worldObj.getTileEntity(i, j, k);
		if (te == null)
			return null;
		IClusterTileEntity<T, U> entity = getClusterEntity(te);
		if (entity == null)
			return null;
		if (!canConnect(entity, neighborDirection))
			return null;
		return entity;
	}

	protected abstract boolean canConnect(IClusterTileEntity<T, U> item, ForgeDirection dir);

	protected abstract U createCluster(UUID id);

	protected abstract T createItem(IClusterTileEntity<T, U> entity);

	protected abstract IClusterTileEntity<T, U> getClusterEntity(TileEntity entity);

	@Override
	public synchronized void remove(IClusterTileEntity<T, U> entity) {
		UUID clusterId = entity.getClusterId();

		U cluster = clusters.get(clusterId);
		if (cluster == null)
			return;
		T item = entity.getClusterItem();
		cluster.removeItem(item);

		HashSet<T> items = new HashSet<T>();

		for (T t : cluster)
			items.add(t);

		HashSet<T> neighbors = getNeighbors(entity);
		System.out.println("Removed item had" + neighbors.size() + " neighbors: ");
		ArrayList<HashSet<T>> newClusters = new ArrayList<HashSet<T>>();
		for (T neighbor : neighbors) {
			HashSet<T> nCluster = createClusterWith(cluster, neighbor, items);
			if (nCluster != null) {
				newClusters.add(nCluster);
			}
		}
		if (newClusters.size() > 1) {
			for (HashSet<T> hashSet : newClusters) {
				createClusterForItems(hashSet);
			}

			removeCluster(cluster.getId());
		}
	}

	private void createClusterForItems(HashSet<T> hashSet) {
		U cluster = createCluster(UUID.randomUUID());
		addCluster(cluster);
		for (T t : hashSet) {
			cluster.addItem(t);
		}
	}

	private HashSet<T> createClusterWith(U oldCluster, T neighbor, HashSet<T> items) {

		HashSet<T> newClusterItems = new HashSet<T>();
		addToClusterFrom(newClusterItems, neighbor, items);
		if (newClusterItems.isEmpty())
			return null;
		return newClusterItems;
	}

	private void addToClusterFrom(HashSet<T> newCluster, T neighbor, HashSet<T> items) {
		if (items.remove(neighbor)) {
			IClusterTileEntity<T, U> entity = neighbor.getRegisteredEntity();
			if (entity == null)
				return;
			newCluster.add(neighbor);

			HashSet<T> neighbors = getNeighbors(entity);
			for (T t : neighbors) {
				addToClusterFrom(newCluster, t, items);
			}
		}
	}

	@Override
	public U getCluster(UUID id) {
		return this.clusters.get(id);
	}

	@Override
	public synchronized T load(IClusterTileEntity<T, U> item) {

		UUID id = item.getClusterId();
		U cluster = getCluster(id);

		if (cluster == null) {
			cluster = createCluster(id);
			addCluster(cluster);
		}
		T clusterItem = cluster.getItem(item.getX(), item.getY(), item.getZ());
		if (clusterItem == null) { // read from nbt, clusters are not in nbt
			clusterItem = createItem(item);
		}
		// chunk reload
		bind(clusterItem, item);
		cluster.loadItem(clusterItem);
		System.out.println("loaded item into cluster " + id);
		// TODO: check if cluster is touching other clusters, and merge those.

		return clusterItem;
	}

	private void bind(T clusterItem, IClusterTileEntity<T, U> item) {
		item.setClusterItem(clusterItem);
		clusterItem.registerEntity(item);
	}

}
