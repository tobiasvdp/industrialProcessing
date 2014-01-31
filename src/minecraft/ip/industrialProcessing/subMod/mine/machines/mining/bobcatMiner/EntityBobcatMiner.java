package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner;

import ip.industrialProcessing.subMod.mine.PacketHandler;
import ip.industrialProcessing.subMod.mine.machines.EntityVehicle;
import ip.industrialProcessing.subMod.mine.machines.mining.EntityMiner;
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

public class EntityBobcatMiner extends EntityMiner {

	public EntityBobcatMiner(World par1World) {
		super(par1World);
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
	public int mineLeft() {
		return 1;
	}

	@Override
	public int mineRight() {
		return 1;
	}

	@Override
	public int mineUp() {
		return 3;
	}

	@Override
	public int mineYOffset() {
		return 0;
	}

	@Override
	public int getMaxCooldownTime() {
		return 15;
	}

	@Override
	public String getActivity() {
		return "Mining";
	}

	@Override
	public float[] getSize() {
		return new float[]{2.5f, 2.375f};
	}

	@Override
	public float getStepHeightRiding() {
		return 1;
	}

	@Override
	public float getStepHeightAction() {
		return 0.5f;
	}

	
	
}
