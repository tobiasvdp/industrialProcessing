package mod.industrialProcessing.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class EntityVehicle extends Entity {

	protected Minecraft mc;

	public EntityVehicle(World par1World) {
		super(par1World);
		this.setSize(getSize()[0], getSize()[1]);
		this.stepHeight = getStepHeightAction();
		System.out.println(par1World);
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isEntityInvulnerable() {
		return true;
	}

	public EntityVehicle(World par1World, float x, float y, float z) {
		super(par1World);
		this.setPosition(x + 0.5, y + 1.0, z + 0.5);
		this.setSize(getSize()[0], getSize()[1]);
		this.stepHeight = getStepHeightRiding();

		if (par1World.isRemote) {
			mc = Minecraft.getMinecraft();
			this.rotationYaw = mc.thePlayer.rotationYaw;
		}
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (worldObj.isRemote) {
			if (mc == null) {
				mc = Minecraft.getMinecraft();
			}
			if (riddenByEntity != mc.thePlayer) {
				super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
			}
		}
	}

	public static ForgeDirection getForwardFromMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return null;
	}
	
    @Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity)
    {
        return this.boundingBox;
    }
    
    @Override
	public AxisAlignedBB getBoundingBox()
    {
        return this.boundingBox;
    }
    

    
    public boolean func_130002_c(EntityPlayer par1EntityPlayer)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                par1EntityPlayer.mountEntity(this);
            }

            return true;
        }
    }
    
    @Override
	public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

	@Override
	public void onUpdate() {
		super.onUpdate();
		doBlockCollisions();
		if (worldObj.isRemote) {
			if (mc == null) {
				mc = Minecraft.getMinecraft();
			}
			if (riddenByEntity != null && riddenByEntity == mc.thePlayer) {
				System.out.println("x:" + posX + " y:" + posY + " z:" + posZ);
				if (GameSettings.isKeyDown(mc.gameSettings.keyBindForward)) {
					float a = rotationYaw % 360 - this.riddenByEntity.rotationYaw % 360;
					a += (a > 180) ? -360 : (a < -180) ? 360 : 0;
					a = Math.min(Math.max(a, -20), 20);
					this.setRotation((this.rotationYaw - a / 10) % 360, this.rotationPitch);
					// this.riddenByEntity.rotationYaw =
					// this.riddenByEntity.rotationYaw + a/10;
					this.moveEntity(-(Math.sin(rotationYaw % 360 * Math.PI / 180)) / 7, 0, (Math.cos(rotationYaw % 360 * Math.PI / 180)) / 7);
				}
				if (GameSettings.isKeyDown(mc.gameSettings.keyBindBack)) {
					float a = rotationYaw % 360 - this.riddenByEntity.rotationYaw % 360;
					a += (a > 180) ? -360 : (a < -180) ? 360 : 0;
					a = Math.min(Math.max(a, -20), 20);
					this.setRotation((this.rotationYaw - a / 10) % 360, this.rotationPitch);
					// this.riddenByEntity.rotationYaw =
					// this.riddenByEntity.rotationYaw + a/10;
					this.moveEntity((Math.sin(rotationYaw % 360 * Math.PI / 180)) / 15, 0, -(Math.cos(rotationYaw % 360 * Math.PI / 180)) / 15);
				}
				if (GameSettings.isKeyDown(mc.gameSettings.keyBindLeft)) {
					this.setRotation((this.rotationYaw - 4) % 360, this.rotationPitch);
				}
				if (GameSettings.isKeyDown(mc.gameSettings.keyBindRight)) {
					this.setRotation((this.rotationYaw + 4) % 360, this.rotationPitch);
				}
			}
			otherUpdates();
			this.moveEntity(0, -0.5, 0);
			PacketDispatcher.sendPacketToServer(new PacketIP001EntityLocationAndRotation(this).getCustom250Packet());
		} else {

		}
	}

	public void otherUpdates() {
	}
	
	@Override
	public boolean canRiderInteract() {
		return true;
	}

	public abstract float[] getSize();

	public abstract float getStepHeightRiding();

	public abstract float getStepHeightAction();

}
