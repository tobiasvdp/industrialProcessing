package ip.industrialProcessing.machines.extruder;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerExtruder extends ContainerFluidMachine {

	private SlotLiquid inputHotSlagFummInput;
	private SlotLiquidOutput inputHotSlagEmptyOutput;
	private SlotBase outputSlot;

	public ContainerExtruder(InventoryPlayer inventoryPlayer, TileEntityExtruder tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputHotSlagFummInput = new SlotLiquid(tileEntity, 0, 8, 19);
		inputHotSlagEmptyOutput = new SlotLiquidOutput(tileEntity, 1, 8, 53);

		outputSlot = new SlotBase(tileEntity, 2, 0, 32);

		addSlotToContainer(inputHotSlagFummInput);
		addSlotToContainer(inputHotSlagEmptyOutput);
		addSlotToContainer(outputSlot);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 3;
	}

}
