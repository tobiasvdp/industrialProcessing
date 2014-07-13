package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner;

import ip.industrialProcessing.subMod.mine.machines.mining.EntityMiner;
import net.minecraft.world.World;

public class EntityBobcatMiner extends EntityMiner {

	public int rotationAngle = 0;
	public int rotationRod = 0;
	boolean up = true;
	
	public EntityBobcatMiner(World par1World) {
		super(par1World);
		ignoreFrustumCheck = true;
	}

	public EntityBobcatMiner(World par1World, float x, float y, float z) {
		super(par1World, x, y, z);
		ignoreFrustumCheck = true;
	}
	
	
	@Override
	public void otherUpdates() {
		super.otherUpdates();
		if (worldObj.isRemote) {
			if (riddenByEntity != null && riddenByEntity == mc.thePlayer && this.canWork) {
				rotationAngle += 4;
				if(rotationAngle > 359){
					rotationAngle = 0;
				}
				if(up){
					rotationRod += 2;
				}else{
					rotationRod -=2;
				}
				if(rotationRod > 10)
					up = false;
				if(rotationRod < -10)
					up = true;
			}

		} else {

		}
	}

	@Override
	public int mineLeft() {
		return 0;
	}

	@Override
	public int mineRight() {
		return 0;
	}

	@Override
	public int mineUp() {
		return 2;
	}

	@Override
	public int mineYOffset() {
		return 0;
	}

	@Override
	public int getMaxCooldownTime() {
		return 10;
	}

	@Override
	public String getActivity() {
		return "Mining";
	}

	@Override
	public float[] getSize() {
		return new float[] { 0.9f, 1.8f };
	}

	@Override
	public float getStepHeightRiding() {
		return 1f;
	}

	@Override
	public float getStepHeightAction() {
		return 0.3f;
	}
	
	@Override
	public double getMountedYOffset() {
		{
			float height = this.height;
			return height - 1.5;
		}
	}

}
