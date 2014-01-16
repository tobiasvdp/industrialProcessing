package ip.industrialProcessing.machines.treetap;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.machines.containers.gui.GuiContainerWorkerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerManualTreeTap extends GuiContainerWorkerMachine {

    private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(176, 0, 22, 16);
    private static final Point PROGRESSBAR_LOCATION = new Point(76, 31);

    public GuiContainerManualTreeTap(InventoryPlayer inventoryPlayer, TileEntityManualTreeTap tileEntity) {
        super(inventoryPlayer, tileEntity, new ContainerManualTreeTap(inventoryPlayer, tileEntity), "Manual Treetap", "textures/gui/ManualTreeTap.png");
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        super.drawGuiContainerBackgroundLayer(par1, par2, par3);
        drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
    }
}
