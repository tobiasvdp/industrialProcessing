package ip.industrialProcessing.machines.dryer;

import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerDryer extends ContainerPoweredFluidWorkerMachine {

	private TileEntityDryer tileEntityDryer;
	private SlotBase outputSlot;
	private SlotLiquid inputMixedFullInput;
	private SlotLiquidOutput inputMixedEmptyOutput;
	private SlotLiquid outputDirtyWaterEmptyInput;
	private SlotLiquidOutput outputDirtyWaterFullOutput;

	public ContainerDryer(InventoryPlayer inventoryPlayer, TileEntityDryer tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntityDryer = tileEntity;

		outputSlot = new SlotBase(tileEntity, 0, 116, 35);
		inputMixedFullInput = new SlotLiquid(tileEntity, 1, 8, 19);
		inputMixedEmptyOutput = new SlotLiquidOutput(tileEntity, 2, 8, 53);

		outputDirtyWaterEmptyInput = new SlotLiquid(tileEntity, 3, 152, 19);
		outputDirtyWaterFullOutput = new SlotLiquidOutput(tileEntity, 4, 152, 53);

		addSlotToContainer(outputSlot);
		addSlotToContainer(inputMixedFullInput);
		addSlotToContainer(inputMixedEmptyOutput);
		addSlotToContainer(outputDirtyWaterEmptyInput);
		addSlotToContainer(outputDirtyWaterFullOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);
		addTankToContainer(1);
        
        addWorkerToContainer(tileEntityDryer.getWorker());
        addPowerToContainer(tileEntityDryer.getMainPowerStorage());
	}

	@Override
	public int getSizeInventory() {
		return 5;
	}
}
