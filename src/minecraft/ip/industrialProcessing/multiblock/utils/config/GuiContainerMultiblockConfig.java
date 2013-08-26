package ip.industrialProcessing.multiblock.utils.config;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.client.render.ModelMultiblock;
import ip.industrialProcessing.client.render.RendererMultiblock;
import ip.industrialProcessing.client.render.RendererTileEntity;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RendererBlock;
import ip.industrialProcessing.multiblock.GuiContainerMultiblockCore;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.block.weldingStation.TileEntityMultiblockWeldingStationScreen;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.machine.weldingStation.ContainerMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.utils.ModelMultiblockWeldingStation;
import ip.industrialProcessing.utils.GuiButtonCustom;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

public class GuiContainerMultiblockConfig extends GuiContainerMultiblockCore {
	private int xbase;
	private int ybase;
	private int zbase;
	private int xsize;
	private int ysize;
	private int zsize;
	private TileEntityMultiblockCoreInv tileEntity;
	
	public GuiContainerMultiblockConfig(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMultiblockConfig(inventoryPlayer, tileEntity), "Welding station configuration", "textures/gui/MultiblockConfig.png");
		xSize = 198;
		ySize = 165;
		setProgressBarLocation(106, 31, 23, 19);
		setProgressBarOrigin(198, 0);
		
		ItemStack[][][] layout = tileEntity.getItemStackLayout();
		
		xbase = (3-layout.length)/2;
		ybase = (3-layout[0].length)/2;
		zbase = (3-layout[0][0].length)/2;
		xsize = layout.length;
		ysize = layout[0].length;
		zsize = layout[0][0].length;
		this.tileEntity = tileEntity;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		ItemStack[][][] layout = tileEntity.getItemStackLayout();
		
		int size = layout.length * layout[0].length * layout[0][0].length;
		int xbase = (3-layout.length)/2;
		int ybase = (3-layout[0].length)/2;
		int zbase = (3-layout[0][0].length)/2;
		
		int count = 0;
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[0].length; j++) {
				for (int k = layout[0][0].length-1; k >= 0; k--) {
					ItemStack stack =  layout[i][j][k];
					if (stack != null) {
						drawItemStack(stack,x+54+((i+xbase)*8)+((k+zbase)*8),y+126-((j+ybase)*8)-((k+zbase)*4)+((i+xbase)*4),"");
					}
					count++;
				}
			}
		}
		//renderTE();
	}
	private void renderTE(){
		GL11.glTranslatef(50F, 100F, 50F);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(-200.0F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -1.1F, -0.1F);
        GL11.glScalef(7F, 6F, 7F);
        TileEntityMultiblockWeldingStation te = new TileEntityMultiblockWeldingStation();
        te.connectedSides = tileEntity.connectedSides;
        TileEntityRenderer.instance.renderTileEntityAt(te, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	}
    private void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRenderer.zLevel = 200.0F;
        FontRenderer font = null;
        if (par1ItemStack != null) font = par1ItemStack.getItem().getFontRenderer(par1ItemStack);
        if (font == null) font = fontRenderer;
        itemRenderer.renderItemAndEffectIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3);
        this.zLevel = 0.0F;
        itemRenderer.zLevel = 0.0F;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		mc.renderEngine.func_110577_a(this.textureLocation);
		drawTexturedModalRect(175, 116,198, 116, 18, 18);
		drawTexturedModalRect(175, 141,198, 141, 18, 18);
		
		fontRenderer.drawString(name, 8, 6, 4210752);
	}
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		// make buttons
		// id, x, y, width, height, text
		buttonList.add(new GuiButtonCustom(0, 173 + x, 137 + y, 23, 29, ""));
		GuiButtonCustom button = new GuiButtonCustom(1, 173 + x, 107 + y, 23, 29, "");
		button.enabled=false;
		buttonList.add(button);

	}
}
