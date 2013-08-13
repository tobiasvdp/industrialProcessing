package ip.industrialProcessing.multiblock.machine.crusher;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;

public class GuiContainerMultiMachineCrusher extends GuiContainerMachine {

	public GuiContainerMultiMachineCrusher(InventoryPlayer inventoryPlayer,
			TileEntityMachine tileEntity, ContainerMachine container,
			String name, String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation);
		// TODO Auto-generated constructor stub
	}

	BlockLargeCrusher blockLargeCrusher;
	
	/*public GuiContainerMultiMachineCrusher(InventoryPlayer inventoryPlayer,
			TileEntityLargeCrusher tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerFilter(inventoryPlayer,
				tileEntity), "Ore Filter", "textures/gui/Filter.png");
		this.blockLargeCrusher = tileEntity;
	}*/

}
