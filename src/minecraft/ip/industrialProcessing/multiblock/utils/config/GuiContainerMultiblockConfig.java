package ip.industrialProcessing.multiblock.utils.config;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.machine.weldingStation.ContainerMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.TileEntityMultiblockWeldingStation;

public class GuiContainerMultiblockConfig extends GuiContainerMultiblockCore {
	public GuiContainerMultiblockConfig(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMultiblockConfig(inventoryPlayer, tileEntity), "Welding station   Configuration", "textures/gui/MultiblockConfig.png");
		xSize = 198;
		ySize = 165;
		setProgressBarLocation(106, 31, 23, 19);
		setProgressBarOrigin(198, 0);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		mc.renderEngine.func_110577_a(this.textureLocation);
		drawTexturedModalRect(175, 116,198, 116, 18, 18);
		drawTexturedModalRect(175, 141,198, 141, 18, 18);
		
		fontRenderer.drawString(name, 8, 6, 4210752);
	}
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		// make buttons
		// id, x, y, width, height, text
		buttonList.add(new GuiButton(0, 175 + x, 141 + y, 18, 18, ""));
		GuiButton button = new GuiButton(1, 175 + x, 115 + y, 18, 18, "");
		button.enabled=false;
		buttonList.add(button);

	}
}
