package ip.industrialProcessing.microBlock.rendering;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;

public class ModelMicroBlock extends ModelBlock {

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		RenderConnectionsMicroblock.renderMicroBlockParts(reference);
		return true;
	}
}
