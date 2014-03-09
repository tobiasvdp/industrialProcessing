package mod.industrialProcessing.client.rendering.block;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;

public abstract class ModelBlock extends ModelBase {

	public abstract void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer);

	public abstract boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer);


	

	
	
}
