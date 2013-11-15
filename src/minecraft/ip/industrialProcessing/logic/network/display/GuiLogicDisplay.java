package ip.industrialProcessing.logic.network.display;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.logic.PacketHandler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiLogicDisplay extends GuiScreen {
    private static final int X_SIZE = 256;
    private static final int Y_SIZE = 202;
    private ResourceLocation textureLocation;
    private TileEntity entity;

    public GuiLogicDisplay(TileEntityLogicDisplay entity) {
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/Guide.png");
	this.entity = entity;
	requestNodes();
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
    
    public void requestNodes(){
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    		outputStream.writeInt(this.entity.xCoord);
    		outputStream.writeInt(this.entity.yCoord);
    		outputStream.writeInt(this.entity.zCoord);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}

    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel = PacketHandler.DISPLAY_GET_NODES;
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	
    	PacketDispatcher.sendPacketToServer(packet);
    } 
    @Override
    public boolean doesGuiPauseGame() {
    	return false;
    }
}
