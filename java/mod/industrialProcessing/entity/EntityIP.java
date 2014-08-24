package mod.industrialProcessing.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityIP extends Entity {

	public EntityIP(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEntityInvulnerable() {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean canRenderOnFire() {
		return false;
	}
	
	@Override
	public boolean isPushedByWater() {
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox() {
		return null;
	}
	
	

}
