package mod.industrialProcessing.transport.motion.axle;

import mod.industrialProcessing.transport.motion.ClusterManagerMotion;
import mod.industrialProcessing.transport.motion.ClusterMotion;
import mod.industrialProcessing.transport.motion.ClusterTileEntityMotion; 

public class TileEntityAxle extends ClusterTileEntityMotion {

	
	public float getSpeed(){
		ClusterMotion cluster =  ClusterManagerMotion.manager(this.worldObj).getCluster(this.getClusterId());
		return cluster.getSpeed();
	}
}
