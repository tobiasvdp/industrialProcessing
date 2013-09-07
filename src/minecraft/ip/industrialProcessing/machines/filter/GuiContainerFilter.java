package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerFilter extends GuiContainerMachine {

	private TileEntityFilter filterTileEntity;

	public GuiContainerFilter(InventoryPlayer inventoryPlayer,
			TileEntityFilter tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerFilter(inventoryPlayer,
				tileEntity), "Ore Filter", "textures/gui/Filter.png");
		this.filterTileEntity = tileEntity;
	}
}
