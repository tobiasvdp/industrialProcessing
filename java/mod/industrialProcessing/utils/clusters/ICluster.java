package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

public interface ICluster<T extends IClusterItem<T, U>, U extends ICluster<T,U>> extends Iterable<T> {

	void addItem(T item);
	T getItem(int x, int y, int z);
	void removeItem(T item);
	void loadItem(T item);
	UUID getId(); 
	void onRemoved();

}
