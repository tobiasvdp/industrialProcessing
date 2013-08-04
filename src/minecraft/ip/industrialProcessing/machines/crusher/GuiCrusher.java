package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.GuiMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCrusher extends GuiMachine{

	public GuiCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity), "Ore Crusher");
	}

}
