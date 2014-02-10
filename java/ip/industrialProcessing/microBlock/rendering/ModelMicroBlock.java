package ip.industrialProcessing.microBlock.rendering;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;

public class ModelMicroBlock extends ModelBlock {

	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		RenderConnectionsMicroblock.renderMicroBlockParts(reference);
		return true;
	}
}
