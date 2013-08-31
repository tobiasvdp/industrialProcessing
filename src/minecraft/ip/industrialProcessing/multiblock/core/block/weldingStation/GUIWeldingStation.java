package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;

public class GUIWeldingStation extends GUImultiblock{

	public GUIWeldingStation(InventoryPlayer inventory, TEmultiblockCore entity) {
		super(inventory, entity, new CTmultiblock(inventory, entity), "Welding Table", "textures/gui/WeldingTable.png");
	}

}
