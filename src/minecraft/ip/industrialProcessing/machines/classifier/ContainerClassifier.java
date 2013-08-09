package ip.industrialProcessing.machines.classifier;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerClassifier extends ContainerFluidMachine {

    private SlotBase inputSlot;
    private SlotLiquid inputWaterFullInput;
    private SlotLiquidOutput inputWaterEmptyOutput;
    private SlotLiquid inputMixedEmptyInput;
    private SlotLiquidOutput inputMixedFullOutput;
    private SlotOutput outputSlot;

    public ContainerClassifier(InventoryPlayer inventoryPlayer, TileEntityClassifier tileEntity) {
	super(inventoryPlayer, tileEntity);

	inputSlot = new SlotBase(tileEntity, 0, 82, 12);
	outputSlot = new SlotOutput(tileEntity, 1, 82, 54);
	inputWaterFullInput = new SlotLiquid(tileEntity, 2, 17, 16);
	inputWaterEmptyOutput = new SlotLiquidOutput(tileEntity, 3, 17, 51);

	inputMixedEmptyInput = new SlotLiquid(tileEntity, 4, 116, 16);
	inputMixedFullOutput = new SlotLiquidOutput(tileEntity, 5, 116, 51);

	addSlotToContainer(inputSlot);
	addSlotToContainer(outputSlot);
	addSlotToContainer(inputWaterFullInput);
	addSlotToContainer(inputWaterEmptyOutput);
	addSlotToContainer(inputMixedEmptyInput);
	addSlotToContainer(inputMixedFullOutput);

	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

}
