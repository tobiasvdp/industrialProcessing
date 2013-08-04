package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.GuiMachine;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiContainerFilter extends GuiMachine {

	public GuiContainerFilter(InventoryPlayer inventoryPlayer, TileEntityFilter tileEntity) {
		super(inventoryPlayer,tileEntity,new ContainerFilter(inventoryPlayer, tileEntity),"Ore Filter");	
	}
	@Override
	public void extendedDraw(){
		fontRenderer.drawString("test", 8, 20, 4210752);
	}
}
