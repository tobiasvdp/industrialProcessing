package ip.industrialProcessing.transport.steve.railway.suspended.cart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFloatingCart extends Entity {


	public EntityPlayer getRider(){
		return (EntityPlayer) this.worldObj.getPlayerEntityByName(dataWatcher.getWatchableObjectString(17));
	}
	public void setRider(EntityPlayer player){
		this.dataWatcher.updateObject(17, player.username);
	}
	public boolean getOccupied(){
		return  dataWatcher.getWatchableObjectInt(18) == 1;
	}
	public void setOccupied(boolean val){
		if(val)
			this.dataWatcher.updateObject(18, 1);
		else
			this.dataWatcher.updateObject(18, 0);
	}
	public EntityFloatingCart(World par1World) {
		super(par1World);
		this.setSize(1.0f, 1.0f);
	}

	public EntityFloatingCart(World world, double d, double y, double e) {
		super(world);
		this.setSize(1.2f, 2.0f);
		this.posX = d;
		this.posY = y;
		this.posZ = e;
		this.boundingBox.setBounds(d, y, e, d + 1, y + 1, e + 1);
	}

	@Override
	protected void entityInit() {
		this.getDataWatcher().addObject(17, "");
		this.getDataWatcher().addObject(18, Integer.valueOf(0));
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
			EntityPlayer player = getRider();
			player.prevPosX = this.posX;
			player.prevPosY = this.posY;
			player.prevPosZ = this.posZ;
			player.posX = this.posX;
			player.posY = this.posY;
			player.posZ = this.posZ;
		}
		//System.out.println(worldObj.toString() + " " + getOccupied());
		super.onUpdate();
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

}
