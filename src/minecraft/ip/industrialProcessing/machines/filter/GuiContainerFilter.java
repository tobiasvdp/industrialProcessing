package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.GuiMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerFilter extends GuiMachine {

	public GuiContainerFilter(InventoryPlayer inventoryPlayer, TileEntityFilter tileEntity) {
		super(inventoryPlayer,tileEntity,new ContainerFilter(inventoryPlayer, tileEntity),"Ore Filter","none");	
	}
	@Override
	public void extendedDrawString(){
		fontRenderer.drawString("test", 8, 20, 4210752);
	}
}
