package mod.industrialProcessing.client.rendering.tileEntity.animation.tanks;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.TankAnimationPacket;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class TileTankSyncHandler { 
	public static void sendTankData(TileEntity entity, TankHandler handler) {
			TankAnimationPacket packet = new TankAnimationPacket(entity, handler);
			PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(entity.getWorldObj().provider.dimensionId, entity.xCoord, entity.yCoord, entity.zCoord, 32));
	}
}
