package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerDelayedCoker extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerDelayedCoker(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core){
		super(inventory, core);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}

}
