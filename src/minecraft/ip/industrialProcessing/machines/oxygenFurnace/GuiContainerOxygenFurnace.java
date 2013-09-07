package ip.industrialProcessing.machines.oxygenFurnace;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerOxygenFurnace extends GuiContainerFluidMachine {

	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	public GuiContainerOxygenFurnace(InventoryPlayer inventoryPlayer, TileEntityOxygenFurnace tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerOxygenFurnace(inventoryPlayer, tileEntity), "Oxygen Furnace", "textures/gui/OxygenFurnace.png");
		// setProgressBarLocation(76, 35, 24, 17);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		drawProgressBarTank(TANK_SOURCE, new Point(35, 19),  0);
		drawProgressBarTank(TANK_SOURCE, new Point(124, 19),  1);
	}
}
