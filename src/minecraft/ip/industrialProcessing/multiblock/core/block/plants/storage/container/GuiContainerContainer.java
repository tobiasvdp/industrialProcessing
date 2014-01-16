package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerContainer extends GUImultiblock{
	
	private TileEntityContainer te;
	
	public GuiContainerContainer(InventoryPlayer inventory, TileEntityContainer entity) {
		super(inventory, entity, new ContainerContainer(inventory, entity), "Container", "textures/gui/Container.png");
		xSize = 256;
		ySize = 256;
		te = entity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
	}

}
