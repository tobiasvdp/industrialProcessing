package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner;

import ip.industrialProcessing.subMod.mine.PacketHandler;
import ip.industrialProcessing.utils.BlockBreaker;
import ip.industrialProcessing.utils.packets.PacketIP001EntityLocationAndRotation;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet32EntityLook;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.PacketDispatcher;

public class EntityBobcatMiner extends Entity {

	boolean canMine = true;
	int cooldowntime = 10;
	private Minecraft mc;

	public EntityBobcatMiner(World par1World) {
		super(par1World);
		this.setSize(2.5f, 2.375f);
	}

	public EntityBobcatMiner(World par1World, float x, float y, float z) {
		super(par1World);
		this.setSize(2.3f, 2.375f);
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
			if (riddenByEntity == null) {
				this.riddenByEntity = par1EntityPlayer;
				par1EntityPlayer.mountEntity(this);
			}
			if (distance > 2.2 && worldObj.isRemote && riddenByEntity != null && riddenByEntity == mc.thePlayer) {
				this.riddenByEntity = null;
			}
		}

		super.onCollideWithPlayer(par1EntityPlayer);
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
				System.out.println("x:"+posX+" y:"+posY+" z:"+posZ);
				if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindForward)) {
					float a = rotationYaw % 360 - this.riddenByEntity.rotationYaw % 360;
					a += (a > 180) ? -360 : (a < -180) ? 360 : 0;
					a = Math.min(Math.max(a, -20), 20);
						this.setRotation((this.rotationYaw - a / 10) % 360, this.rotationPitch);
					// this.riddenByEntity.rotationYaw =
					// this.riddenByEntity.rotationYaw + a/10;
					this.moveEntity(-(Math.sin(rotationYaw % 360 * Math.PI / 180)) / 7, 0, (Math.cos(rotationYaw % 360 * Math.PI / 180)) / 7);
				}
				if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindBack)) {
					float a = rotationYaw%360 - this.riddenByEntity.rotationYaw%360;
					a += (a > 180) ? -360 : (a < -180) ? 360 : 0;
					a = Math.min(Math.max(a, -20), 20);
						this.setRotation((this.rotationYaw -a / 10) % 360, this.rotationPitch);
					// this.riddenByEntity.rotationYaw =
					// this.riddenByEntity.rotationYaw + a/10;
					this.moveEntity((Math.sin(rotationYaw % 360 * Math.PI / 180)) / 15, 0, -(Math.cos(rotationYaw % 360 * Math.PI / 180)) / 15);
				}
				if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindLeft)) {
					this.setRotation((this.rotationYaw - 4) % 360, this.rotationPitch);
				}
				if (mc.gameSettings.isKeyDown(mc.gameSettings.keyBindRight)) {
					this.setRotation((this.rotationYaw + 4) % 360, this.rotationPitch);
				}
				if (canMine) {
					this.stepHeight = 0.5f;
					if (isCollidedHorizontally && cooldowntime == 0) {
						ArrayList<int[]> blocks = calculateBlocks(1, 1, 3, 0);
						sendDestroyPacketToServer(blocks);
						BlockBreaker.breakBlocks(worldObj, blocks);
					}
				} else {
					this.stepHeight = 1.0f;
				}
				cooldowntime--;
				if (cooldowntime < 0) {
					cooldowntime = 10;
				}
				this.moveEntity(0, -0.5, 0);
				PacketDispatcher.sendPacketToServer(new PacketIP001EntityLocationAndRotation(this).getCustom250Packet());
			}

		} else {

		}
	}

	@Override
	public boolean isEntityInvulnerable() {
		return true;
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

	public void sendDestroyPacketToServer(ArrayList<int[]> blocks) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			Iterator<int[]> it = blocks.iterator();
			outputStream.writeInt(blocks.size());
			while (it.hasNext()) {
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

	private ArrayList<int[]> calculateBlocks(int leftC, int rightc, int upC, int offsetY) {
		ArrayList<int[]> blocks = new ArrayList<int[]>();
		int dir = MathHelper.floor_double((this.rotationYaw * 4F) / 360F + 0.5D) & 3;
		ForgeDirection forward = getForwardFromMetadata(dir).getOpposite();
		ForgeDirection left = forward.getRotation(ForgeDirection.UP);
		ForgeDirection right = forward.getRotation(ForgeDirection.DOWN);

		int x = (int) ((this.posX)-0.5);
		int y = (int) (this.posY) + offsetY;
		int z = (int) ((this.posZ)-0.5);
		
		if(forward == ForgeDirection.NORTH || ForgeDirection.SOUTH == forward){
			x = (int) Math.round(((this.posX)-0.5));
		}
		
		if(forward == ForgeDirection.EAST || ForgeDirection.WEST == forward){
			z = (int) Math.round(((this.posZ)-0.5));
		}

		for (int i = 0; i < upC; i++) {
			// front
			blocks.add(new int[] { x + forward.offsetX, y + forward.offsetY + i, z + forward.offsetZ });
			blocks.add(new int[] { x + forward.offsetX + forward.offsetX, y + forward.offsetY + forward.offsetY + i, z + forward.offsetZ + forward.offsetZ });

			// left
			for (int j = 1; j <= leftC; j++) {
				blocks.add(new int[] { x + forward.offsetX + j * left.offsetX, y + forward.offsetY + j * left.offsetY + i, z + forward.offsetZ + j * left.offsetZ });
				blocks.add(new int[] { x + forward.offsetX + forward.offsetX + j * left.offsetX, y + forward.offsetY + i + forward.offsetY + j * left.offsetY, z + forward.offsetZ + forward.offsetZ + j * left.offsetZ });
			}
			// right
			for (int j = 1; j <= rightc; j++) {
				blocks.add(new int[] { x + forward.offsetX + j * right.offsetX, y + forward.offsetY + j * right.offsetY + i, z + forward.offsetZ + j * right.offsetZ });
				blocks.add(new int[] { x + forward.offsetX + forward.offsetX + j * right.offsetX, y + forward.offsetY + i + forward.offsetY + j * right.offsetY, z + forward.offsetZ + forward.offsetZ + j * right.offsetZ });
			}
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

	public void toggleMining(EntityClientPlayerMP thePlayer) {
		if (canMine) {
			canMine = false;
			thePlayer.sendChatToPlayer(new ChatMessageComponent().func_111059_a(EnumChatFormatting.YELLOW).func_111072_b("Mining disabled."));
		} else {
			canMine = true;
			thePlayer.sendChatToPlayer(new ChatMessageComponent().func_111059_a(EnumChatFormatting.YELLOW).func_111072_b("Mining enabled."));
		}
	}

}
