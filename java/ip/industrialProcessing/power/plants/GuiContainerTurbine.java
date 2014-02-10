package ip.industrialProcessing.power.plants;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;

public class GuiContainerTurbine extends GuiContainerFluidMachine {

	private static final Point TANK_STEAM = new Point(8, 19);
	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	private static final Point TANK_WATER = new Point(152, 19);

	private static final Rectangle TACHOMETER_SOURCE = new Rectangle(195, 21, 6, 32);
	private static final Point TACHOMETER_LOCATION = new Point(85, 21);
	private ContainerTurbine container;

	public GuiContainerTurbine(InventoryPlayer inventoryPlayer, TileEntityTurbine tileEntity) {
		this(inventoryPlayer, tileEntity, new ContainerTurbine(inventoryPlayer, tileEntity));

	}

	public GuiContainerTurbine(InventoryPlayer inventoryPlayer, TileEntityFluidMachine tileEntity, ContainerTurbine containerTurbine) {
		super(inventoryPlayer, tileEntity, containerTurbine, "Turbine", "textures/gui/Turbine.png");
		this.container = containerTurbine;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarTank(TANK_SOURCE, TANK_WATER, 0);
		drawProgressBarTank(TANK_SOURCE, TANK_STEAM, 1);

		int temp = this.container.getRpm();
		drawProgressBar(TACHOMETER_SOURCE, TACHOMETER_LOCATION, temp, 215, false, false);

	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) { 
		super.drawGuiContainerForegroundLayer(param1, param2);
		int temp = this.container.getRpm();
		fontRenderer.drawStringWithShadow(temp+"RPM", 98, 56, 0xFFFFFF);
	}

}
