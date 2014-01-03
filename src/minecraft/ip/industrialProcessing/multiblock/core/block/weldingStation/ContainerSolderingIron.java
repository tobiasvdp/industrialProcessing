package ip.industrialProcessing.multiblock.core.block.weldingStation;

import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerSolderingIron extends ContainerMultiblockTankWorkerPowered {
	private Slot[] slots;

	public ContainerSolderingIron(EntityPlayer player, TileEntityMultiblockCoreTankWorkerPowered core) {
		super(player.inventory, core);
		((TEmultiblockWeldingStation)core).openGui = 1;

		slots = new SlotBase[22];
		slots[0] = new SlotBase(core, 0, -18, -18);
		slots[1] = new SlotBase(core, 1, -18, -18);
		slots[2] = new SlotBase(core, 2, -18, -18);
		slots[3] = new SlotBase(core, 3, -18, -18);
		slots[4] = new SlotBase(core, 4, -18, -18);
		slots[5] = new SlotBase(core, 5, -18, -18);
		slots[6] = new SlotBase(core, 6, -18, -18);
		slots[7] = new SlotBase(core, 7, -18, -18);
		slots[8] = new SlotBase(core, 8, -18, -18);
		slots[9] = new SlotBase(core, 9, -18, -18);
		slots[10] = new SlotBase(core, 10, -18, -18);
		slots[11] = new SlotBase(core, 11, -18, -18);
		slots[12] = new SlotBase(core, 12, -18, -18);
		slots[13] = new SlotBase(core, 13, -18, -18);
		slots[14] = new SlotBase(core, 14, 26, 51);
		slots[15] = new SlotBase(core, 15, 80, 46);
		slots[16] = new SlotBase(core, 16, 62, 21);
		slots[17] = new SlotBase(core, 17, 80, 21);
		slots[18] = new SlotBase(core, 18, 98, 21);
		slots[19] = new SlotBase(core, 19, 176, 6);
		slots[20] = new SlotBase(core, 20, 176, 25);
		slots[21] = new SlotOutput(core, 21, 152, 33);

		BindSlots(slots, player.inventory, this);

		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
}