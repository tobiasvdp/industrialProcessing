package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater;

import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.ContainerAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerAmineTreater extends GUImultiblock {
	
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(0, 167, 130, 58);
	private static final Point PROGRESSBAR_LOCATION = new Point(33, 9);
	private static final Rectangle TANK_SOURCE = new Rectangle(200, 17, 16, 50);
	
	public GuiContainerAmineTreater(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core, new ContainerAmineTreater(inventory, core), "Amine treater", "textures/gui/AmineTreater.png");
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
