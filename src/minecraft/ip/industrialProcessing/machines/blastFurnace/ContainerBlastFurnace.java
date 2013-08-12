package ip.industrialProcessing.machines.blastFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

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
		
		

		inputSlotIronPellets = new SlotBase(tileEntity, 0, 0, 16);
		inputSlotCalcareousSinterDust = new SlotBase(tileEntity, 1, 0, 32);
		inputSlotCokes = new SlotBase(tileEntity, 2, 0, 48);

		inputHotSlagEmptyInput = new SlotLiquid(tileEntity, 3, 8, 19);
		inputHotSlagFullOutput = new SlotLiquidOutput(tileEntity, 4, 8, 53);

		inputPigIronEmptyInput = new SlotLiquid(tileEntity, 5, 8, 19);
		inputPigIronFullOutput = new SlotLiquidOutput(tileEntity, 6, 8, 53);

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
