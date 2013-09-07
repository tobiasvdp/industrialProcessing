package ip.industrialProcessing.machines.blastFurnace;

import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerBlastFurnace extends ContainerFluidMachine {

	private SlotBase inputSlotIronPellets;
	private SlotBase inputSlotCalcareousSinterDust;
	private SlotBase inputSlotCokes;
	private SlotLiquid inputHotSlagEmptyInput;
	private SlotLiquidOutput inputHotSlagFullOutput;
	private SlotLiquid inputPigIronEmptyInput;
	private SlotLiquidOutput inputPigIronFullOutput;

	public ContainerBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityBlastFurnace tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputSlotIronPellets = new SlotBase(tileEntity, 0, 29, 26);
		inputSlotCalcareousSinterDust = new SlotBase(tileEntity, 1, 8, 46);
		inputSlotCokes = new SlotBase(tileEntity, 2, 49, 46);

		inputHotSlagEmptyInput = new SlotLiquid(tileEntity, 3, 116, 19);
		inputHotSlagFullOutput = new SlotLiquidOutput(tileEntity, 4, 116, 53);

		inputPigIronEmptyInput = new SlotLiquid(tileEntity, 5, 134, 19);
		inputPigIronFullOutput = new SlotLiquidOutput(tileEntity, 6, 134, 53);

		addSlotToContainer(inputSlotIronPellets);
		addSlotToContainer(inputSlotCalcareousSinterDust);
		addSlotToContainer(inputSlotCokes);
		addSlotToContainer(inputHotSlagEmptyInput);
		addSlotToContainer(inputHotSlagFullOutput);
		addSlotToContainer(inputPigIronEmptyInput);
		addSlotToContainer(inputPigIronFullOutput);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);

	}

	@Override
	public int getSizeInventory() {
		return 7;
	}

}
