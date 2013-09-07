package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerPelletExtruder extends ContainerMachine {

	private SlotBase inputSlot;
	private SlotBase outputSlot;

	public ContainerPelletExtruder(InventoryPlayer inventoryPlayer, TileEntityPelletExtruder tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputSlot = new SlotBase(tileEntity, 0, 50, 31);
		outputSlot = new SlotBase(tileEntity, 1, 110, 31);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSlot);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 2;
	}

}
