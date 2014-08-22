package mod.industrialProcessing.utils.clusters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public abstract class ClusterBase<T extends IClusterItem<T>> implements ICluster<T> {

	private HashSet<T> clusterItems = new HashSet<T>();
	private UUID id;

	public ClusterBase(UUID id) {
		this.id = id;
	}

	@Override
	public void addItem(T item) {
		if (clusterItems.add(item)) {
			item.onAddedToCluster(this);
		} else
			System.err.format("Couldn't add item %s from cluster %s twice!", item, this);
	}

	@Override
	public void loadItem(T item) {
		if(clusterItems.add(item))
		{
			item.onLoadedToCluster(this);
		}
	}
	
	@Override
	public void removeItem(T item) {
		if (clusterItems.remove(item)) {
			item.onRemovedFromCluster(this);
		} else
			System.err.format("Couldn't remove item %s from cluster %s", item, this);
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	@Override
	public void setId(UUID value) {
		this.id = value;
		for (T t : clusterItems) {
			t.onClusterIdChanged(value); // in case nbt needs to update.
		}
	}

	@Override
	public Iterator<T> iterator() {
		return clusterItems.iterator();
	}

	@Override
	public void onRemoved() {
		 
	}
}
