package ip.industrialProcessing.machines.crusher;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.machines.GuiContainerPoweredMachine;
import ip.industrialProcessing.machines.GuiContainerWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCrusher extends GuiContainerWorkerMachine {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(70, 34);

	public GuiCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity),
				"Ore Crusher", "textures/gui/Crusher.png", PROGRESSBAR_SOURCE,
				PROGRESSBAR_LOCATION);
	}

}