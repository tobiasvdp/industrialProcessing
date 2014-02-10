package ip.industrialProcessing.multiblock.dummy.block.liftDoor;

import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ENmultiblockLiftDoor extends EntityLiving {

	private TEmultiblockElevator tileEntity;

	public ENmultiblockLiftDoor(World world) {
		super(world);
		setSize(0.9f, 1.0f);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return 14680112;
    }
	@Override
    public float getBrightness(float par1)
    {
    	return 10.0f;
    }

	public ENmultiblockLiftDoor(World world, double x, double y, double z, int modelID, TEmultiblockElevator te) {
		super(world);
		this.setSize(0.9F, 1F);
		this.setPosition(x, y, z);
		this.setX((int) x*10);
		this.setY((int) y*10);
		this.setZ((int) z*10);
		setModelID(modelID);
		this.tileEntity = te;
	}

	private void setModelID(int modelID) {
		dataWatcher.updateObject(17, modelID);
	}

	public int getModelID() {
		return dataWatcher.getWatchableObjectInt(17);
	}

	private int getDir() {
		return dataWatcher.getWatchableObjectInt(18);
	}

	public void setDir(int dir) {
		dataWatcher.updateObject(18, dir);
	}

	private int getPos() {
		return dataWatcher.getWatchableObjectInt(19);
	}

	public void setPos(int dir) {
		dataWatcher.updateObject(19, dir);
	}

	private boolean isOpen() {
		if (this.getDataWatcher().getWatchableObjectInt(23) == 0)
			return false;
		else
			return true;
	}

	private void setState(boolean dir) {
		if (dir) {
			this.getDataWatcher().updateObject(23, 1);
		} else {
			this.getDataWatcher().updateObject(23, 0);
		}
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		
		if (isOpen()) {

		} else {

		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onLivingUpdate() {
		if (getDir() == 1) {
			if (getModelID() == 0) {
				if (getPos() == 8) {
					setDir(0);
					setPos(getPos() + 1);
					setState(true);
				} else {
					setPos(getPos() + 1);
					setState(false);
					this.setPositionAndRotation(this.posX - 0.1, this.posY, posZ, this.rotationYaw, this.rotationPitch);
				}
			} else {
				if (getPos() == 8) {
					setDir(0);
					setState(true);
					setPos(getPos() + 1);
				} else {
					setState(false);
					setPos(getPos() + 1);
					this.setPositionAndRotation(this.posX + 0.1, this.posY, posZ, this.rotationYaw, this.rotationPitch);
				}
			}
		} else if (getDir() == 2) {
			if (getModelID() == 0) {
				if (getPos() == -1) {
					setDir(0);
					setState(false);
					this.setPositionAndRotation(this.getX()+0.5, this.getY(), this.getZ()+0.5, this.rotationYaw, this.rotationPitch);
				} else {
					setPos(getPos() - 1);
					setState(false);
					this.setPositionAndRotation(this.posX + 0.1, this.posY, posZ, this.rotationYaw, this.rotationPitch);
				}
			} else {
				if (getPos() == -1) {
					setDir(0);
					setState(false);
					this.setPositionAndRotation(this.getX()+0.5, this.getY(), this.getZ()+0.5, this.rotationYaw, this.rotationPitch);
				} else {
					setPos(getPos() - 1);
					setState(false);
					this.setPositionAndRotation(this.posX - 0.1, this.posY, posZ, this.rotationYaw, this.rotationPitch);
				}
			}
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
		this.dataWatcher.addObject(19, Integer.valueOf(0));
		this.dataWatcher.addObject(20, Integer.valueOf(0));
		this.dataWatcher.addObject(21, Integer.valueOf(0));
		this.dataWatcher.addObject(22, Integer.valueOf(0));
		this.dataWatcher.addObject(23, Integer.valueOf(1));
	}

	public double getX() {
		return ((double)dataWatcher.getWatchableObjectInt(20))/10;
	}

	public double getY() {
		return ((double)dataWatcher.getWatchableObjectInt(21))/10;
	}

	public double getZ() {
		return ((double)dataWatcher.getWatchableObjectInt(22))/10;
	}
	
	public void setX(int x){
		dataWatcher.updateObject(20, x);
	}
	
	public void setY(int y){
		dataWatcher.updateObject(21, y);
	}
	
	public void setZ(int z){
		dataWatcher.updateObject(22, z);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
	}
}
