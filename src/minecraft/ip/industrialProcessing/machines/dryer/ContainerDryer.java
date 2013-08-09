package ip.industrialProcessing.machines.dryer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.slots.SlotBase;

public class ContainerDryer extends ContainerFluidMachine {

	private TileEntityDryer tileEntityDryer;

	public ContainerDryer(InventoryPlayer inventoryPlayer,
			TileEntityDryer tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntityDryer = tileEntity;
		
		addSlotToContainer(new SlotBase(tileEntity, 0, 54,82));
	}
}
