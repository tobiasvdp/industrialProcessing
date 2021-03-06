package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerWorker;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerWorker;
import ip.industrialProcessing.gui.container.syncing.info.InfoWorker;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.utils.working.IWorker;

public class ContainerMultiblockTankWorker extends ContainerMultiblockTank {

	private TileEntityMultiblockCoreTankWorker core;

	public ContainerMultiblockTankWorker(InventoryPlayer inventory,TileEntityMultiblockCoreTankWorker core) {
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
