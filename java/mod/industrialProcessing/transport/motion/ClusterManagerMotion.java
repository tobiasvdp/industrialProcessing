package mod.industrialProcessing.transport.motion;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import mod.industrialProcessing.utils.clusters.ConnectedClusterManagerBase;
import mod.industrialProcessing.utils.clusters.IClusterTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ClusterManagerMotion extends ConnectedClusterManagerBase<ClusterItemMotion, ClusterMotion> {

	// public static final ClusterManagerMotion manager = new ClusterManagerMotion();

	public static HashMap<World, ClusterManagerMotion> managers = new HashMap<World, ClusterManagerMotion>();

	public static synchronized ClusterManagerMotion manager(World world) {
		ClusterManagerMotion manager = managers.get(world);
		if (manager == null) {
			manager = new ClusterManagerMotion();
			managers.put(world, manager);
		}
		return manager;
	}

	public void update() {
		Collection<ClusterMotion> clusters = this.clusters.values();
		for (ClusterMotion iCluster : clusters) {
			iCluster.update();
		}
	}

	@Override
	protected boolean canConnect(IClusterTileEntity<ClusterItemMotion, ClusterMotion> item, ForgeDirection dir) {
		if (item instanceof ClusterTileEntityMotion) {
			ClusterTileEntityMotion entity = (ClusterTileEntityMotion) item;
			return entity.canConnect(dir);
		}
		return false;
	}

	@Override
	protected ClusterMotion createCluster(UUID id) {
		return new ClusterMotion(id);
	}

	@Override
	protected ClusterItemMotion createItem(IClusterTileEntity<ClusterItemMotion, ClusterMotion> entity) {
		return new ClusterItemMotion(entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	protected IClusterTileEntity<ClusterItemMotion, ClusterMotion> getClusterEntity(TileEntity te) {
		if (te instanceof ClusterTileEntityMotion) {
			ClusterTileEntityMotion tem = (ClusterTileEntityMotion) te;
			return tem;
		}
		return null;
	}

	public void clear() {
		this.clusters.clear();
	}

}
