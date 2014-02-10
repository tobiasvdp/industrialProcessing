package ip.industrialProcessing.multiblock.container;

import ip.industrialProcessing.gui.container.syncing.handlers.HandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerPower;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;

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
