package ip.industrialProcessing.machines.hydroCyclone;

import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerHydroCyclone extends ContainerFluidMachine {

	private SlotLiquid inputWaterFullInput;
	private SlotLiquidOutput inputWaterEmptyOutput;
	private SlotLiquid outputPasteEmptyInput;
	private SlotLiquidOutput outputPasteFullOutput;
	private SlotLiquid outputDirtyWaterEmptyInput;
	private SlotLiquidOutput outputDirtyWaterFullOutput;

	public ContainerHydroCyclone(InventoryPlayer inventoryPlayer, TileEntityHydroCyclone tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputWaterFullInput = new SlotLiquid(tileEntity, 0, 8, 19);
		inputWaterEmptyOutput = new SlotLiquidOutput(tileEntity, 1, 8, 53);

		outputPasteEmptyInput = new SlotLiquid(tileEntity, 2, 152, 19);
		outputPasteFullOutput = new SlotLiquidOutput(tileEntity, 3, 152, 53);

		outputDirtyWaterEmptyInput = new SlotLiquid(tileEntity, 4, 116, 19);
		outputDirtyWaterFullOutput = new SlotLiquidOutput(tileEntity, 5, 116, 53);

		addSlotToContainer(inputWaterFullInput);
		addSlotToContainer(inputWaterEmptyOutput);
		addSlotToContainer(outputPasteEmptyInput);
		addSlotToContainer(outputPasteFullOutput);
		addSlotToContainer(outputDirtyWaterEmptyInput);
		addSlotToContainer(outputDirtyWaterFullOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
	}

}
