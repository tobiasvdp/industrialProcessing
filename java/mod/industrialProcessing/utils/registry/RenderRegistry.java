package mod.industrialProcessing.utils.registry;

import java.util.HashMap;

import mod.industrialProcessing.blocks.BlockIPRendered;
import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.RendererBlock;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderRegistry {
	private static HashMap<BlockIPRendered, Integer> array = new HashMap<BlockIPRendered, Integer>();

	public static void registerRendering(BlockIPRendered block, ModelBlock model) {
		block.setRenderID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
	}
}
