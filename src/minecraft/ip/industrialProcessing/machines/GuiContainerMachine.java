package ip.industrialProcessing.machines;

import ip.industrialProcessing.IndustrialProcessing;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiContainerMachine extends GuiContainer {

public TileEntityMachine tileEntity;
protected String name;
protected String textureLocation;
protected int progressBarX = 70;
protected int progressBarY = 34;
protected int progressBarWidth = 22;
protected int progressBarHeight = 16;
	
	public GuiContainerMachine (InventoryPlayer inventoryPlayer,TileEntity tileEntity, ContainerMachine container,String name,String textureLocation) {
		super(container);
		this.tileEntity = (TileEntityMachine) tileEntity;
		this.name = name;
		this.textureLocation = textureLocation;
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString(name, 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
		extendedDrawString();
	}

	public void extendedDrawString() {
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN,textureLocation);
        mc.renderEngine.func_110577_a(texture);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	    
	    //progress indicator
		int scale = tileEntity.getScaledProgress(progressBarWidth);
		if (scale > 0){
			this.drawTexturedModalRect(x+progressBarX, y+progressBarY, 176, 0, scale, progressBarHeight);
		}
	    extendedDraw();
	}
	public void setProgressBarLocation(int x,int y,int w,int h){
		progressBarX = x;
		progressBarY = y;
		progressBarWidth = w;
		progressBarHeight = h;
	}
	public void extendedDraw(){
		
	}


}
