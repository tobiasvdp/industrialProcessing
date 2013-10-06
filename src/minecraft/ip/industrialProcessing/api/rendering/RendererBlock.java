package ip.industrialProcessing.api.rendering;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

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
		renderer.overrideBlockTexture = block.getBlockTexture(world, x, y, z, 0);

		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);

		WorldReference reference = new WorldReference(world, x, y, z, block);
		boolean result = model.renderWorldBlock(reference, modelId, renderer);

		renderer.clearOverrideBlockTexture();
		return result;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return renderID;
	}

}
