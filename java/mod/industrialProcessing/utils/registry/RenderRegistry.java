package mod.industrialProcessing.utils.registry;

import java.util.HashMap;

import net.minecraft.block.Block;
import mod.industrialProcessing.block.BlockIPRendered;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.RendererBlock;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderRegistry {
	private static HashMap<Block, ModelBlock> array = new HashMap<Block, ModelBlock>();

	public static void registerRendering(BlockIPRendered block, ModelBlock model) {
		block.setRenderID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
		array.put(block, model);
	}
	
	public static void registerRendering(BlockContainerIPRendered block, ModelBlock model) {
		block.setRenderID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
		array.put(block, model);
	}
}
