package ip.industrialProcessing.machines.flotationCell;

import ip.industrialProcessing.machines.containers.ContainerFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerFlotationCell extends ContainerFluidWorkerMachine {

    private SlotLiquid inputWaterFullInput;
    private SlotLiquidOutput inputWaterEmptyOutput;
    private SlotLiquid outputPasteEmptyInput;
    private SlotLiquidOutput outputPasteFullOutput;
    private SlotLiquid outputDirtyWaterEmptyInput;
    private SlotLiquidOutput outputDirtyWaterFullOutput;

    public ContainerFlotationCell(InventoryPlayer inventoryPlayer, TileEntityFlotationCell tileEntity) {
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

	addWorkerToContainer(tileEntity.getWorker());
    }

}
