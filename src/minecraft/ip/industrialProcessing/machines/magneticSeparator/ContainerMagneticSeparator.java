package ip.industrialProcessing.machines.magneticSeparator;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerMagneticSeparator extends ContainerMachine {

	private SlotOutput outputPurifiedMetal;
	private SlotOutput outputIronOxide;
	private SlotOutput outputNickelDust;
	private SlotOutput outputSphalerite;
	private SlotBase inputSlot;

	public ContainerMagneticSeparator(InventoryPlayer inventoryPlayer,
			TileEntityMachine tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputSlot = new SlotBase(tileEntity, 0, 16, 16);
		outputPurifiedMetal = new SlotOutput(tileEntity, 1, 16, 48);
		
		outputIronOxide = new SlotOutput(tileEntity, 2, 48, 16);
		outputNickelDust = new SlotOutput(tileEntity, 3, 64, 16);
		outputSphalerite = new SlotOutput(tileEntity, 3, 96, 16);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputPurifiedMetal);
		addSlotToContainer(outputIronOxide);
		addSlotToContainer(outputNickelDust);
		addSlotToContainer(outputSphalerite);
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

}
