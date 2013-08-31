package ip.industrialProcessing.multiblock.gui;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class CTmultiblock extends Container{

	public CTmultiblock() {
		// TODO Auto-generated constructor stub
	}

	public CTmultiblock(InventoryPlayer inventory, TEmultiblockCore entity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}

}
