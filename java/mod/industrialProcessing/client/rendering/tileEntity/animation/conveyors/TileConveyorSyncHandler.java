package mod.industrialProcessing.client.rendering.tileEntity.animation.conveyors;

import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.ConveyorPacket;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class TileConveyorSyncHandler {

	public static void sendConveyorData(TileEntity entity, IConveyor handler) {
		ConveyorPacket packet = new ConveyorPacket(entity, handler);
		PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(entity.getWorldObj().provider.dimensionId, entity.xCoord, entity.yCoord, entity.zCoord, 32));
	}

}
