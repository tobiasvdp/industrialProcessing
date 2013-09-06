package ip.industrialProcessing.machines.diskFilter;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerDiskFilter extends GuiContainerFluidMachine {


	public GuiContainerDiskFilter(InventoryPlayer inventoryPlayer,
			TileEntityDiskFilter tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerDiskFilter(inventoryPlayer, tileEntity), "Disk Filter", "textures/gui/DiskFilter.png");
		//setProgressBarLocation(76,34,24,17);
	}
 

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 8, 19);
		drawTank(1, 152, 19);
	}
}
