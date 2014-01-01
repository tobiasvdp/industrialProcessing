package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.utils.registry.BlockRegistry;

import java.awt.Point;
import java.awt.Rectangle;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class GuideMachinePage extends GuidePage {

    private Block[] machines = BlockRegistry.getMachinesArray();
    private Block hover;
    private Block selectedMachine;
    
    public GuideMachinePage() {
		super();
		
	}

    @Override
    public Point getIconLocation() {
	return null;
    }

    @Override
    public String getTitle() {
	return "Crafting";
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {
	this.hover = null;
	int marginX = 8 + x;
	int marginY = 24 + y;
	for (int i = 0; i < machines.length; i++) {
	    int dx = i / 9 * 18;
	    int dy = i % 9 * 18;
	    drawMachine(mouseX, mouseY, machines[i], marginX + dx, marginY + dy);
	}
    }

    private void drawMachine(int mouseX, int mouseY, Block block, int x, int y) {
	ItemStack stack = new ItemStack(block);
	GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	RenderHelper.enableGUIStandardItemLighting();
	GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);

	Rectangle rect = new Rectangle(x, y, 16, 16);
	if (rect.contains(mouseX, mouseY)) {
	    ToolTip tip = new ToolTip(stack.getDisplayName());
	    ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
	    this.hover = block;
	}
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glDisable(GL11.GL_LIGHTING);
	RenderHelper.disableStandardItemLighting();
    }

    @Override
    public ItemStack getIconStack() {
	return new ItemStack(Block.workbench);
    }
    
    @Override
    public void mouseClicked(int d, int e, int par3) { 
        super.mouseClicked(d, e, par3);
        
        if(this.hover != null){
        this.selectedMachine = this.hover;
        }
    }

}
