package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCrusher extends GuiContainerMachine{

	public GuiCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity), "Ore Crusher","textures/gui/Seperator.png");
	}

}