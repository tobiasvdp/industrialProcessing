package ip.industrialProcessing.multiblock.utils.config;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.machine.weldingStation.ContainerMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

public class GuiContainerMultiblockConfig extends GuiContainerMultiblockCore {
	private int xbase;
	private int ybase;
	private int zbase;
	private int xsize;
	private int ysize;
	private int zsize;
	public GuiContainerMultiblockConfig(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMultiblockConfig(inventoryPlayer, tileEntity), "Welding station   Configuration", "textures/gui/MultiblockConfig.png");
		xSize = 198;
		ySize = 165;
		setProgressBarLocation(106, 31, 23, 19);
		setProgressBarOrigin(198, 0);
		
		ItemStack[][][] layout = tileEntity.getItemStackLayout();
		
		xbase = (3-layout.length)/2;
		ybase = (3-layout[0].length)/2;
		zbase = (3-layout[0][0].length)/2;
		xsize = layout.length;
		ysize = layout[0].length;
		zsize = layout[0][0].length;
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		int count = 0;
		for (int i = 0; i < xsize; i++) {
			for (int j = 0; j < ysize; j++) {
				for (int k = 0; k < zsize; k++) {
					drawTexturedModalRect((x+49+((i+xbase)*12)+((k+zbase)*12)), (y+128-((j+ybase)*52)-((k+zbase)*8)+((i+xbase)*8)),210,0,25, 17);
					count++;
				}
			}
		}
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
