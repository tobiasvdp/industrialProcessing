package ip.industrialProcessing.items.guide.gui.machines;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.items.guide.gui.GuiGuide;
import ip.industrialProcessing.items.guide.gui.GuidePanoramaPage;
import ip.industrialProcessing.items.guide.gui.machines.components.GuideMachinePageMode;
import ip.industrialProcessing.items.guide.gui.machines.old.GuideMachineDetailsFrame;
import ip.industrialProcessing.utils.IDescriptionBlock;
import ip.industrialProcessing.utils.registry.BlockRegistry;
import ip.industrialProcessing.utils.registry.BlockType;

public class GuideMachinePage extends GuidePanoramaPage {

	private BlockType[][] type = new BlockType[][] { { BlockType.Ore_Processing, BlockType.Smelting }, { BlockType.Power, BlockType.Storage } };
	private BlockType activeType;
	private BlockType hoverType;
	private GuideMachinePageMode mode;
	private Block hoverBlock;
	private Block activeBlock;
	
	//private FontRenderer smallFont = new FontRenderer(mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), mc.renderEngine, false);

	public GuideMachinePage() {
		super(new Rectangle(0, 0, 110, 178), new Point(5, 18));
		this.allowHorizontalDrag = false;
		this.allowVerticalDrag = true;
		this.mode = GuideMachinePageMode.procces;
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/GuideDropShadowOverlayHalf.png");
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, int x, int y) {
		super.drawScreen(mouseX, mouseY, x, y);
	    
		if (this.hoverBlock != null) {
			ToolTip tip = new ToolTip(this.hoverBlock.getLocalizedName());
			ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
		}
		if (this.activeBlock != null) {
			RenderHelper.disableStandardItemLighting();
			GL11.glPushMatrix();
			GL11.glTranslatef(x+120, y+24, 0);
			//header
			drawMachine(mouseX, mouseY, activeBlock, 0, 0, true, true);
			fontRenderer.drawString(activeBlock.getLocalizedName(),25,5, 4210752);
			
			//description
			if(activeBlock instanceof IDescriptionBlock )
				fontRenderer.drawSplitString(((IDescriptionBlock)activeBlock).getDescription(),0,20,136, 4210752);
			
			//
			GL11.glPopMatrix();
			RenderHelper.enableStandardItemLighting();
		}
	}

	@Override
	protected void drawPane(int mouseX, int mouseY, boolean mouseInside) {
		int marginX = 8;
		int marginY = 8;
		int x = 0 + 4;
		int y = 0 + 8;
		this.hoverBlock = null;
		this.hoverType = null;

		// draw tabs and machines

		for (int i = 0; i < type[mode.ordinal()].length; i++) {
			RenderHelper.disableStandardItemLighting();
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0, 1);
			drawRect(x, y, x + 90, y + 16, FILL_COLOR);
			GL11.glTranslatef(1, 1, -1);
			drawRect(x, y, x + 90, y + 16, SHADOW_COLOR);
			GL11.glPopMatrix();

			fontRenderer.drawString(LanguageRegistry.instance().getStringLocalization("IP.BlockType." + type[mode.ordinal()][i].toString(), "en_US"), x + 5, y + 5, 16777215);

			if (x < mouseX && y < mouseY && x + 90 > mouseX && y + 16 > mouseY) {
				hoverType = type[mode.ordinal()][i];
			}

			y = y + 16 + marginY;

			if (activeType == type[mode.ordinal()][i]) {
				y = y + marginY + drawMachines(activeType, x, y, mouseX, mouseY);
			}
		}
	}

	private int drawMachines(BlockType type, int x, int y, int mouseX, int mouseY) {
		Iterator<Block> blocks = BlockRegistry.getBlocksByTag(type);
		int dx = 0;
		int dy = 0;
		int marginX = 5;
		int marginY = 5;
		while (blocks.hasNext()) {
			Block block = blocks.next();
			drawMachine(mouseX, mouseY, block, x + dx, y + dy, true, true);
			if (dx < 58) {
				dx = dx + 16 + marginX;
			} else {
				dx = 0;
				dy = dy + 16 + marginY;
			}
		}
		dy = dy + 16 + marginY;
		return dy;
	}

	private void drawMachine(int mouseX, int mouseY, Block block, int x, int y, boolean allowHover, boolean drawBackground) {
		ItemStack stack = new ItemStack(block);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		if (drawBackground) {
			RenderHelper.disableStandardItemLighting();
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0, 1);
			drawRect(x, y, x + 16, y + 16, FILL_COLOR);
			GL11.glTranslatef(1, 1, -1);
			drawRect(x, y, x + 16, y + 16, SHADOW_COLOR);
			GL11.glPopMatrix();
		}
		RenderHelper.enableGUIStandardItemLighting();
		GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);

		Rectangle rect = new Rectangle(x, y, 16, 16);
		if (rect.contains(mouseX, mouseY) && allowHover) {
			this.hoverBlock = block;
		}
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	public Point getIconLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		return "Industrial machines";
	}

	@Override
	public ItemStack getIconStack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(int d, int e, int par3) {
		super.mouseClicked(d, e, par3);

		if (this.hoverType != null) {
			this.activeType = hoverType;
		}
		
		if (this.hoverBlock != null) {
			this.activeBlock = hoverBlock;
		}
	}

}
