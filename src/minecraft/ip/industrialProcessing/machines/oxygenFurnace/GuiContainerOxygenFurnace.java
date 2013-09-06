package ip.industrialProcessing.machines.oxygenFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerOxygenFurnace extends GuiContainerFluidMachine {

	public GuiContainerOxygenFurnace(InventoryPlayer inventoryPlayer, TileEntityOxygenFurnace tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerOxygenFurnace(inventoryPlayer, tileEntity), "Oxygen Furnace", "textures/gui/OxygenFurnace.png");
		//setProgressBarLocation(76, 35, 24, 17);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 35, 19);
		drawTank(1, 124, 19);
	}
}
