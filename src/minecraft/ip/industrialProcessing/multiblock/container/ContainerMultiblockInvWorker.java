package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.api.handlers.HandlerWorker;
import ip.industrialProcessing.api.handlers.IHandlerWorker;
import ip.industrialProcessing.api.info.InfoWorker;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.utils.working.IWorker;

public class ContainerMultiblockInvWorker extends ContainerMultiblockInv {

	public ContainerMultiblockInvWorker(InventoryPlayer inventory,TileEntityMultiblockCoreInv core) {
		super(inventory,core);
		// TODO Auto-generated constructor stub
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
