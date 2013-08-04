package ip.industrialProcessing.machines;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiContainerMachine extends GuiContainer {

public TileEntity tileEntity;
protected String name;
protected String textureLocation;
	
	public GuiContainerMachine (InventoryPlayer inventoryPlayer,TileEntity tileEntity, ContainerMachine container,String name,String textureLocation) {
		super(container);
		this.tileEntity = tileEntity;
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
		ResourceLocation texture = new ResourceLocation(textureLocation);
        mc.renderEngine.func_110577_a(texture);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	    extendedDraw();
	}
	public void extendedDraw(){
		
	}


}
