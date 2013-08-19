package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.tank.GuiContainerMultiblockCoreTank;
import ip.industrialProcessing.multiblock.machine.mixer.ContainerMultiblockMixer;

public class GuiContainerMultiblockWeldingStation extends GuiContainerMultiblockCoreTank{

	public GuiContainerMultiblockWeldingStation(InventoryPlayer inventoryPlayer, TileEntityMultiblockWeldingStation tileEntity, ContainerMultiblockCoreInv container, String name, String textureLocation) {
		super(inventoryPlayer, tileEntity, new ContainerMultiblockWeldingStation(inventoryPlayer, tileEntity), "Welding station","textures/gui/weldingStation.png");
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3); 
	}
}
