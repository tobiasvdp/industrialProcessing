package ip.industrialProcessing.machines.plants.blacksmith.grindingStone;

import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerWorkerMachine;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerGrindingStone extends GuiContainerWorkerMachine {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(70, 34);

	public GuiContainerGrindingStone(InventoryPlayer inventory, TileEntityGrindingStone entity) {
		super(inventory, entity, new ContainerGrindingStone(inventory, entity), "Grinding stone", "textures/gui/GindingStone.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}

}
