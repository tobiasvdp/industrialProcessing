package ip.industrialProcessing.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public abstract class ModelBlock extends ModelBase {

	public abstract void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) ;

	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) { 
		return false;
	}

	
}
