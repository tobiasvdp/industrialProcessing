package mod.industrialProcessing.utils.clusters;

import java.util.UUID;

public interface ICluster<TClusterItem extends IClusterItem<TClusterItem>> extends Iterable<TClusterItem> {

	void addItem(TClusterItem item);
	void loadItem(TClusterItem item);
	void removeItem(TClusterItem item);

	UUID getId();

	void setId(UUID value);

	void onRemoved();

}
