package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.utils.working.IWorker;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;

public class ContainerFluidWorkerMachine extends ContainerFluidMachine {

	private TileEntityFluidWorkerMachine workerEntity;

	public ContainerFluidWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityFluidWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.workerEntity = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> workerHandlers = new ArrayList<ProgressBarHandlerInfo>();

	protected void addWorkerToContainer(IWorker worker) {
		IProgressBarHandler handler = new ProgressBarWorkerHandler(worker);
		ProgressBarHandlerInfo info = addProgressBar(handler);
		this.workerHandlers.add(info);
	}

	public ProgressInfoWorker getProgressInfoWorker(int index) {
		ProgressBarHandlerInfo info = this.workerHandlers.get(index);
		return ProgressBarWorkerHandler.getInfo(info);
	}
}
