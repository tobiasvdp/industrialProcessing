package ip.industrialProcessing.power.plants;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;

public class GuiContainerSolidBurner extends GuiContainerMachine {

	private static final Point BURNER_LOCATION = new Point(81, 17);
	private static final Rectangle BURNER_SOURCE = new Rectangle(176, 0, 14, 14);
	private ContainerSolidBurner container;

	public GuiContainerSolidBurner(InventoryPlayer inventoryPlayer, TileEntitySolidBurner tileEntity) {
		this(inventoryPlayer, tileEntity, new ContainerSolidBurner(inventoryPlayer, tileEntity));
	}

	private GuiContainerSolidBurner(InventoryPlayer inventoryPlayer, TileEntitySolidBurner tileEntity, ContainerSolidBurner container) {
		super(inventoryPlayer, tileEntity, container, "Solid Burner", "textures/gui/SolidBurner.png");
		this.container = container;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		int progress = this.container.getBurnProgress();
		int total = this.container.getBurnTotal();
		drawProgressBar(BURNER_SOURCE, BURNER_LOCATION, progress, total, false, false);
	}
}
