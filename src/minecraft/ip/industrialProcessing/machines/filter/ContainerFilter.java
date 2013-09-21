package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerFilter extends ContainerPoweredWorkerMachine {

	protected TileEntityFilter tileEntity;
	protected Slot[] slots;

	public ContainerFilter(InventoryPlayer inventoryPlayer, TileEntityFilter tileEntity) {
		super(inventoryPlayer, tileEntity);

		this.tileEntity = tileEntity;

		slots = new Slot[3];
		slots[0] = new SlotBase(tileEntity, 0, 44, 33);
		slots[1] = new SlotOutput(tileEntity, 1, 104, 33);
		slots[2] = new SlotOutput(tileEntity, 2, 104, 56);

		addSlotToContainer(slots[0]);
		addSlotToContainer(slots[1]);
		addSlotToContainer(slots[2]);

		addWorkerToContainer(tileEntity.getWorker());
		addPowerToContainer(tileEntity.getMainPowerStorage());
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}
