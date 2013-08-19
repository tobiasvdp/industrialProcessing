package ip.industrialProcessing.multiblock.machine.blastFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.machine.crusher.ContainerMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.crusher.TileEntityMultiblockCrusher;

public class GuiContainerMultiblockBlastFurnace extends GuiContainerMultiblockCore{

	public GuiContainerMultiblockBlastFurnace(InventoryPlayer inventory, TileEntityMultiblockBlastFurnace entity) {
		super(inventory, entity, new ContainerMultiblockBlastFurnace(inventory, entity), "Blast Furnace","textures/gui/Crusher.png");
	}

}
