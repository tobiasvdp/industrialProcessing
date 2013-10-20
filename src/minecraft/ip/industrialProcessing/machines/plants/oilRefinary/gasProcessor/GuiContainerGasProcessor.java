package ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor;

import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.ContainerSourWaterStripper;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerGasProcessor  extends GuiContainerPoweredFluidWorkerMachine{
	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 18);
	private static final Point PROGRESSBAR_LOCATION = new Point(76, 34);
	private static final Rectangle PROGRESSBAR_POWER_SOURCE = new Rectangle(200, 0, 52, 8);
	private static final Point PROGRESSBAR_POWER_LOCATION = new Point(117, 7);
	
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);

	public GuiContainerGasProcessor(InventoryPlayer inventoryPlayer, TileEntityGasProcessor tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerGasProcessor(inventoryPlayer, tileEntity), "Gas processor", "textures/gui/GasProcessor.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(28, 19), 1);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 2);
		drawProgressBarTank(TANK_SOURCE, new Point(132, 19), 3);
		drawProgressBarTank(TANK_SOURCE, new Point(112, 19), 4);

		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
		drawProgressBarPower(PROGRESSBAR_POWER_SOURCE, PROGRESSBAR_POWER_LOCATION, true, 0);
	}

}
