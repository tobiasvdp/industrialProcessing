package ip.industrialProcessing.multiblock.gui;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.handlers.InfoTank;
import ip.industrialProcessing.api.handlers.InfoWorker;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.machines.containers.ProgressInfoTank;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblock;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTank;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorker;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GUImultiblock extends GuiContainer {

    private TEmultiblockCore tileEntity;
    private ResourceLocation textureLocation;
    private String name;
    private ContainerMultiblock container;
    protected int mouseX;
    protected int mouseY;
    protected int nameX = 8;
    protected int nameY = 6;
    protected ToolTip toolTip;

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
	fontRenderer.drawString(name, nameX, nameY, 4210752);
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
    
    protected void drawProgressBarTank(Rectangle source, Point location, int containerTankSlot) {
    	InfoTank tank = ((ContainerMultiblockTank) this.container).getLevelInfoTank(containerTankSlot);
    	if (tank.amount > 0) {

    	    Fluid fluid = FluidRegistry.getFluid(tank.fluidId);
    	    if (fluid != null) {

    		Icon icon = fluid.getIcon();
    		int x0 = (this.width - this.xSize) / 2;
    		int y0 = (this.height - this.ySize) / 2;

    		mc.renderEngine.func_110577_a(TextureMap.field_110575_b);

    		int size = tank.amount * source.getHeight() / tank.capacity;

    		int targetX = location.getX() + x0;
    		int targetY0 = location.getY() + y0;
    		int targetY = targetY0 + source.getHeight() - size;
    		// TODO: use tesselator to make this texture tile instead of
    		// stretch.
    		drawTexturedModelRectFromIcon(targetX, targetY, icon, source.getWidth(), size);
    		mc.renderEngine.func_110577_a(this.textureLocation);
    		drawTexturedModalRect(targetX, targetY0, source.getX(), source.getY(), source.getWidth(), source.getHeight());

    		Rectangle target = new Rectangle(targetX, targetY0, source.getWidth(), source.getHeight());

    		if (target.contains(this.mouseX, this.mouseY)) {

    		    String name = fluid.getLocalizedName();
    		    if (name.equals(fluid.getUnlocalizedName())) {
    			int blockID = fluid.getBlockID();
    			name = Block.blocksList[blockID].getLocalizedName();
    		    }
    		    this.toolTip = new ToolTip(name, "\u00a77" +tank.amount + "mB");
    		}
    	    }
    	}
        }

}
