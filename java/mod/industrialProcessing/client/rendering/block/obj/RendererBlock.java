package mod.industrialProcessing.client.rendering.block.obj;

import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererBlock implements ISimpleBlockRenderingHandler {
    final int renderID;
    private ModelBlock model;

    public RendererBlock(int renderID, ModelBlock model) {
	this.renderID = renderID;
	this.model = model;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	model.renderInventory(block, metadata, modelID, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

	if (block == null || world == null) {
	    return false;
	}
	Minecraft mc = Minecraft.getMinecraft();
	mc.mcProfiler.startSection("IP");
	mc.mcProfiler.startSection(block.getClass().getSimpleName());
	renderer.overrideBlockTexture = block.getBlockTextureFromSide(0);

	renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);

	WorldReference reference = new WorldReference(world, x, y, z, block);
	boolean result = model.renderWorldBlock(reference, modelId, renderer);

	renderer.clearOverrideBlockTexture();
	mc.mcProfiler.endSection();
	mc.mcProfiler.endSection(); 

	return result;
    }

    @Override
    public int getRenderId() {
	return renderID;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

}
