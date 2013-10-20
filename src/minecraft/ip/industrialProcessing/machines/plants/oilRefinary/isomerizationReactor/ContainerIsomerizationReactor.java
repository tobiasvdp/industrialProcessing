package ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor;

import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerIsomerizationReactor  extends ContainerPoweredFluidWorkerMachine{
	
	public ContainerIsomerizationReactor(InventoryPlayer inventoryPlayer, TileEntityIsomerizationReactor tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);

		addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

}
