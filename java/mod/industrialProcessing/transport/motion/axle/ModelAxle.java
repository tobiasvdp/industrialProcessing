package mod.industrialProcessing.transport.motion.axle;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;

public class ModelAxle extends ModelBlock {

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
		//renderer.renderStandardBlock(block, 0, 0, 0); 
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) { 
		renderer.renderStandardBlock(reference.block, reference.x, reference.y, reference.z);
		return false;
	}

}
