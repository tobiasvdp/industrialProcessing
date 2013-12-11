package ip.industrialProcessing.transport.steve.railway.suspended.cart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFloatingCart extends Entity {

	private double speedX = 0;
	private double speedY = 0;
	private double speedZ = 0;

	public EntityPlayer getRider() {
		return (EntityPlayer) this.worldObj.getPlayerEntityByName(dataWatcher.getWatchableObjectString(17));
	}

	public void setRider(EntityPlayer player) {
		this.dataWatcher.updateObject(17, player.username);
	}

	public boolean getOccupied() {
		return dataWatcher.getWatchableObjectInt(18) == 1;
	}

	public void setOccupied(boolean val) {
		if (val)
			this.dataWatcher.updateObject(18, 1);
		else
			this.dataWatcher.updateObject(18, 0);
	}

	public EntityFloatingCart(World par1World) {
		super(par1World);
		this.setSize(1.0f, 1.0f);
	}

	public EntityFloatingCart(World world, double d, double y, double e, String name) {
		super(world);
		this.setSize(1.2f, 2.0f);
		this.posX = d;
		this.posY = y;
		this.posZ = e;
		this.boundingBox.setBounds(d, y, e, d + 1, y + 1, e + 1);
		setName(name);
	}

	@Override
	protected void entityInit() {
		this.getDataWatcher().addObject(17, "");
		this.getDataWatcher().addObject(18, Integer.valueOf(0));
		this.getDataWatcher().addObject(19, "");
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return this.boundingBox;
	}

	@Override
	public boolean shouldRiderSit() {
		return true;
	}

	@Override
	public void onUpdate() {
		if (getOccupied()) {
			moveForward();
			EntityPlayer player = getRider();
			player.setPosition(this.posX, this.posY, this.posZ);
			player.setVelocity(0, 0, 0);
			this.boundingBox.setBounds(this.posX, this.posY, this.posZ, this.posX + 1, this.posY + 1, this.posZ + 1);
		} else {
		}
		super.onUpdate();
	}

	private void moveForward() {
		int meta = this.worldObj.getBlockMetadata((int) this.posX, (int) this.posY + 1, (int) this.posZ);
		switch (meta) {
		case 1:
			this.posX += speedX;
			this.posZ = (int) this.posZ + 0.5;
			if (speedX > 0 && speedX < 0.1)
				speedX += 0.001;
			if (speedX < 0 && speedX > -0.1)
				speedX -= 0.001;
			if (speedX == 0)
				speedX += 0.001;
			speedZ = 0;
			break;
		case 2:
			this.posZ += speedZ;
			this.posX = (int) this.posX + 0.5;
			if (speedZ > 0 && speedZ < 0.1)
				speedZ += 0.001;
			if (speedZ < 0 && speedZ > -0.1)
				speedZ -= 0.001;
			if (speedZ == 0)
				speedZ += 0.001;
			speedX = 0;
			break;
		case 4:
			if (speedX > 0) {
				this.posX += 0.1;
				this.posZ -= 0.1;
				this.speedX = 0.1;
				this.speedZ = -0.1;
			}else{
				this.posX -= 0.1;
				this.posZ += 0.1;
				this.speedX = -0.1;
				this.speedZ = +0.1;
			}

			break;
			
		case 5:
			if (speedZ < 0) {
				this.posX -= 0.1;
				this.posZ -= 0.1;
				this.speedX = -0.1;
				this.speedZ = -0.1;
			}else{
				this.posX += 0.1;
				this.posZ += 0.1;
				this.speedX = +0.1;
				this.speedZ = +0.1;
			}
			
		case 3:
			if (speedX < 0) {
				this.posX -= 0.1;
				this.posZ -= 0.1;
				this.speedX = -0.1;
				this.speedZ = -0.1;
			}else{
				this.posX += 0.1;
				this.posZ += 0.1;
				this.speedX = +0.1;
				this.speedZ = +0.1;
			}

			break;
		default:
		}
	}

	public boolean interact(EntityPlayer player) {
		if (getOccupied()) {
			setOccupied(false);
		} else {
			setOccupied(true);
			setRider(player);
		}
		return true;
	}

	@Override
	public String getEntityName() {
		return "EntityFloatingCart." + getName();
	}

	private String getName() {
		return dataWatcher.getWatchableObjectString(19);
	}

	private void setName(String name) {
		this.dataWatcher.updateObject(19, name);
	}

}
