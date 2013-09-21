package ip.industrialProcessing;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class EventHookContainerClass {
	@ForgeSubscribe
	public void blockPlaced(PlayerInteractEvent event){
		if(event.action == Action.RIGHT_CLICK_BLOCK){
			System.out.println("block");
			ForgeDirection dir = ForgeDirection.getOrientation(transformToForgeDirection(event.face));
			System.out.println(event.entityPlayer.worldObj.getBlockTileEntity(event.x+dir.offsetX, event.y+dir.offsetY, event.z+dir.offsetZ));
		}
		if(event.action == Action.RIGHT_CLICK_AIR){
			System.out.println("air");
			System.out.println(event.entityPlayer.worldObj.getBlockTileEntity(event.x, event.y, event.z));
		}
	}
	
	private int transformToForgeDirection(int blockMetadata) {
		switch (blockMetadata) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 4;
		}
		return 0;
	}
}
