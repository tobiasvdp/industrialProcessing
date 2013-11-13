package ip.industrialProcessing.logic.network.display;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

public class GuiLogicDisplay extends GuiScreen {
    private static final int X_SIZE = 256;
    private static final int Y_SIZE = 202;
    private ResourceLocation textureLocation;

    public GuiLogicDisplay(TileEntityLogicDisplay entity) {
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/Guide.png");
	UTlogicNodeContainer container = entity.getConnectionsOnSide(ForgeDirection.NORTH);
	System.out.println("Printout");
	for(ICommunicationNode node:container.iterate()){
	}
    }

    @Override
    public void drawDefaultBackground() {
	drawBackground(0);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3) {
	drawDefaultBackground();
	super.drawScreen(mouseX, mouseY, par3);
	mc.renderEngine.func_110577_a(this.textureLocation);
	RenderHelper.disableStandardItemLighting();
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	GL11.glPushMatrix();
	GL11.glTranslatef(0, 0, 64f);
	GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	int x = (width - X_SIZE) / 2;
	int y = (height - Y_SIZE - 23) / 2;
	this.drawTexturedModalRect(x, y, 0, 0, X_SIZE, Y_SIZE);
	GL11.glPopMatrix();
	RenderHelper.disableStandardItemLighting();
    }

    @Override
    public void drawBackground(int par1) {
	drawWorldBackground(par1);
    }
}
