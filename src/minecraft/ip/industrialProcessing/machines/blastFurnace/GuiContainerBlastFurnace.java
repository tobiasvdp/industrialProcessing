package ip.industrialProcessing.machines.blastFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerBlastFurnace extends GuiContainerFluidMachine {

	public GuiContainerBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityBlastFurnace tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerBlastFurnace(inventoryPlayer, tileEntity), "Blast furnace", "textures/gui/BlastFurnace.png");
		setProgressBarLocation(76, 34, 24, 17);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 8, 19);
		drawTank(1, 152, 19);
		drawTank(2, 58, 19);
	}
}
