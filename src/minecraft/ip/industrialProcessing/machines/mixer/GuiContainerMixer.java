package ip.industrialProcessing.machines.mixer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.TileEntityFluidMachine;

public class GuiContainerMixer extends GuiContainerFluidMachine {

	public GuiContainerMixer(InventoryPlayer inventoryPlayer,
			TileEntityMixer tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMixer(inventoryPlayer, tileEntity), "Mixer", "textures/gui/Mixer.png"); 
	}

}
