package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import net.minecraft.world.World;

public interface IClusterItem<T extends IClusterItem<T, U>, U extends ICluster<T, U>> {

	int getX();

	int getY();

	int getZ();

	/***
	 * invoked when item is added into a cluster
	 * 
	 * @param cluster
	 */
	void onAddedToCluster(U cluster);

	/***
	 * invoked when item is loaded (from NBT) into a cluster for the first time, this happens when chunks get unloaded and loaded again
	 * 
	 * @param cluster
	 */
	void onLoadedToCluster(U cluster);

	/***
	 * invoked when item is removed from a cluster
	 * 
	 * @param cluster
	 */
	void onRemovedFromCluster(U cluster);

	UUID getClusterID();

	U getCluster();

	IClusterTileEntity<T, U> getEntity(World world);

	IClusterTileEntity<T, U> getRegisteredEntity();

	void registerEntity(IClusterTileEntity<T, U> entity);

	void unregisterEntity(IClusterTileEntity<T, U> entity);
}
