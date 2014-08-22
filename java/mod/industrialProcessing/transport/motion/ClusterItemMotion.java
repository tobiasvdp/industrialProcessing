package mod.industrialProcessing.transport.motion;

import mod.industrialProcessing.utils.clusters.ClusterItemBase;
import mod.industrialProcessing.utils.clusters.IClusterTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ClusterItemMotion extends ClusterItemBase<ClusterItemMotion> {

	@Override
	protected IClusterTileEntity<ClusterItemMotion> getClusterTileEntity(TileEntity entity) {
		if (entity instanceof TileEntityMotion)
			return (TileEntityMotion) entity;
		return null;
	}

}
