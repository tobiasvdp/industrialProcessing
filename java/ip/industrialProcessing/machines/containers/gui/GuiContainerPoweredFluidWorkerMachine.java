package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerPoweredFluidWorkerMachine extends GuiContainerFluidWorkerMachine {

    private ContainerPoweredFluidWorkerMachine powerContainer;

    public GuiContainerPoweredFluidWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityFluidWorkerMachine tileEntity, ContainerPoweredFluidWorkerMachine container, String name, String textureLocation) {
	super(inventoryPlayer, tileEntity, container, name, textureLocation);
	this.powerContainer = container;
    }

    protected void drawProgressBarPower(Rectangle source, Point location, boolean horizontal, int containerPowerIndex) {
	ProgressInfoPower power = this.powerContainer.getProgressInfoPower(containerPowerIndex);
	drawProgressBar(source, location, power.storedPower, power.powerCapacity, horizontal, false);

	int x0 = (this.width - xSize) / 2;
	int y0 = (this.height - ySize) / 2;
	Rectangle target = new Rectangle(location.getX() + x0, location.getY() + y0, source.getWidth(), source.getHeight());
	ToolTip tip = PowerToolTip.getToolTip(power, target, this.mouseX, this.mouseX);
	if (tip != null)
	    this.toolTip = tip;
    }
}
