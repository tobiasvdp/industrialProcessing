package ip.industrialProcessing.machines.magneticSeparator;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMagneticSeparator extends ContainerMachine {

	private SlotOutput outputPurifiedMetal;
	private SlotOutput outputIronOxide;
	private SlotOutput outputNickelDust;
	private SlotOutput outputSphalerite;
	private SlotBase inputSlot;

	public ContainerMagneticSeparator(InventoryPlayer inventoryPlayer,
			TileEntityMachine tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputSlot = new SlotBase(tileEntity, 0, 44, 33);
		outputPurifiedMetal = new SlotOutput(tileEntity, 1, 104, 56);
		
		outputIronOxide = new SlotOutput(tileEntity, 2, 104, 33);
		outputNickelDust = new SlotOutput(tileEntity, 3, 122, 33);
		outputSphalerite = new SlotOutput(tileEntity, 4, 140, 33);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputPurifiedMetal);
		addSlotToContainer(outputIronOxide);
		addSlotToContainer(outputNickelDust);
		addSlotToContainer(outputSphalerite);
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

}
