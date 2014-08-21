package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import mod.industrialProcessing.transport.motion.TileEntityMotion;

public interface IClusterManager<T extends IClusterItem<T>> {

	void load(IClusterTileEntity<T> tileEntityMotion);  
	UUID add(IClusterTileEntity<T> item);
	void remove(IClusterTileEntity<T> item);
	
	ICluster<T> getCluster(UUID id);
}
