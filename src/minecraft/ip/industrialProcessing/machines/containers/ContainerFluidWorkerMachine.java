package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.utils.working.IWorker;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidTankInfo;

public class ContainerFluidWorkerMachine extends ContainerFluidMachine {

	private TileEntityFluidWorkerMachine tileEntityFluidWorkerMachine;


	public ContainerFluidWorkerMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityFluidWorkerMachine = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> workerHandlers = new ArrayList<ProgressBarHandlerInfo>();	
	
	protected void addWorkerToContainer(IWorker worker) {
		IProgressBarHandler handler = new ProgressBarWorkerHandler(worker);
		ProgressBarHandlerInfo info = addProgressBar(handler);
		this.workerHandlers.add(info); 
	}
	
	public int getWorkerProgress(int worker, int scale)
	{
		ProgressBarHandlerInfo info = this.workerHandlers.get(worker);
		int[] storage = info.getValueStorage();
		return storage[0] * scale / storage[1];
	}
}
