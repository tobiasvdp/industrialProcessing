package ip.industrialProcessing.machines.insulator;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerInsulator extends ContainerPoweredFluidWorkerMachine {
	
	private SlotBase inputSlot ;
	private SlotOutput outputSlot ;
	private SlotLiquid bucketInput ;
	private SlotLiquidOutput bucketOutput;
	
	public ContainerInsulator(InventoryPlayer inventoryPlayer, TileEntityInsulator tileEntity){
		super(inventoryPlayer, tileEntity);
		
		inputSlot = new SlotBase(tileEntity, 0, 44, 35);
		bucketInput = new SlotLiquid(tileEntity, 2, 8, 19);
		bucketOutput = new SlotLiquidOutput(tileEntity, 3, 8, 53);
		outputSlot = new SlotOutput(tileEntity, 1, 116, 35);
		
		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSlot);
		addSlotToContainer(bucketInput);
		addSlotToContainer(bucketOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);

		addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}
	@Override
	public int getSizeInventory() {
		return 4;
	}
}
