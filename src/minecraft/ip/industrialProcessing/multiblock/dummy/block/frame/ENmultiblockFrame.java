package ip.industrialProcessing.multiblock.dummy.block.frame;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;

public class ENmultiblockFrame extends EntityLiving {

	public int level;
	public boolean direction;

	public ENmultiblockFrame(World world, double x, double y, double z, Integer level, boolean upOrDown) {
		super(world);
		this.setSize(1F, 1F);
		this.setPosition(x, y, z);
		setLevel(level);
		setDirection(upOrDown);
	}

	public ENmultiblockFrame(World world) {
		super(world);
		this.setSize(1F, 1F);
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (getDirection()) {
			if (this.posY > getLevel()+0.1f)
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX * 0.95, -0.1, par1EntityPlayer.motionZ * 0.95);
			else {
				double motion = par1EntityPlayer.motionY;
				if(par1EntityPlayer.motionY < 0)
					motion = 0;
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX * 0.95, motion, par1EntityPlayer.motionZ * 0.95);
				par1EntityPlayer.fallDistance = 0; 
			}
		} else {
			if (this.posY < getLevel()-0.1f)
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX * 0.95, 0.1, par1EntityPlayer.motionZ * 0.95);
			else {
				double motion = par1EntityPlayer.motionY;
				if(par1EntityPlayer.motionY < 0)
					motion = 0;
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX * 0.95, motion, par1EntityPlayer.motionZ * 0.95);
				par1EntityPlayer.fallDistance = 0; 
			}
		}
	}

	private int getLevel() {
		return this.getDataWatcher().getWatchableObjectInt(17);
	}

	private void setLevel(int level) {
		this.getDataWatcher().updateObject(17, level);
	}

	private boolean getDirection() {
		if (this.getDataWatcher().getWatchableObjectInt(18) == 0)
			return false;
		else
			return true;
	}

	private void setDirection(boolean dir) {
		if (dir) {
			this.getDataWatcher().updateObject(18, 1);
		} else {
			this.getDataWatcher().updateObject(18, 0);
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onLivingUpdate() {
		if (getDirection()) {
			if (this.posY > getLevel() +0.1f) {
				setPosition(this.posX, this.posY - 0.1, this.posZ);
			}
		} else {
			if (this.posY < getLevel() -0.1f)
				setPosition(this.posX, this.posY + 0.1, this.posZ);
		}
	}

	@Override
	protected boolean isAIEnabled() {
		return false;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(17, Integer.valueOf(0));
		this.dataWatcher.addObject(18, Integer.valueOf(0));
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
	}

	public void setNewLevel(Integer integer, boolean upOrDown) {
		setLevel(integer);
		setDirection(upOrDown);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("level", getLevel());
		par1NBTTagCompound.setBoolean("direction", getDirection());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		setLevel(par1NBTTagCompound.getInteger("level"));
		setDirection(par1NBTTagCompound.getBoolean("direction"));
	}
}
