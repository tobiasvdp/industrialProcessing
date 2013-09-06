package ip.industrialProcessing.machines.pelletExtruder;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerPelletExtruder extends GuiContainerMachine {

	public GuiContainerPelletExtruder(InventoryPlayer inventoryPlayer, TileEntityPelletExtruder tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerPelletExtruder(inventoryPlayer, tileEntity), "Pellet Extruder", "textures/gui/PelletExtruder.png");
		//setProgressBarLocation(76, 31, 24, 17);
	}

}
