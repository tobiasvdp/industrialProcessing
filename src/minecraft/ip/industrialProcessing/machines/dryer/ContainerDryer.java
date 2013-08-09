package ip.industrialProcessing.machines.dryer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerDryer extends ContainerFluidMachine {

	private TileEntityDryer tileEntityDryer;
	private SlotBase outputSlot;
	private SlotLiquid inputMixedFullInput;
	private SlotLiquidOutput inputMixedEmptyOutput;
	private SlotLiquid outputDirtyWaterEmptyInput;
	private SlotLiquidOutput outputDirtyWaterFullOutput;

	public ContainerDryer(InventoryPlayer inventoryPlayer,
			TileEntityDryer tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntityDryer = tileEntity;
		
		outputSlot = new SlotBase(tileEntity, 0, 82, 12);
		inputMixedFullInput = new SlotLiquid(tileEntity, 1, 17,16);
		inputMixedEmptyOutput = new SlotLiquidOutput(tileEntity, 2,17, 51);

		outputDirtyWaterEmptyInput = new SlotLiquid(tileEntity, 3, 116,16);
		outputDirtyWaterFullOutput = new SlotLiquidOutput(tileEntity, 4,116, 51);
		
		
		addSlotToContainer(outputSlot);
		addSlotToContainer(inputMixedFullInput);
		addSlotToContainer(inputMixedEmptyOutput);
		addSlotToContainer(outputDirtyWaterEmptyInput);
		addSlotToContainer(outputDirtyWaterFullOutput);
				
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}
}
