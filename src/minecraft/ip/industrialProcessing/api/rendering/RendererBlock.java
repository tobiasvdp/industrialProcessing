package ip.industrialProcessing.api.rendering;

import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererBlock implements ISimpleBlockRenderingHandler {
	final int renderID;
	private ModelBlock model;

    public RendererBlock(int renderID, ModelBlock model)
    {
        this.renderID = renderID; 
        this.model = model;
    }
    
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		model.renderInventory(block, metadata, modelID, renderer);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) { 
		return  model.renderWorldBlock(world,x,y,z,block,modelId, renderer);
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
