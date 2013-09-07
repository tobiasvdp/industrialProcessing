package ip.industrialProcessing.machines.mixer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerMixer extends GuiContainerFluidMachine {

	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);

	public GuiContainerMixer(InventoryPlayer inventoryPlayer, TileEntityMixer tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMixer(inventoryPlayer, tileEntity), "Mixer", "textures/gui/Mixer.png");
		// setProgressBarLocation(76,34,24,17);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		drawProgressBarTank(TANK_SOURCE, new Point(8, 19), 0);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 1);
	}
}
