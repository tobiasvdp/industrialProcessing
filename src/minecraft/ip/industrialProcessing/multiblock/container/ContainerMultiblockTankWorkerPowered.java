package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import ip.industrialProcessing.api.handlers.HandlerPower;
import ip.industrialProcessing.api.handlers.IHandlerPower;
import ip.industrialProcessing.api.handlers.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressBarPowerHandler;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;

public class ContainerMultiblockTankWorkerPowered extends ContainerMultiblockTankWorker {

	private TEmultiblockCoreTankWorkerPowered core;

	public ContainerMultiblockTankWorkerPowered(TEmultiblockCoreTankWorkerPowered core) {
		super(core);
		this.core = core;
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
