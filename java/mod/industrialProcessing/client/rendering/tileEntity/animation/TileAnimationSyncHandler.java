package mod.industrialProcessing.client.rendering.tileEntity.animation;

import io.netty.buffer.Unpooled;
import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.SyncAnimationPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

public class TileAnimationSyncHandler {

	public static void sendAnimationData(TileEntity entity, AnimationHandler handler) {
		sendAnimationData(entity, handler, 0);
	}

	public static void sendAnimationData(TileEntity entity, AnimationHandler handler, int index) {
		if (handler.isChanged()) {
			SyncAnimationPacket packet = new SyncAnimationPacket(entity, index, handler.getProgress(), handler.getSpeed());
			PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(entity.getWorldObj().provider.dimensionId, entity.xCoord, entity.yCoord, entity.zCoord, 32));
		}
	}
}
