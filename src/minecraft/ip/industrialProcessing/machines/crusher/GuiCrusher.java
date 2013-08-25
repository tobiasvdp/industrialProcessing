package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.GuiContainerPoweredMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCrusher extends GuiContainerPoweredMachine{

	public GuiCrusher(InventoryPlayer inventory, TileEntityCrusher entity) {
		super(inventory, entity, new ContainerCrusher(inventory, entity), "Ore Crusher","textures/gui/Crusher.png");
	}
	

}