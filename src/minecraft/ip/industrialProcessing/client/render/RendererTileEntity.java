package ip.industrialProcessing.client.render;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.crusher.ModelCrusher;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class RendererTileEntity extends TileEntitySpecialRenderer {
    private ModelMachine model;
    protected ResourceLocation texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/");
    private Block block;
    protected String[] name = new String[2];
    protected boolean rotateModel = true;

    public RendererTileEntity(Block block, String name, ModelMachine model) {
	this.block = block;
	this.name[0] = name;
	texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name + ".png");
	this.model = model;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f) {
	GL11.glPushMatrix();
	// This will move our renderer so that it will be on proper place in the
	// world
	GL11.glTranslatef((float) d0, (float) d1, (float) d2);
	/*
	 * Note that true tile entity coordinates (tileEntity.xCoord, etc) do
	 * not match to render coordinates (d, etc) that are calculated as [true
	 * coordinates] - [player coordinates (camera coordinates)]
	 */
	renderBlockYour(tileEntity, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, block);
	GL11.glPopMatrix();

    }

    public void renderBlockYour(TileEntity tl, World world, int i, int j, int k, Block block) {
	Tessellator tessellator = Tessellator.instance;
	// This will make your block brightness dependent from surroundings
	// lighting.
	float animation = 0;
	if (world != null) {

	    float f = block.getBlockBrightness(world, i, j, k);
	    int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
	    int l1 = l % 65536;
	    int l2 = l / 65536;
	    tessellator.setColorOpaque_F(f, f, f);
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

	    int dir = world.getBlockMetadata(i, j, k);
	    GL11.glPushMatrix();
	    GL11.glTranslatef(0.5F, 1.5F, 0.5F);
	    // This line actually rotates the renderer.
	    if (rotateModel)
		GL11.glRotatef((dir * -90F), 0F, 1F, 0F);
	    GL11.glRotatef((-180F), 0F, 0F, 1F);
	    GL11.glScalef(1f, 1f, 1f);

	    func_110628_a(getTexture(tl, world, i, j, k, block, 0.0625f));
	} else {
	    GL11.glPushMatrix();
	    GL11.glTranslatef(0.3F, 3.7F, 0.5F);
	    GL11.glRotatef((90F), 0F, 1F, 0F);
	    GL11.glRotatef((-180F), 0F, 0F, 1F);
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	    GL11.glScalef(1.5f, 1.5f, 1.5f);
	    this.func_110628_a(texture);
	}

	renderBlock(tl, world, i, j, k, block, 0.0625f);

	GL11.glPopMatrix();
    }

    protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
	this.model.renderModel(f);
    }
    protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f){
		return texture;
    }
}
