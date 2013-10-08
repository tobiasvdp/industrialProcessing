package ip.industrialProcessing.machines.treetap.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;

public class ModelAutomaticTreeTapBlock extends ModelBlock {

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean renderWorldBlock(WorldReference world, int modelId, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        return false;
    }

}
