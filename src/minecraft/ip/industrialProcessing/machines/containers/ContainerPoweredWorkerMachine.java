package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.IPowerStorage;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public class ContainerPoweredWorkerMachine<T extends TileEntity & IMachineContainerEntity> extends ContainerWorkerMachine<T> {

	private T tileEntityPoweredWorkerMachine;


	public ContainerPoweredWorkerMachine(InventoryPlayer inventoryPlayer,
			T tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityPoweredWorkerMachine = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> powerHandlers = new ArrayList<ProgressBarHandlerInfo>();	
	
	public void addPowerToContainer(IPowerStorage storage) {
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
