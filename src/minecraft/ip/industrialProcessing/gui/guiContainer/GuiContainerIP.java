package ip.industrialProcessing.gui.guiContainer;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.IGuiLayoutMultiblock;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiContainerIP extends GuiContainer {
	private TileEntity tileEntity;
	private String name;
	public ResourceLocation textureLocation;
	public ResourceLocation textureLocationSpecific;
	private int mouseX;
	private int mouseY;
	public ToolTip toolTip;
	private GuiLayout layout;
	public int tabID = 0;

	public GuiContainerIP(EntityPlayer player, TileEntity tileEntity, Container container) {
		super(container);
		InventoryPlayer inventoryPlayer = player.inventory;
		this.tileEntity = tileEntity;
		this.name = tileEntity.getBlockType().getLocalizedName();
		this.textureLocationSpecific = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/" + this.name + ".png");
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/layout.png");

		this.xSize = 236;
		this.ySize = 200;

		if (tileEntity.getBlockType() instanceof IGuiLayout)
			layout = ((IGuiLayout) tileEntity.getBlockType()).getGuiLayout();

		if (tileEntity.getBlockType() instanceof IGuiLayoutMultiblock) {
			layout = ((IGuiLayoutMultiblock) tileEntity.getBlockType()).getGuiLayout(((TileEntityMultiblockCore) tileEntity).getTier());
		}
	}

	public void setTextureSpecific() {
		mc.renderEngine.func_110577_a(this.textureLocationSpecific);
	}

	public void setTextureLayout() {
		mc.renderEngine.func_110577_a(this.textureLocation);
	}

	public void setTextureBlocks() {
		mc.renderEngine.func_110577_a(TextureMap.field_110575_b);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.mouseX = par1;
		this.mouseY = par2;
		super.drawScreen(par1, par2, par3);
		if (toolTip != null) {
			int x = (width - xSize) / 2;
			int y = (height - ySize) / 2;
			ToolTip.renderToolTip(this.toolTip, mouseX + 16, mouseY, this.zLevel, fontRenderer);
			this.toolTip = null;
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		if (this.layout != null) {
			if (this.layout.drawTitel)
				fontRenderer.drawString(name, 8, 6, 4210752);
			if (this.layout.drawInventoryTitel)
				fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		mc.renderEngine.func_110577_a(this.textureLocation);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		if (this.layout != null) {
			layout.draw(this, this.inventorySlots, x, y, mouseX, mouseY);
		}

	}

	public void changeTab(int tabID) {

	}

}
