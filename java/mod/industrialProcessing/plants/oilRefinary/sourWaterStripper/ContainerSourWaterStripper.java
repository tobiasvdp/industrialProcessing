package ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper;

import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerSourWaterStripper extends ContainerPoweredFluidWorkerMachine{
	
	private SlotLiquid inputWaterFullInput;
	private SlotLiquidOutput inputWaterEmptyOutput;
	private SlotLiquid inputMixedEmptyInput;
	private SlotLiquidOutput inputMixedFullOutput;
	
	public ContainerSourWaterStripper(InventoryPlayer inventoryPlayer, TileEntitySourWaterStripper tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		inputWaterFullInput = new SlotLiquid(tileEntity, 0, 8, 19);
		inputWaterEmptyOutput = new SlotLiquidOutput(tileEntity, 1, 8, 53);

		inputMixedEmptyInput = new SlotLiquid(tileEntity, 2, 152, 19);
		inputMixedFullOutput = new SlotLiquidOutput(tileEntity, 3, 152, 53);
		
		addSlotToContainer(inputWaterFullInput);
		addSlotToContainer(inputWaterEmptyOutput);
		addSlotToContainer(inputMixedEmptyInput);
		addSlotToContainer(inputMixedFullOutput);
		
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
		return 4;
	}
}
