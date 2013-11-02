package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerAmineTreater  extends ContainerMultiblockTankWorkerPowered{

	
	public ContainerAmineTreater(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered core){
		super(inventory, core);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}

}
