package mod.industrialProcessing.transport.motion;

import java.util.UUID;

import mod.industrialProcessing.power.utils.IMechanicalMotionReceiver;
import mod.industrialProcessing.utils.UUIDUtil;
import mod.industrialProcessing.utils.clusters.IClusterTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMotion extends TileEntity implements IClusterTileEntity<ClusterItemMotion> {

	@Override
	public boolean canUpdate() {
		return false;
	}
	
	private UUID clusterId;

	@Override
	public World getWorld() { 
		return this.worldObj;
	}
	@Override
	public int getX() { 
		return xCoord;
	}

	@Override
	public int getY() { 
		return yCoord;
	}

	@Override
	public int getZ() { 
		return zCoord;
	}

	@Override
	public void onLoadedToCluster(UUID id) { 
		// should be the same, only in case of a merge it might be different.
		 this.clusterId = id;
	}
	@Override
	public void onAddedToCluster(UUID id) {
		 this.clusterId = id;
	}

	@Override
	public void onRemovedFromCluster(UUID id) {
		 this.clusterId = new UUID(0,0);
	}

	@Override
	public void onClusterIdChanged(UUID newID) {
		 this.clusterId = newID;
	}

	@Override
	public UUID getClusterId() { 
		return this.clusterId;
	}

	 @Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {
		// TODO Auto-generated method stub
		super.readFromNBT(p_145839_1_); 
		this.clusterId = UUIDUtil.getUUID(p_145839_1_.getByteArray("ClusterID"));
		ClusterManagerMotion.manager.load(this);
	}
	  
	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) { 
		super.writeToNBT(p_145841_1_);

		byte[] data = UUIDUtil.getBytes(this.clusterId);
		p_145841_1_.setByteArray("ClusterID", data);
	}
	 
	public boolean canConnect(ForgeDirection dir) { 
		return true;
	}
}
