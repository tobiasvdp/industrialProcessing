package ip.industrialProcessing.machines.pelletExtruder;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerPelletExtruder extends ContainerMachine {

	private SlotBase inputSlot;
	private SlotBase outputSlot;

	public ContainerPelletExtruder(InventoryPlayer inventoryPlayer, TileEntityPelletExtruder tileEntity) {
		super(inventoryPlayer, tileEntity);

		inputSlot = new SlotBase(tileEntity, 0, 0, 16);
		outputSlot = new SlotBase(tileEntity, 1, 0, 32);

		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSlot);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return 2;
	}

}
