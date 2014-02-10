package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerFluidWorkerMachine extends GuiContainerFluidMachine {

	private TileEntityFluidWorkerMachine workerEntity;
	private ContainerFluidWorkerMachine workerContainer;

	public GuiContainerFluidWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityFluidWorkerMachine tileEntity, ContainerFluidWorkerMachine container, String name, String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation);
		this.workerEntity = tileEntity;
		this.workerContainer = container;
	}

	protected void drawProgressBarWorker(Rectangle source, Point location, boolean horizontal, int containerWorkerIndex) {
		ProgressInfoWorker worker = this.workerContainer.getProgressInfoWorker(containerWorkerIndex);
		drawProgressBar(source, location, worker.workDone, worker.totalWork, horizontal, false);
	}

}
