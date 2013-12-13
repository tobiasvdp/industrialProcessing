package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.api.handlers.HandlerPower;
import ip.industrialProcessing.api.handlers.IHandlerPower;
import ip.industrialProcessing.api.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;

public class ContainerMultiblockInvWorkerPowered extends ContainerMultiblockInvWorker {

	public ContainerMultiblockInvWorkerPowered(InventoryPlayer inventory,TEmultiblockCoreInv core) {
		super(inventory,core);
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