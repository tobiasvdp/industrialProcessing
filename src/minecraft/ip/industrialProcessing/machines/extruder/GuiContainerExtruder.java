package ip.industrialProcessing.machines.extruder;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerExtruder extends GuiContainerFluidMachine {

	public GuiContainerExtruder(InventoryPlayer inventoryPlayer, TileEntityExtruder tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerExtruder(inventoryPlayer, tileEntity), "Extruder", "textures/gui/Extruder.png");
		//setProgressBarLocation(76, 34, 24, 17);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 8, 19);
	}
}
