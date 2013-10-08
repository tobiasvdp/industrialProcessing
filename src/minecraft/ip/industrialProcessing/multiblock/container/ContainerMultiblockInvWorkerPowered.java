package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import ip.industrialProcessing.api.handlers.HandlerPower;
import ip.industrialProcessing.api.handlers.IHandlerPower;
import ip.industrialProcessing.api.handlers.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;

public class ContainerMultiblockInvWorkerPowered extends ContainerMultiblockInvWorker {

	public ContainerMultiblockInvWorkerPowered(TEmultiblockCoreInv core) {
		super(core);
		// TODO Auto-generated constructor stub
	}
	ArrayList<IHandlerPower> powerHandlers = new ArrayList<IHandlerPower>();

	protected void addPowerToContainer(IPowerStorage storage) {
		IHandlerPower handler = new HandlerPower(storage);
		this.addHandler(handler);
		this.powerHandlers.add(handler);
	}

	public InfoPower getProgressInfoPower(int index) {
		IHandlerPower handler = powerHandlers.get(index);
		return HandlerPower.getInfo(handler);
	}
}
