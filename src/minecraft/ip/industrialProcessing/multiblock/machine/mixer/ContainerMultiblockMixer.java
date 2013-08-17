package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;

public class ContainerMultiblockMixer extends ContainerMultiblockCoreInv{

	public ContainerMultiblockMixer(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		BindPlayerInventory(inventoryPlayer, this, 0);
	}


}
