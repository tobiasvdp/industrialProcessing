package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.utils.working.IWorker;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public class ContainerWorkerMachine<T extends TileEntity & IMachineContainerEntity> extends ContainerMachine<T> {

	private T workerEntity;

	public ContainerWorkerMachine(InventoryPlayer inventoryPlayer,
			T tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.workerEntity = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> workerHandlers = new ArrayList<ProgressBarHandlerInfo>();	
	
	public void addWorkerToContainer(IWorker worker) {
		IProgressBarHandler handler = new ProgressBarWorkerHandler(worker);
		ProgressBarHandlerInfo info = addProgressBar(handler);
		this.workerHandlers.add(info); 
	}
	
	public ProgressInfoWorker getProgressInfoWorker(int index)
	{
		ProgressBarHandlerInfo info = this.workerHandlers.get(index);
		return ProgressBarWorkerHandler.getInfo(info);
	} 
}
