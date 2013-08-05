package ip.industrialProcessing.machines;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public class GuiContainerFluidMachine extends GuiContainerMachine {

	public GuiContainerFluidMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidMachine tileEntity, ContainerFluidMachine container, String name,
			String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation);
	}

}
