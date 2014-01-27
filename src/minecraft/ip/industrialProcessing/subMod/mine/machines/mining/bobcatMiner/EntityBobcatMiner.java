package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner;

import ip.industrialProcessing.subMod.mine.PacketHandler;
import ip.industrialProcessing.utils.BlockBreaker;
import ip.industrialProcessing.utils.packets.PacketIP001EntityLocationAndRotation;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.PacketDispatcher;

public class EntityBobcatMiner extends Entity {

	boolean mountPlayer = false;
	boolean playerLeft = false;
	boolean canMine = true;
	int cooldowntime = 10;
	private Minecraft mc;

	public EntityBobcatMiner(World par1World) {
		super(par1World);
	}

	public EntityBobcatMiner(World par1World, float x, float y, float z) {
		super(par1World);
		this.setSize(2.5f, 2.375f);
		this.setPosition(x + 0.5, y + 1.0, z + 0.5);
		this.stepHeight = 1.0f;

		if (par1World.isRemote) {
			mc = Minecraft.getMinecraft();
			this.rotationYaw = mc.thePlayer.rotationYaw;
		}
	}

	@Override
	public double getMountedYOffset() {
		float height = this.height;
		return height - 1.5;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		double distance = par1EntityPlayer.getDistance(this.posX, this.posY, this.posZ);
		if (distance < 1.7) {
			if (!mountPlayer && !playerLeft) {
				mountPlayer = true;
				this.riddenByEntity = par1EntityPlayer;
				par1EntityPlayer.mountEntity(this);
			}
		}
		if (distance > 2.2) {
			playerLeft = false;
		}
		super.onCollideWithPlayer(par1EntityPlayer);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		doBlockCollisions();
		if (worldObj.isRemote && riddenByEntity != null) {
			if(mc == null){
				mc = Minecraft.getMinecraft();
			}
			if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindForward)) {
				this.rotationYaw = (this.riddenByEntity.rotationYaw + this.rotationYaw * 20) / 21;
				this.moveEntity((-Math.sin(rotationYaw % 360 * Math.PI / 180)) / 5, -0.5, (Math.cos(rotationYaw % 360 * Math.PI / 180)) / 5);
			}
			if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindAttack)) {
				mountPlayer = false;
				playerLeft = true;
				riddenByEntity.mountEntity(null);
				riddenByEntity = null;

			}
			if (canMine) {
				this.stepHeight = 0.5f;
				if (isCollidedHorizontally && cooldowntime == 0) {
					ArrayList<int[]> blocks = calculateBlocks();
					sendDestroyPacketToServer(blocks);
					BlockBreaker.breakBlocks(worldObj, blocks);
				}
			} else {
				this.stepHeight = 1.0f;
			}
			cooldowntime--;
			if(cooldowntime <0){
				cooldowntime = 10;
			}
			PacketDispatcher.sendPacketToServer(new PacketIP001EntityLocationAndRotation(this));
		}
	}
	
	@Override
	public boolean isEntityInvulnerable() {
		return true;
	}
	
	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}
	
	public void sendDestroyPacketToServer(ArrayList<int[]> blocks){
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			Iterator<int[]> it = blocks.iterator();
			outputStream.writeInt(blocks.size());
			while(it.hasNext()){
				int[] block = it.next();
				outputStream.writeInt(block[0]);
				outputStream.writeInt(block[1]);
				outputStream.writeInt(block[2]);
			}
			
		} catch (Exception ex) {
		        ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.destroyBlock;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToServer(packet);
	}

	private ArrayList<int[]> calculateBlocks() {
		ArrayList<int[]> blocks = new ArrayList<int[]>();
		int x = (int) this.posX;
		int y = (int) this.posY;
		int z = (int) this.posZ;
		int dir = MathHelper.floor_double((this.rotationYaw * 4F) / 360F + 0.5D) & 3;
		ForgeDirection forward = getForwardFromMetadata(dir).getOpposite();
		ForgeDirection left = forward.getRotation(ForgeDirection.UP);
		ForgeDirection right = forward.getRotation(ForgeDirection.DOWN);

		for (int i = 0; i < 3; i++) {
			// front
			blocks.add(new int[]{x + forward.offsetX, y + forward.offsetY + i, z + forward.offsetZ});
			blocks.add(new int[]{x + forward.offsetX + forward.offsetX, y + forward.offsetY + forward.offsetY + i, z + forward.offsetZ + forward.offsetZ});
			// left
			blocks.add(new int[]{x + forward.offsetX + left.offsetX, y + forward.offsetY + left.offsetY + i, z + forward.offsetZ + left.offsetZ});
			blocks.add(new int[]{x + forward.offsetX + forward.offsetX + left.offsetX, y + forward.offsetY + i + forward.offsetY + left.offsetY, z + forward.offsetZ + forward.offsetZ + left.offsetZ});

			// right
			blocks.add(new int[]{x + forward.offsetX + right.offsetX, y + forward.offsetY + right.offsetY + i, z + forward.offsetZ + right.offsetZ});
			blocks.add(new int[]{x + forward.offsetX + forward.offsetX + right.offsetX, y + forward.offsetY + i + forward.offsetY + right.offsetY, z + forward.offsetZ + forward.offsetZ + right.offsetZ});
		}
		return blocks;
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub

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

}
