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

	

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 44, 12);
		drawTank(1, 143, 12);
	}
}
