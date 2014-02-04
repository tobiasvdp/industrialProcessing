package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.IFluidMachineContainerEntity;
import ip.industrialProcessing.machines.containers.IMachineContainerEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerMachine<T extends TileEntity & IMachineContainerEntity & IFluidMachineContainerEntity> extends GuiContainer {

    public TileEntity tileEntity;
    protected String name;
    protected ResourceLocation textureLocation;
    protected int mouseX;
    protected int mouseY;
    protected ToolTip toolTip;

    public GuiContainerMachine(InventoryPlayer inventoryPlayer, T tileEntity, ContainerMachine<T> container, String name, String textureLocation) {
	super(container);
	this.tileEntity = tileEntity;
	this.name = name;
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, textureLocation);
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
	fontRenderer.drawString(name, 8, 6, 4210752);
	fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	mc.renderEngine.bindTexture(this.textureLocation);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	int x = (width - xSize) / 2;
	int y = (height - ySize) / 2;
	this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

    }

    protected void drawProgressBar(Rectangle source, Point target, int value, int max, boolean horizontal, boolean invert) {
	if (horizontal)
	    drawHorizontalProgressBar(target.getX(), target.getY(), source.getX(), source.getY(), source.getWidth(), source.getHeight(), value, max, invert);
	else
	    drawVerticalProgressBar(target.getX(), target.getY(), source.getX(), source.getY(), source.getWidth(), source.getHeight(), value, max, invert);
    }

    protected void drawHorizontalProgressBar(int x, int y, int sourceX, int sourceY, int width, int height, int value, int max, boolean invert) {

	if (width > 0 && max > 0) {
	    int x0 = (this.width - xSize) / 2;
	    int y0 = (this.height - ySize) / 2;
	    int scaled = Math.min(width, width * value / max);
	    if (scaled > 0) {
		if (invert) {
		    this.drawTexturedModalRect(x + x0 + width - scaled, y + y0, sourceX + width - scaled, sourceY, scaled, height);
		} else {
		    this.drawTexturedModalRect(x + x0, y + y0, sourceX, sourceY, scaled, height);
		}
	    }
	}
    }

    protected void drawVerticalProgressBar(int x, int y, int sourceX, int sourceY, int width, int height, int value, int max, boolean invert) {

	if (width > 0 && max > 0) {
	    int x0 = (this.width - xSize) / 2;
	    int y0 = (this.height - ySize) / 2;
	    int scaled = Math.min(height, height * value / max);
	    if (scaled > 0) {
		if (invert) {
		    this.drawTexturedModalRect(x + x0, y + y0, sourceX, sourceY, width, scaled);
		} else {
		    this.drawTexturedModalRect(x + x0, y + y0 + height - scaled, sourceX, sourceY + height - scaled, width, scaled);
		}
	    }
	}
    }
}
