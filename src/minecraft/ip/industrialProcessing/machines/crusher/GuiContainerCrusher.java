package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.machines.containers.gui.GuiContainerPoweredWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerCrusher extends GuiContainerPoweredWorkerMachine {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(70, 34);
	private static final Rectangle PROGRESSBAR_POWER_SOURCE = new Rectangle(176, 17, 52, 8);
	private static final Point PROGRESSBAR_POWER_LOCATION = new Point(117, 7);
	private GuiLayout layout;

	public GuiContainerCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity), "Ore Crusher", "textures/gui/Crusher2.png");
		this.xSize = 236;
		this.ySize = 200;
		
		if (entity.getBlockType() instanceof IGuiLayout)
			layout = ((IGuiLayout) entity.getBlockType()).getGuiLayout();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		
	    int x0 = (this.width - xSize) / 2;
	    int y0 = (this.height - ySize) / 2;
		
		if (this.layout != null) {
			layout.draw(this,this.inventorySlots,x0,y0,mouseX,mouseY);
		}
	}
}