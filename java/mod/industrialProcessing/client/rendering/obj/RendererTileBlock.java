package mod.industrialProcessing.client.rendering.obj;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererTileBlock implements ISimpleBlockRenderingHandler {
    final int renderID;
    private TileEntity table;

    public RendererTileBlock(int var1, TileEntity tileEntity) {
        this.renderID = var1;
        table = tileEntity;
    }

    public void render(RenderBlocks renderBlocks, IBlockAccess iblockaccess, Block par1Block, int par2, int par3, int par4) {

        renderBlocks.overrideBlockTexture = par1Block.getBlockTextureFromSide(0);

        renderBlocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);

        renderBlocks.clearOverrideBlockTexture();

    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glTranslatef(0, -1, 0);
        TileEntityRendererDispatcher.instance.renderTileEntityAt(table, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        // this.render(renderer, world, block, x, y, z);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int id) {
        return true;
    }

    @Override
    public int getRenderId() {
        return this.renderID;
    }

}
