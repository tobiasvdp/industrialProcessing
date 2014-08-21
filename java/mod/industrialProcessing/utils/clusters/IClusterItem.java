package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

public interface IClusterItem<T extends IClusterItem<T>> {

	/***
	 * invoked when item is added into a cluster
	 * @param cluster
	 */
	void onAddedToCluster(ICluster<T> cluster);
	/***
	 * invoked when item is loaded (from NBT) into a cluster for the first time, this happens when chunks get unloaded and loaded again
	 * @param cluster
	 */
	void onLoadedToCluster(ICluster<T> cluster);
	/***
	 * invoked when item is removed from a cluster
	 * @param cluster
	 */
	void onRemovedFromCluster(ICluster<T> cluster);

	void onClusterIdChanged(UUID newID);

	UUID getClusterID();

	IClusterTileEntity<T> getEntity();
}
