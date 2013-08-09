package ip.industrialProcessing.machines;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererBlock implements ISimpleBlockRenderingHandler{
	final int renderID;
	private TileEntity table;

    public RendererBlock(int var1,TileEntity tileEntity)
    {
        this.renderID = var1;
        table = tileEntity;
    }


    public void render(RenderBlocks renderBlocks, IBlockAccess iblockaccess, Block par1Block, int par2, int par3, int par4)
    {
        renderBlocks.overrideBlockTexture = par1Block.getBlockTexture(iblockaccess, par2, par3, par4, 0);


        renderBlocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.92F, 1.0F);
        renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);


        renderBlocks.clearOverrideBlockTexture();
    }
  
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -1.1F, -0.1F);
        GL11.glScalef(0.7F, 0.6F, 0.7F);
        TileEntityRenderer.instance.renderTileEntityAt(table, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }


    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        this.render(renderer, world, block, x, y, z);
        return true;
    }


    @Override
    public boolean shouldRender3DInInventory()
    {
        return true;
    }


    @Override
    public int getRenderId()
    {
        return this.renderID;
    }

}
