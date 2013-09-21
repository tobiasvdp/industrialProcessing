package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerFilter extends GuiContainerPoweredWorkerMachine {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(70, 34);
	private static final Rectangle PROGRESSBAR_POWER_SOURCE = new Rectangle(176, 17, 52, 8);
	private static final Point PROGRESSBAR_POWER_LOCATION = new Point(117, 7);

	private TileEntityFilter filterTileEntity;

	public GuiContainerFilter(InventoryPlayer inventoryPlayer, TileEntityFilter tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerFilter(inventoryPlayer, tileEntity), "Ore Filter", "textures/gui/Filter.png");
		this.filterTileEntity = tileEntity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
		drawProgressBarPower(PROGRESSBAR_POWER_SOURCE, PROGRESSBAR_POWER_LOCATION, true, 0);
	}
}
