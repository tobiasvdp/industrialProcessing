package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerHydroTreater  extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerHydroTreater(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core);

		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);
		
		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

}
