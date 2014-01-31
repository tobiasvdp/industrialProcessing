package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.multiblock.core.block.decoration.garageDoor.TileEntityGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorFrame;
import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import org.apache.commons.lang3.text.WordUtils;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class EntityGarageDoor extends Entity implements IRotateableEntity {

	private double speedX = 0;
	private double speedY = 0;
	private double speedZ = 0;
	private int serverdelay = 0;
	private double maxY = -1;
	private boolean direction;
	private IRotateableEntity te;
	private double yDum;
	private ForgeDirection forward = ForgeDirection.NORTH;

	public EntityGarageDoor(World par1World) {
		super(par1World);
		this.setSize(1.0f, 1.0f);
	}

	public EntityGarageDoor(World world, double x, double y, double z, int yCoord, boolean direction, IRotateableEntity tileEntityGarageDoorFrame) {
		super(world);
		this.setForwardDirection(tileEntityGarageDoorFrame.getForwardDirection());
		this.te = tileEntityGarageDoorFrame;
		this.yDum = ((TileEntity)tileEntityGarageDoorFrame).yCoord;
		this.maxY = yCoord;
		this.direction = direction;
		this.noClip = true;
		
		this.setSize(1.0F, 1.0F);
		switch (getForwardDirection()) {
		case EAST:
		case WEST:
			this.boundingBox.minX = 0.0f;
	        this.boundingBox.maxX = 1.0f;
			this.boundingBox.minZ = 0.45f;
	        this.boundingBox.maxZ = 0.55f;
			break;
		case NORTH:
		case SOUTH:
			this.boundingBox.minX = 0.45f;
	        this.boundingBox.maxX = 0.55f;
			this.boundingBox.minZ = 0.0f;
	        this.boundingBox.maxZ = 1.0f;
			break;
		default:
			break;
		}
        
		this.boundingBox.minY = 0.0f;
        this.boundingBox.maxY = 1.0f;
        
		this.setPosition(x, y, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		entityCollisionReduction = 0.70f;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (serverdelay == 0 && maxY != -1) {
			if (direction) {
				if (this.posY >= (maxY)) {
					worldObj.removeEntity(this);
				}
				this.prevPosX = this.posX;
				this.prevPosY = this.posY;
				this.prevPosZ = this.posZ;
				this.motionY += 0.00099999910593033D;
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.9800000190734863D;
				this.motionY *= 0.9800000190734863D;
				this.motionZ *= 0.9800000190734863D;
			} else {
				if (this.posY <= maxY) {
					worldObj.removeEntity(this);
					int x = (int) Math.round(posX - 0.5);
					int y = (int) Math.round(posY);
					int z = (int) Math.round(posZ - 0.5);
					sendSpawnPacket(x,y,z,IndustrialProcessing.blockGarageDoorDoor.blockID,getForwardDirection(),te);
					if(worldObj.getBlockId(x, y, z) == IndustrialProcessing.blockGarageDoorDoor.blockID){
						TileEntityGarageDoorDoor te = (TileEntityGarageDoorDoor) worldObj.getBlockTileEntity(x, y, z);
						te.unhide();
					}else{
						worldObj.setBlock(x, y, z, IndustrialProcessing.blockGarageDoorDoor.blockID);
						TileEntityGarageDoorDoor te = (TileEntityGarageDoorDoor) worldObj.getBlockTileEntity(x, y, z);
						te.setForwardDirection(getForwardDirection());
						te.unhide();
					}
					((TileEntityGarageDoorDoor) worldObj.getBlockTileEntity(x, y, z)).setForwardDirection(getForwardDirection());
					if(te instanceof TileEntityGarageDoorFrame)
						((TileEntityGarageDoorFrame)te).addToDoors(new int[] { x, y, z });
					else{
						((TileEntityGarageDoor)te).addToDoors(new int[] { x, y, z });
					}
				}
				this.prevPosX = this.posX;
				this.prevPosY = Math.min(this.posY, yDum);
				this.prevPosZ = this.posZ;
				this.motionY -= 0.00099999910593033D;
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				this.posY = Math.min(this.posY, yDum);
				this.motionX *= 0.9800000190734863D;
				this.motionY *= 0.9800000190734863D;
				this.motionZ *= 0.9800000190734863D;
			}
		}
	}

	private void sendSpawnPacket(int x, int y, int z, int blockID, ForgeDirection forwardDirection, IRotateableEntity te) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
		        outputStream.writeInt(x);
		        outputStream.writeInt(y);
		        outputStream.writeInt(z);
		        outputStream.writeInt(blockID);
		        outputStream.writeInt(forwardDirection.ordinal());
		        outputStream.writeInt(((TileEntity)te).xCoord);
		        outputStream.writeInt(((TileEntity)te).yCoord);
		        outputStream.writeInt(((TileEntity)te).zCoord);
		} catch (Exception ex) {
		        ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.IP_ENTITY_SPAWNGARAGEDOORBLOCK;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		PacketDispatcher.sendPacketToServer(packet);
	}

	public boolean canBeCollidedWith() {
		return !this.isDead;
	}	

	@Override
	public void onCollideWithPlayer(EntityPlayer par1Entity) {

		if (par1Entity.riddenByEntity != this && par1Entity.ridingEntity != this) {
			double d0 = par1Entity.posX - this.posX;
			double d1 = par1Entity.posZ - this.posZ;
			double d2 = MathHelper.abs_max(d0, d1);

			if (d2 >= 0.009999999776482582D) {
				d2 = (double) MathHelper.sqrt_double(d2);
				d0 /= d2;
				d1 /= d2;
				double d3 = 1.0D / d2;

				if (d3 > 1.0D) {
					d3 = 1.0D;
				}

				d0 *= d3;
				d1 *= d3;
				d0 *= 0.05000000074505806D;
				d1 *= 0.05000000074505806D;
				d0 *= (double) (1.0F - this.entityCollisionReduction);
				d1 *= (double) (1.0F - this.entityCollisionReduction);
				par1Entity.addVelocity(d0, 0.0D, d1);
			}
		}
		super.onCollideWithPlayer(par1Entity);
	}

	private double getZ() {
		return dataWatcher.getWatchableObjectInt(22) / (double) 1000;
	}

	private double getY() {
		return dataWatcher.getWatchableObjectInt(21) / (double) 1000;
	}

	private double getX() {
		return dataWatcher.getWatchableObjectInt(20) / (double) 1000;
	}

	private void setZ(double val) {
		this.dataWatcher.updateObject(22, (int) (val * 1000));
	}

	private void setY(double val) {
		this.dataWatcher.updateObject(21, (int) (val * 1000));
	}

	private void setX(double val) {
		this.dataWatcher.updateObject(20, (int) (val * 1000));
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	public ForgeDirection getForwardDirection() {
		return this.forward;
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		this.forward = forward;
	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}
}
