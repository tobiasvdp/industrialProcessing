package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerPelletExtruder extends GuiContainerMachine {

	public GuiContainerPelletExtruder(InventoryPlayer inventoryPlayer, TileEntityPelletExtruder tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerPelletExtruder(inventoryPlayer, tileEntity), "Pellet Extruder", "textures/gui/PelletExtruder.png");
		//setProgressBarLocation(76, 31, 24, 17);
	}

}
