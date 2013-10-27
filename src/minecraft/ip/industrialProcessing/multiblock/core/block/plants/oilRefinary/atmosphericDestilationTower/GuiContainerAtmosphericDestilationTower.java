package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;

public class GuiContainerAtmosphericDestilationTower extends GUImultiblock {
	
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(198, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(106, 31);
	
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	
	public GuiContainerAtmosphericDestilationTower(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core){
		super(inventory, core, new ContainerAtmosphericDestilationTower(inventory, core), "Atmospheric destilator", "textures/gui/AtmosphericDestilator.png");
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		
		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 1);
		
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}
}
