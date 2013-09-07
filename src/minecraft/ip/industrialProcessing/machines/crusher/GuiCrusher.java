package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.containers.gui.GuiContainerWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiCrusher extends GuiContainerWorkerMachine {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(70, 34);

	public GuiCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity),
				"Ore Crusher", "textures/gui/Crusher.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) { 
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}
}