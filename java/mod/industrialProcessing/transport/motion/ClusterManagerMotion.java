package mod.industrialProcessing.transport.motion;

import java.util.Collection;
import java.util.UUID;

import mod.industrialProcessing.utils.clusters.ConnectedClusterManagerBase;
import mod.industrialProcessing.utils.clusters.ICluster;
import mod.industrialProcessing.utils.clusters.IClusterTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ClusterManagerMotion extends ConnectedClusterManagerBase<ClusterItemMotion> {

	public static final ClusterManagerMotion manager = new ClusterManagerMotion();

	public void update()
	{
		 Collection<ICluster<ClusterItemMotion>> clusters = this.clusters.values();
		 for (ICluster<ClusterItemMotion> iCluster : clusters) {
			((ClusterMotion) iCluster).update();
		}
		 
	}
	
	@Override
	protected boolean canConnect(IClusterTileEntity<ClusterItemMotion> item, ForgeDirection dir) {
		if (item instanceof TileEntityMotion) {
			TileEntityMotion entity = (TileEntityMotion) item;
			return entity.canConnect(dir);
		}
		return false;
	}

	@Override
	protected ICluster<ClusterItemMotion> createCluster(UUID id) { 
		return new ClusterMotion(id);
	}

	@Override
	protected ClusterItemMotion getClusterItemFromTE(TileEntity te) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ClusterItemMotion createItem(IClusterTileEntity<ClusterItemMotion> entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
