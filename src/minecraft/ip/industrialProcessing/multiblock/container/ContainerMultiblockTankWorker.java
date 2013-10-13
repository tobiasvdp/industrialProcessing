package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.api.handlers.HandlerWorker;
import ip.industrialProcessing.api.handlers.IHandlerWorker;
import ip.industrialProcessing.api.handlers.InfoWorker;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressBarWorkerHandler;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTank;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.utils.working.IWorker;

public class ContainerMultiblockTankWorker extends ContainerMultiblockTank {

	private TEmultiblockCoreTankWorker core;

	public ContainerMultiblockTankWorker(InventoryPlayer inventory,TEmultiblockCoreTankWorker core) {
		super(inventory,core);
		this.core = core;
	}
	ArrayList<IHandlerWorker> workerHandlers = new ArrayList<IHandlerWorker>();

	protected void addWorkerToContainer(IWorker worker) {
		IHandlerWorker handler = new HandlerWorker(worker);
		this.addHandler(handler);
		this.workerHandlers.add(handler);
	}

	public InfoWorker getProgressInfoWorker(int index) {
		IHandlerWorker handler = this.workerHandlers.get(index);
		return HandlerWorker.getInfo(handler);
	}
}
