package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.fluidCatalyticCracker;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerFluidCatalyticCracker extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerFluidCatalyticCracker(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}

}
