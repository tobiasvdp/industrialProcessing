package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.CatalyticReformer;

import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerCatalyticReformer  extends GUImultiblock {
	
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(0, 167, 130, 58);
	private static final Point PROGRESSBAR_LOCATION = new Point(33, 9);
	private static final Rectangle TANK_SOURCE = new Rectangle(200, 17, 16, 50);
	
	public GuiContainerCatalyticReformer(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core, new ContainerCatalyticReformer(inventory, core), "Catalytic reformer", "textures/gui/CatalyticReformer.png");
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}

}
