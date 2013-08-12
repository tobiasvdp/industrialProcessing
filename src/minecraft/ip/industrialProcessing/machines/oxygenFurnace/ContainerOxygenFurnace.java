package ip.industrialProcessing.machines.oxygenFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerOxygenFurnace extends ContainerFluidMachine {

	private SlotLiquid inputPigIronFummInput;
	private SlotLiquidOutput inputPigIronEmptyOutput;
	private SlotLiquid inputHotSteelEmptyInput;
	private SlotLiquidOutput inputHotSteelFullOutput;

	public ContainerOxygenFurnace(InventoryPlayer inventoryPlayer, TileEntityOxygenFurnace tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputPigIronFummInput = new SlotLiquid(tileEntity, 0, 8, 19);
		inputPigIronEmptyOutput = new SlotLiquidOutput(tileEntity, 1, 8, 53);

		inputHotSteelEmptyInput = new SlotLiquid(tileEntity, 2, 24, 19);
		inputHotSteelFullOutput = new SlotLiquidOutput(tileEntity, 3, 24, 53);

		addSlotToContainer(inputPigIronFummInput);
		addSlotToContainer(inputPigIronEmptyOutput);
		addSlotToContainer(inputHotSteelEmptyInput);
		addSlotToContainer(inputHotSteelFullOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

}
