package ip.industrialProcessing.machines.filter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiContainerFilter extends GuiContainer {

	public GuiContainerFilter(InventoryPlayer inventoryPlayer, TileEntityFilter tileEntity) {
		super(new ContainerFilter(inventoryPlayer, tileEntity));
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// TODO Auto-generated method stub

	}

}
