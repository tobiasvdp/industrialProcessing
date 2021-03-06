package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredFluidWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerCoolingUnit extends GuiContainerPoweredFluidWorkerMachine {
	 
		private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 18);
		private static final Point PROGRESSBAR_LOCATION = new Point(76, 34);
		private static final Rectangle PROGRESSBAR_POWER_SOURCE = new Rectangle(200, 0, 52, 8);
		private static final Point PROGRESSBAR_POWER_LOCATION = new Point(117, 7);
		
		private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
		public GuiContainerCoolingUnit(InventoryPlayer inventoryPlayer, TileEntityPoweredFluidWorkerMachine tileEntity) {
			super(inventoryPlayer, tileEntity, new ContainerCoolingUnit(inventoryPlayer, tileEntity), "Cooling unit", "textures/gui/CoolingUnit.png"); 
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			super.drawGuiContainerBackgroundLayer(par1, par2, par3); 

			drawProgressBarTank(TANK_SOURCE, new Point(8, 19),  0);
			drawProgressBarTank(TANK_SOURCE, new Point(35, 19),  1);
			drawProgressBarTank(TANK_SOURCE, new Point(134, 19),  2);

			drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
			drawProgressBarPower(PROGRESSBAR_POWER_SOURCE, PROGRESSBAR_POWER_LOCATION, true, 0);
		}

}
