package ip.industrialProcessing.machines.containers;

import java.util.ArrayList;

import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.utils.working.IWorker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
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
