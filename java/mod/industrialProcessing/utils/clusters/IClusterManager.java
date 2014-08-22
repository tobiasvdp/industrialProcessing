package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import mod.industrialProcessing.transport.motion.ClusterTileEntityMotion;

public interface IClusterManager<T extends IClusterItem<T, U>, U extends ICluster<T, U>> {

	T load(IClusterTileEntity<T, U> tileEntityMotion);

	T add(IClusterTileEntity<T, U> item);

	void remove(IClusterTileEntity<T, U> item);

	U getCluster(UUID id);
}
