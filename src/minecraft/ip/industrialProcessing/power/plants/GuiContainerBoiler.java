package ip.industrialProcessing.power.plants;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class GuiContainerBoiler extends GuiContainerFluidMachine {

	private static final Point TANK_WATER = new Point(8, 19);
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	private static final Point TANK_STEAM = new Point(152, 19);

	private static final Rectangle THERMOMETER_SOURCE = new Rectangle(195, 21, 6, 32);
	private static final Point THERMOMETER_LOCATION = new Point(85, 21);
	private ContainerBoiler container;

	public GuiContainerBoiler(InventoryPlayer inventoryPlayer, TileEntityBoiler tileEntity) {
		this(inventoryPlayer, tileEntity, new ContainerBoiler(inventoryPlayer, tileEntity));

	}

	public GuiContainerBoiler(InventoryPlayer inventoryPlayer, TileEntityFluidMachine tileEntity, ContainerBoiler containerBoiler) {
		super(inventoryPlayer, tileEntity, containerBoiler, "Boiler", "textures/gui/Boiler.png");
		this.container = containerBoiler;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarTank(TANK_SOURCE, TANK_WATER, 0);
		drawProgressBarTank(TANK_SOURCE, TANK_STEAM, 1);

		int temp = this.container.getTemperature();
		drawProgressBar(THERMOMETER_SOURCE, THERMOMETER_LOCATION, temp, 215, false, false);

	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) { 
		super.drawGuiContainerForegroundLayer(param1, param2);
		int temp = this.container.getTemperature();
		fontRenderer.drawStringWithShadow(temp+"°C", 98, 56, 0xFFFFFF);
	}

}
