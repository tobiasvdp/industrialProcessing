package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.utils.working.IWorker;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;

public class ContainerPoweredWorkerMachine extends ContainerWorkerMachine {

	private TileEntityPoweredWorkerMachine tileEntityPoweredWorkerMachine;


	public ContainerPoweredWorkerMachine(InventoryPlayer inventoryPlayer,
			TileEntityPoweredWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityPoweredWorkerMachine = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> powerHandlers = new ArrayList<ProgressBarHandlerInfo>();	
	
	protected void addPower(IPowerStorage storage) {
		IProgressBarHandler handler = new ProgressBarPowerHandler(storage);
		ProgressBarHandlerInfo info = addProgressBar(handler);
		this.powerHandlers.add(info); 
	}
	 
	public ProgressInfoPower getProgressInfoPower(int index)
	{
		ProgressBarHandlerInfo info = powerHandlers.get(index);
		return ProgressBarPowerHandler.getInfo(info);
	}
}
