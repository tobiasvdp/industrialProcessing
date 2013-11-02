package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerVacuumDestilationTower extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerVacuumDestilationTower(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core){
		super(inventory, core);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}
}
