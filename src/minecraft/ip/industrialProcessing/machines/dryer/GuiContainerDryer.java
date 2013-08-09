package ip.industrialProcessing.machines.dryer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerDryer extends GuiContainerFluidMachine {


	public GuiContainerDryer(InventoryPlayer inventoryPlayer,
			TileEntityDryer tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerDryer(inventoryPlayer, tileEntity), "Dryer", "textures/gui/Dryer.png"); 
	}
 

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 44, 12);
		drawTank(1, 143, 12);
	}
}
