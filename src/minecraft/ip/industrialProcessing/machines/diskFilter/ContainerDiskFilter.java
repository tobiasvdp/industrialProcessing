package ip.industrialProcessing.machines.diskFilter;

import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerDiskFilter extends ContainerFluidMachine {

	private TileEntityDiskFilter tileEntityDryer;
	private SlotBase outputSlot;
	private SlotLiquid inputMixedFullInput;
	private SlotLiquidOutput inputMixedEmptyOutput;
	private SlotLiquid outputDirtyWaterEmptyInput;
	private SlotLiquidOutput outputDirtyWaterFullOutput;
	private SlotLiquid inputMixedBFullInput;
	private SlotLiquidOutput inputMixedBEmptyOutput;

	public ContainerDiskFilter(InventoryPlayer inventoryPlayer, TileEntityDiskFilter tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntityDryer = tileEntity;

		outputSlot = new SlotBase(tileEntity, 0, 116, 35);
		inputMixedFullInput = new SlotLiquid(tileEntity, 1, 8, 19);
		inputMixedEmptyOutput = new SlotLiquidOutput(tileEntity, 2, 8, 53);

		inputMixedBFullInput = new SlotLiquid(tileEntity, 3, 8, 19);
		inputMixedBEmptyOutput = new SlotLiquidOutput(tileEntity, 4, 8, 53);

		outputDirtyWaterEmptyInput = new SlotLiquid(tileEntity, 5, 152, 19);
		outputDirtyWaterFullOutput = new SlotLiquidOutput(tileEntity, 6, 152, 53);

		addSlotToContainer(outputSlot);
		addSlotToContainer(inputMixedFullInput);
		addSlotToContainer(inputMixedEmptyOutput);
		addSlotToContainer(inputMixedBFullInput);
		addSlotToContainer(inputMixedBEmptyOutput);
		addSlotToContainer(outputDirtyWaterEmptyInput);
		addSlotToContainer(outputDirtyWaterFullOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 5;
	}
}
