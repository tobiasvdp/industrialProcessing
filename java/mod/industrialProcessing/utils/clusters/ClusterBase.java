package mod.industrialProcessing.utils.clusters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public abstract class ClusterBase<T extends IClusterItem<T, U>, U extends ClusterBase<T, U>> implements ICluster<T, U> {

	private HashSet<T> clusterItems = new HashSet<T>();

	private UUID id;

	public ClusterBase(UUID id) {
		this.id = id;
	}

	@Override
	public void addItem(T item) {
		if (clusterItems.add(item)) { 
			item.onAddedToCluster((U)this); 
		} else
			System.err.format("Couldn't add item %s from cluster %s twice!", item, this);
	}

	@Override
	public T getItem(int x, int y, int z) {
		for (T t : clusterItems) {
			if (t.getX() == x && t.getY() == y && t.getZ() == z)
				return t;
		}
		return null;
	}

	@Override
	public void loadItem(T item) {
		if (clusterItems.add(item)) {
			item.onLoadedToCluster((U)this);
		}
	}

	@Override
	public void removeItem(T item) {
		if (clusterItems.remove(item)) {
			item.onRemovedFromCluster((U)this); 
		} else
			System.err.format("Couldn't remove item %s from cluster %s", item, this);
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	@Override
	public Iterator<T> iterator() {
		return clusterItems.iterator();
	}

	@Override
	public void onRemoved() {
		if (!clusterItems.isEmpty())
			System.out.println("Removed non-empty cluster?!");
	}
}
