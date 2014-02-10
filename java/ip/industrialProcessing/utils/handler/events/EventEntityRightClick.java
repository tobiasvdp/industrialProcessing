package ip.industrialProcessing.utils.handler.events;

import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;
import ip.industrialProcessing.utils.handler.packets.PacketHandler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventEntityRightClick {

	@ForgeSubscribe
	public void entityInteractEvent(EntityInteractEvent event){
		if(event.target instanceof EntityFloatingCart){
			((EntityFloatingCart)event.target).interact(event.entityPlayer);
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
			        outputStream.writeChars(event.target.getEntityName());
			} catch (Exception ex) {
			        ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = PacketHandler.IP_ENTITY_INTERACT;
			packet.data = bos.toByteArray();
			packet.length = bos.size();

			PacketDispatcher.sendPacketToServer(packet);
		}
	}
}
