package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.electrolyser.ContainerElectrolyser;
import ip.industrialProcessing.machines.electrolyser.TileEntityElectrolyser;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerSourWaterStripper extends GuiContainerPoweredFluidWorkerMachine{
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 18);
	private static final Point PROGRESSBAR_LOCATION = new Point(76, 34);
	private static final Rectangle PROGRESSBAR_POWER_SOURCE = new Rectangle(200, 0, 52, 8);
	private static final Point PROGRESSBAR_POWER_LOCATION = new Point(117, 7);
	
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);

	public GuiContainerSourWaterStripper(InventoryPlayer inventoryPlayer, TileEntitySourWaterStripper tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerSourWaterStripper(inventoryPlayer, tileEntity), "Sour water Stripper", "textures/gui/SourWaterStripper.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(28, 19), 1);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 2);
		drawProgressBarTank(TANK_SOURCE, new Point(132, 19), 3);

		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
		drawProgressBarPower(PROGRESSBAR_POWER_SOURCE, PROGRESSBAR_POWER_LOCATION, true, 0);
	}
}
