package ip.industrialProcessing.machines.flotationCell.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;

public class ModelFlotationCell extends ModelBlock {

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
	// TODO Auto-generated method stub
	return false;
    }

}
