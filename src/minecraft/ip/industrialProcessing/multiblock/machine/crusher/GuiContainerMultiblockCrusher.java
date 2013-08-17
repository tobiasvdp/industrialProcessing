package ip.industrialProcessing.multiblock.machine.crusher;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.crusher.ContainerCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;

public class GuiContainerMultiblockCrusher extends GuiContainerMultiblockCore {
	public GuiContainerMultiblockCrusher(InventoryPlayer inventory, TileEntityMultiblockCrusher entity) {
		super(inventory, entity, new ContainerMultiblockCrusher(inventory, entity), "Ore Crusher","textures/gui/Crusher.png");
	}
}
