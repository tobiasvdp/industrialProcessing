package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.meroxTreater;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMeroxTreater extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerMeroxTreater(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}
}
