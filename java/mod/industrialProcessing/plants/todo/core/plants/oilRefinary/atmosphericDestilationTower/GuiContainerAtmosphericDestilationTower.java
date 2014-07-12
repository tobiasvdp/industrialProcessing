package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.atmosphericDestilationTower;

import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerAtmosphericDestilationTower extends GUImultiblock {
	
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(0, 167, 130, 58);
	private static final Point PROGRESSBAR_LOCATION = new Point(33, 9);
	
	private static final Rectangle TANK_SOURCE = new Rectangle(200, 17, 16, 50);
	private static final Rectangle TANK_SOURCE2 = new Rectangle(200, 17, 16, 24);
	
	public GuiContainerAtmosphericDestilationTower(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core, new ContainerAtmosphericDestilationTower(inventory, core), "Atmospheric destilator", "textures/gui/AtmosphericDestilator.png");
		nameX = xSize / 2 - 30;
		nameY = ySize - 96 + 2;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		
		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 6);
		drawProgressBarTank(TANK_SOURCE, new Point(133, 19), 5);
		drawProgressBarTank(TANK_SOURCE, new Point(114, 19), 4);
		drawProgressBarTank(TANK_SOURCE, new Point(95, 19), 3);
		drawProgressBarTank(TANK_SOURCE, new Point(76, 19), 2);
		drawProgressBarTank(TANK_SOURCE2, new Point(57, 19), 1);
		drawProgressBarTank(TANK_SOURCE2, new Point(57, 45), 7);
		
		
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}
}
