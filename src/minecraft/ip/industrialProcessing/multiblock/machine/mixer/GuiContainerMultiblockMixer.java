package ip.industrialProcessing.multiblock.machine.mixer;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.tank.GuiContainerMultiblockCoreTank;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockCoreTank;

public class GuiContainerMultiblockMixer extends GuiContainerMultiblockCoreTank{

	public GuiContainerMultiblockMixer(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreTank tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMultiblockMixer(inventoryPlayer, tileEntity), "Mixer","textures/gui/mixer.png");
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3); 
		drawTank(0, 8, 19);
		drawTank(1, 152, 19);
	}
}
