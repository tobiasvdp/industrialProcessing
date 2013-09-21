package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;

public class ContainerPoweredFluidWorkerMachine extends ContainerFluidWorkerMachine {

	private TileEntityPoweredFluidWorkerMachine tileEntityPoweredWorkerMachine;

	public ContainerPoweredFluidWorkerMachine(InventoryPlayer inventoryPlayer, TileEntityPoweredFluidWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntityPoweredWorkerMachine = tileEntity;
	}

	ArrayList<ProgressBarHandlerInfo> powerHandlers = new ArrayList<ProgressBarHandlerInfo>();

	protected void addPowerToContainer(IPowerStorage storage) {
		IProgressBarHandler handler = new ProgressBarPowerHandler(storage);
		ProgressBarHandlerInfo info = addProgressBar(handler);
		this.powerHandlers.add(info);
	}

	public ProgressInfoPower getProgressInfoPower(int index) {
		ProgressBarHandlerInfo info = powerHandlers.get(index);
		return ProgressBarPowerHandler.getInfo(info);
	}
}
