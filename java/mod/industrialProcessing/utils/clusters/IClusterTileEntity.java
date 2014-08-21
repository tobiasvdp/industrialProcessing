package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

import net.minecraft.world.World;

public interface IClusterTileEntity<T extends IClusterItem<T>> {
	int getX();

	int getY();

	int getZ();

	World getWorld();

	void onAddedToCluster(UUID id);
	void onLoadedToCluster(UUID id);


	void onRemovedFromCluster(UUID id);

	void onClusterIdChanged(UUID newID);

	UUID getClusterId();
}
