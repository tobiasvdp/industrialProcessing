package ip.industrialProcessing.machines.mixer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerMixer extends ContainerFluidMachine {

	private SlotBase inputSlot;
	private SlotLiquid inputWaterFullInput;
	private SlotLiquidOutput inputWaterEmptyOutput;
	private SlotLiquid inputMixedEmptyInput;
	private SlotLiquidOutput inputMixedFullOutput;

	public ContainerMixer(InventoryPlayer inventoryPlayer,
			TileEntityMixer tileEntity) {
		super(inventoryPlayer, tileEntity); 
		
		inputSlot = new SlotBase(tileEntity, 0, 44, 35);
		inputWaterFullInput = new SlotLiquid(tileEntity, 1, 8,19);
		inputWaterEmptyOutput = new SlotLiquidOutput(tileEntity, 2,8, 53);

		inputMixedEmptyInput = new SlotLiquid(tileEntity, 3, 152,19);
		inputMixedFullOutput = new SlotLiquidOutput(tileEntity, 4,152, 53);
		
		
		addSlotToContainer(inputSlot);
		addSlotToContainer(inputWaterFullInput);
		addSlotToContainer(inputWaterEmptyOutput);
		addSlotToContainer(inputMixedEmptyInput);
		addSlotToContainer(inputMixedFullOutput);
				
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 5;
	}
}
