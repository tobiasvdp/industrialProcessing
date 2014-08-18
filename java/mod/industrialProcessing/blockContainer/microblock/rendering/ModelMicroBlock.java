package mod.industrialProcessing.blockContainer.microblock.rendering;

import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
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
