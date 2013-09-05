package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GUImultiblockToggleButton extends GuiScreen {
	public TEmultiblockToggleButton tileEntity;
	protected String name;
	protected ResourceLocation textureLocation;
	protected int xSize = 176;
	protected int ySize = 166;

	public GUImultiblockToggleButton(TEmultiblockToggleButton tileEntity) {
		this.tileEntity = tileEntity;
		this.name = "Control panel";
		this.textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ToggleButton.png");
	}

	@Override
	public void drawBackground(int par1) {
		super.drawBackground(par1);		
	}
	
	@Override
	public void initGui() {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.clear();
		((TEmultiblockElevator) this.tileEntity.getCore()).findLevels();
		ArrayList<Integer> levels = ((TEmultiblockElevator) this.tileEntity.getCore()).getLevels();
		for(int i = levels.size()-1;i>=0;i--){
			this.buttonList.add(new GuiButton(i, x + xSize/2 - 40, y + ySize - 30 - i*25, 80, 20, "Floor "+i));
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		mc.renderEngine.func_110577_a(this.textureLocation);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		fontRenderer.drawString(name, x+8, y+6, 4210752);
		
		super.drawScreen(par1, par2, par3);
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		
	} 

}
