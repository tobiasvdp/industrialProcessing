package mod.industrialProcessing.transport.motion;

import mod.industrialProcessing.utils.clusters.ClusterItemBase;
import mod.industrialProcessing.utils.clusters.IClusterTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ClusterItemMotion extends ClusterItemBase<ClusterItemMotion, ClusterMotion> {

	public ClusterItemMotion(int x, int y, int z) {
		super(x, y, z);
	}

	@Override
	protected IClusterTileEntity<ClusterItemMotion, ClusterMotion> getClusterTileEntity(TileEntity entity) {
		if (entity instanceof ClusterTileEntityMotion)
			return (ClusterTileEntityMotion) entity;
		return null;
	}
 

}
