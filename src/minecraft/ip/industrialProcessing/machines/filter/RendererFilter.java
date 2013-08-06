package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RendererFilter extends TileEntitySpecialRenderer {
	public static RendererFilter instance = new RendererFilter();
	ModelFilter model = new ModelFilter(); 
	private static final ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN,"textures/render/ModelFilter.png");
    
	public RendererFilter() {
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1,
			double d2, float f) {
		GL11.glPushMatrix();
        //This will move our renderer so that it will be on proper place in the world
        GL11.glTranslatef((float)d0, (float)d1, (float)d2);
        TileEntityFilter tileEntityYour = (TileEntityFilter)tileEntity;
        /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
        renderBlockYour(tileEntityYour, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, IndustrialProcessing.blockFilter);
       GL11.glPopMatrix();

	}
	 public void renderBlockYour(TileEntityFilter tl, World world, int i, int j, int k, Block block) {
	        Tessellator tessellator = Tessellator.instance;
	        //This will make your block brightness dependent from surroundings lighting.
	        if (world != null){
		        float f = block.getBlockBrightness(world, i, j, k);
		        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		        int l1 = l % 65536;
		        int l2 = l / 65536;
		        tessellator.setColorOpaque_F(f, f, f);
		        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2); 
		        
		        int dir = world.getBlockMetadata(i, j, k);
		        GL11.glPushMatrix();
		         GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		         //This line actually rotates the renderer.
		         GL11.glRotatef((dir*-90F), 0F, 1F, 0F);
		         GL11.glRotatef((-180F), 0F, 0F, 1F);
		         GL11.glScalef(1f, 1f, 1f);
		         String textureLocation = "textures/render/ModelFilter.png";
		         
		         func_110628_a(new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN,textureLocation));
	         }else{   
		         GL11.glPushMatrix();
		         GL11.glTranslatef(0.3F, 3.7F, 0.5F);
		         GL11.glRotatef((90F), 0F, 1F, 0F);
		         GL11.glRotatef((-180F), 0F, 0F, 1F);
		         GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		         GL11.glScalef(1.5f, 1.5f, 1.5f);
		         this.func_110628_a(texture);
	         }
	         /*
	         Place your rendering code here.
	         */
	         this.model.renderModel(0.0625F);

	        GL11.glPopMatrix();
	}
}
