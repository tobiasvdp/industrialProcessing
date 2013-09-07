package ip.industrialProcessing.multiblock.gui;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUImultiblock extends GuiContainer {

	private TEmultiblockCore tileEntity;
	private ResourceLocation textureLocation;
	private String name;

	public GUImultiblock(InventoryPlayer inventoryPlayer, TEmultiblockCore tileEntity, CTmultiblock cTmultiblock, String name, String textureLocation) {
		super(cTmultiblock);
		this.tileEntity = tileEntity;
		this.name = name;
		this.textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, textureLocation);
		xSize = 198;
		ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString(name, 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		mc.renderEngine.func_110577_a(this.textureLocation);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
