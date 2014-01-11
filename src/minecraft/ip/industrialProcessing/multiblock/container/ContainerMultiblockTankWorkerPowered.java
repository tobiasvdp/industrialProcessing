package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerPower;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressBarPowerHandler;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;

public class ContainerMultiblockTankWorkerPowered extends ContainerMultiblockTankWorker {

	private TileEntityMultiblockCoreTankWorkerPowered core;

	public ContainerMultiblockTankWorkerPowered(InventoryPlayer inventory,TileEntityMultiblockCoreTankWorkerPowered core) {
		super(inventory,core);
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
