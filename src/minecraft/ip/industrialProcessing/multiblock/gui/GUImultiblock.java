package ip.industrialProcessing.multiblock.gui;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.handlers.InfoWorker;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblock;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GUImultiblock extends GuiContainer {

    private TEmultiblockCore tileEntity;
    private ResourceLocation textureLocation;
    private String name;
    private ContainerMultiblock container;

    public GUImultiblock(InventoryPlayer inventoryPlayer, TEmultiblockCore tileEntity, ContainerMultiblock cTmultiblock, String name, String textureLocation) {
	super(cTmultiblock);
	this.container = cTmultiblock;
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

    protected void drawProgressBarWorker(Rectangle source, Point location, boolean horizontal, int containerWorkerIndex) {
	InfoWorker worker = null;
	if (this.container instanceof ContainerMultiblockTankWorker) {
	    worker = ((ContainerMultiblockTankWorker) this.container).getProgressInfoWorker(containerWorkerIndex);
	    drawProgressBar(source, location, worker.workDone, worker.totalWork, horizontal, false);
	}
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
	    int scaled = Math.min(width, (int) (width * value / max));
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
	    int scaled = Math.min(height, (int) (height * value / max));
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
