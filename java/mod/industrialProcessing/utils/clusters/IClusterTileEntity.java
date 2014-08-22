package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import net.minecraft.world.World;

public interface IClusterTileEntity<T extends IClusterItem<T,U>, U extends ICluster<T,U>> {
	int getX();

	int getY();

	int getZ();

	World getWorld();

	void onClusterChanged(); 
 
	UUID getClusterId();
	
	T getClusterItem();
	void setClusterItem(T item);

	void onClusterLoaded();
}
