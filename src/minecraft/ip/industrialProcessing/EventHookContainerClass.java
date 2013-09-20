package ip.industrialProcessing;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class EventHookContainerClass {
	@ForgeSubscribe
	public void blockPlaced(PlayerInteractEvent event){
		if(event.action == Action.RIGHT_CLICK_BLOCK){
			System.out.println("block");
			System.out.println(event.entityPlayer.worldObj.getBlockTileEntity(event.x, event.y, event.z));
			System.out.println(event.face);
		}
		if(event.action == Action.RIGHT_CLICK_AIR){
			System.out.println("air");
			System.out.println(event.entityPlayer.worldObj.getBlockTileEntity(event.x, event.y, event.z));
		}
	}
}
