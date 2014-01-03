package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.ContainerAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerMultiblockBlastFurnace extends GUImultiblock {
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(76, 34);
	
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	
	public GuiContainerMultiblockBlastFurnace(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core, new ContainerMultiblockBlastFurnace(inventory, core), "Blast furnace", "textures/gui/BlastFurnace.png");
		xSize = 176;
		ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		
		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(116, 19), 1);
		drawProgressBarTank(TANK_SOURCE, new Point(134, 19), 2);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 3);
		
		
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}
}
