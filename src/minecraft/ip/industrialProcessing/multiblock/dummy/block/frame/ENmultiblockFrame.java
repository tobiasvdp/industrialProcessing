package ip.industrialProcessing.multiblock.dummy.block.frame;

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

	private int level;
	private boolean direction;

	public ENmultiblockFrame(World world, double x, double y, double z, Integer level, boolean upOrDown) {
		super(world);
		this.setSize(1F, 1F);
		this.setPosition(x, y, z);
		this.level = level;
		this.direction = upOrDown;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (direction) {
			if (this.posY > level + 0.1)
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX, -0.1, par1EntityPlayer.motionZ);
			else
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX, 0, par1EntityPlayer.motionZ);
		} else {
			if (this.posY < level - 0.1)
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX, 0.1, par1EntityPlayer.motionZ);
			else
				par1EntityPlayer.setVelocity(par1EntityPlayer.motionX, 0, par1EntityPlayer.motionZ);
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onLivingUpdate() {
		if (direction) {
			if (this.posY > level + 0.1)
				this.setPosition(this.posX, this.posY - 0.1, this.posZ);
		} else {
			if (this.posY < level - 0.1)
				this.setPosition(this.posX, this.posY + 0.1, this.posZ);
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
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
	}

}
