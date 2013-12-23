package ip.industrialProcessing.multiblock.core.block.weldingStation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.container.ContainerMultiblock;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;

public class GuiContainerWeldingStation extends GUImultiblock{

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(198, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(120, 31);
	
	private static final Rectangle THERMO_SOURCE = new Rectangle(204, 22, 5, 35);
	private static final Point THERMO_LOCATION = new Point(13, 15);
	
	private static final Rectangle BURN_SOURCE = new Rectangle(198, 86, 14, 14);
	private static final Point BURN_LOCATION = new Point(27, 35);
	
	private TEmultiblockWeldingStation te;
	
	public GuiContainerWeldingStation(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered entity) {
		super(inventory, entity, new ContainerWeldingStation(inventory, entity), "Welding Table", "textures/gui/WeldingTable.png");
		te = (TEmultiblockWeldingStation) entity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
		
	    int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
		
		int burnScale = te.getScaledBurnTime(BURN_SOURCE.getHeight());
		this.drawTexturedModalRect(BURN_LOCATION.getX()+x, BURN_LOCATION.getY() + y + BURN_SOURCE.getHeight() - burnScale, BURN_SOURCE.getX(), BURN_SOURCE.getY()+(14-burnScale), BURN_SOURCE.getWidth(), burnScale);
		
		int tempScale = te.getScaledHeat(THERMO_SOURCE.getHeight());
		this.drawTexturedModalRect(THERMO_LOCATION.getX()+x, THERMO_LOCATION.getY() + y + THERMO_SOURCE.getHeight()-tempScale, THERMO_SOURCE.getX(), THERMO_SOURCE.getY() + THERMO_SOURCE.getHeight() - tempScale, THERMO_SOURCE.getWidth(), tempScale);
		
	}
}
