package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery.ContainerBloomery;
import ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery.TileEntityBloomery;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

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
