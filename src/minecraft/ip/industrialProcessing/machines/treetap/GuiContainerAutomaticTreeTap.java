package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerAutomaticTreeTap extends GuiContainerFluidMachine {

    private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
    private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
    private static final Point PROGRESSBAR_LOCATION = new Point(76, 31);
    private ContainerAutomaticTreeTap container;

    public GuiContainerAutomaticTreeTap(InventoryPlayer inventoryPlayer, TileEntityAutomaticTreeTap tileEntity) {
        this(inventoryPlayer, tileEntity, new ContainerAutomaticTreeTap(inventoryPlayer, tileEntity), "Automatic Treetap", "textures/gui/AutomaticTreeTap.png");
    }

    private GuiContainerAutomaticTreeTap(InventoryPlayer inventoryPlayer, TileEntityAutomaticTreeTap tileEntity, ContainerAutomaticTreeTap containerAutomaticTreeTap, String string, String string2) {
        super(inventoryPlayer, tileEntity, containerAutomaticTreeTap, string, string2);
        this.container = containerAutomaticTreeTap;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        super.drawGuiContainerBackgroundLayer(par1, par2, par3);

        int[] values = this.container.getProgressInfo().getValueStorage();

        drawProgressBar(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, values[0], values[1], true, false);

        drawProgressBarTank(TANK_SOURCE, new Point(152, 19), 0);
    }
}
