package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerSolidBurner extends ContainerMachine {

	private TileEntitySolidBurner burner;
	private ProgressBarHandlerInfo burnerProgressInfo;

	public ContainerSolidBurner(InventoryPlayer inventoryPlayer, TileEntitySolidBurner tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.burner = tileEntity;

		this.burnerProgressInfo = addProgressBar(new IProgressBarHandler() {

			@Override
			public int getValueCount() {
				return 2;
			}

			@Override
			public int getValue(int i) {
				switch (i) {
				case 0:
					return burner.getRemainingBurnTime();
				case 1:
					return burner.getTotalBurnTime();
				}
				return 0;
			}
		});

		addSlotToContainer(new SlotBase(tileEntity, 0, 80, 33));
		addSlotToContainer(new SlotBase(tileEntity, 1, 90, 33));
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	public int getBurnProgress() {
		int[] values = this.burnerProgressInfo.getValueStorage();
		return values[0];
	}

	public int getBurnTotal() {
		int[] values = this.burnerProgressInfo.getValueStorage();
		return values[1];
	}
}
