package ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter;

import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerSmelter extends ContainerPoweredFluidWorkerMachine {

	private TileEntityPoweredFluidWorkerMachine tileEntity;
	private SlotBase inputSlot;

	public ContainerSmelter(InventoryPlayer inventoryPlayer, TileEntityPoweredFluidWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntity = tileEntity;

		inputSlot = new SlotBase(tileEntity, 0, 44, 35);
		
		addSlotToContainer(inputSlot);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);
        
        addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

}
