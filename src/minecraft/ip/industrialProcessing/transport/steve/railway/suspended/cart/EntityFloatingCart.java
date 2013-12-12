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
	this.setX(d);
	this.setY(y);
	this.setZ(e);
	this.boundingBox.setBounds(d, y, e, d + 1, y + 1, e + 1);
	setName(name);
    }

    @Override
    protected void entityInit() {
	this.getDataWatcher().addObject(17, "");
	this.getDataWatcher().addObject(18, Integer.valueOf(0));
	this.getDataWatcher().addObject(19, "");
	this.getDataWatcher().addObject(20, Double.toString(this.posX));
	this.getDataWatcher().addObject(21, Double.toString(this.posY));
	this.getDataWatcher().addObject(22, Double.toString(this.posZ));
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
	    if (!worldObj.isRemote)
		moveForward();
	    this.posX = this.getX();
	    this.posY = this.getY();
	    this.posZ = this.getZ();
	    EntityPlayer player = getRider();
	    player.setPosition(this.getX(), this.getY(), this.getZ());
	    player.setVelocity(0, 0, 0);
	    this.boundingBox.setBounds(this.getX(), this.getY(), this.getZ(), this.getX() + 1, this.getY() + 1, this.getZ() + 1);
	} else {
	}
	super.onUpdate();
    }

    private double getZ() {
	return Double.parseDouble(dataWatcher.getWatchableObjectString(22));
    }

    private double getY() {
	return Double.parseDouble(dataWatcher.getWatchableObjectString(21));
    }

    private double getX() {
	return Double.parseDouble(dataWatcher.getWatchableObjectString(20));
    }

    private void setZ(double val) {
	this.dataWatcher.updateObject(22, Double.toString(val));
    }

    private void setY(double val) {
	this.dataWatcher.updateObject(21, Double.toString(val));
    }

    private void setX(double val) {
	this.dataWatcher.updateObject(20, Double.toString(val));
    }

    private void moveForward() {
	int meta = this.worldObj.getBlockMetadata((int) this.getX(), (int) this.getY() + 1, (int) this.getZ());
	switch (meta) {
	case 1:
	    this.setX(this.getX() + speedX);
	    this.setZ((int) this.getZ() + 0.5);
	    if (speedX > 0 && speedX < 0.1)
		speedX += 0.001;
	    if (speedX < 0 && speedX > -0.1)
		speedX -= 0.001;
	    if (speedX == 0)
		speedX += 0.001;
	    speedZ = 0;
	    break;
	case 2:
	    this.setZ(this.getZ() + speedZ);
	    this.setX((int) this.getX() + 0.5);
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
		this.setX(this.getX() + 0.1);
		this.setZ(this.getZ() - 0.1);
		this.speedX = 0.1;
		this.speedZ = -0.1;
	    } else {
		this.setX(this.getX() - 0.1);
		this.setZ(this.getZ() + 0.1);
		this.speedX = -0.1;
		this.speedZ = +0.1;
	    }

	    break;

	case 5:
	    if (speedZ < 0) {
		this.setX(this.getX() - 0.1);
		this.setZ(this.getZ() - 0.1);
		this.speedX = -0.1;
		this.speedZ = -0.1;
	    } else {
		this.setX(this.getX() + 0.1);
		this.setZ(this.getZ() + 0.1);
		this.speedX = +0.1;
		this.speedZ = +0.1;
	    }

	case 3:
	    if (speedX < 0) {
		this.setX(this.getX() - 0.1);
		this.setZ(this.getZ() - 0.1);
		this.speedX = -0.1;
		this.speedZ = -0.1;
	    } else {
		this.setX(this.getX() + 0.1);
		this.setZ(this.getZ() + 0.1);
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
