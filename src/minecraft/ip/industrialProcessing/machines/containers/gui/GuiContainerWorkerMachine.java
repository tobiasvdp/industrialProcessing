package ip.industrialProcessing.machines.containers.gui;

import org.lwjgl.util.Rectangle;
import org.lwjgl.util.Point;

import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerWorkerMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.common.ForgeDirection;

public class GuiContainerWorkerMachine extends GuiContainerMachine {

	private TileEntityWorkerMachine workerEntity;
	private ContainerWorkerMachine workerContainer;

	public GuiContainerWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityWorkerMachine tileEntity, ContainerWorkerMachine container, String name, String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation);
		this.workerEntity = tileEntity;
		this.workerContainer = container;
	}

	protected void drawProgressBarWorker(Rectangle source, Point location, boolean horizontal, int containerWorkerIndex) {
		ProgressInfoWorker worker = this.workerContainer.getProgressInfoWorker(containerWorkerIndex);
		drawProgressBar(source, location, worker.workDone, worker.totalWork, horizontal, false);
	}

}
