package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerTank extends GuiContainerFluidMachine<TileEntityTank> {
    private ContainerTank container;

    private static final Point TANK_WATER = new Point(8, 19);
    private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);

    public GuiContainerTank(InventoryPlayer inventoryPlayer, TileEntityTank tileEntity) {
	this(inventoryPlayer, tileEntity, new ContainerTank(inventoryPlayer, tileEntity));
    }

    private GuiContainerTank(InventoryPlayer inventoryPlayer, TileEntityTank tileEntity, ContainerTank container) {
	super(inventoryPlayer, tileEntity, container, "Tank", "textures/gui/Tank.png");
	this.container = container;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	super.drawGuiContainerBackgroundLayer(par1, par2, par3);
	drawProgressBarTank(TANK_SOURCE, TANK_WATER, 0);
    }
}
