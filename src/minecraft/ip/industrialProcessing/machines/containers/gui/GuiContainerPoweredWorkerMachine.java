package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerPoweredWorkerMachine extends GuiContainerWorkerMachine {  

	private ContainerPoweredWorkerMachine powerContainer;

	public GuiContainerPoweredWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityWorkerMachine tileEntity, ContainerPoweredWorkerMachine container, String name, String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation); 
		this.powerContainer = container;
	}

	protected void drawProgressBarPower(Rectangle source, Point location, boolean horizontal, int containerPowerIndex) {
		ProgressInfoPower power = this.powerContainer.getProgressInfoPower(containerPowerIndex);
		drawProgressBar(source, location, power.storedPower, power.powerCapacity, horizontal);
	}
}
