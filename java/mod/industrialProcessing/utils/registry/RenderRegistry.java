package mod.industrialProcessing.utils.registry;

import java.util.HashMap;

import mod.industrialProcessing.block.BlockIPRendered;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.RendererBlock;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import mod.industrialProcessing.client.rendering.tileEntity.RendererTileBlock;
import mod.industrialProcessing.client.rendering.tileEntity.RendererTileEntity;
import mod.industrialProcessing.client.rendering.tileEntity.RendererTileEntityAnimated;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderRegistry {
	private static HashMap<Block, ModelBlock> array = new HashMap<Block, ModelBlock>();
	private static HashMap<Block, ModelTileEntity> arrayTE = new HashMap<Block, ModelTileEntity>();

	public static void registerRendering(Block block, ModelBlock model) {
		if (block instanceof BlockIPRendered) {
			if (((BlockIPRendered) block).getRenderType() == 0)
				((BlockIPRendered) block).setRenderID(RenderingRegistry.getNextAvailableRenderId());

			RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
		} else {
			if (((BlockContainerIPRendered) block).getRenderType() == 0)
				((BlockContainerIPRendered) block).setRenderID(RenderingRegistry.getNextAvailableRenderId());
			RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
		}
		array.put(block, model);
	}

	public static void registerRendering(BlockContainerIPRendered block, ModelBlock model) {
		if (((BlockContainerIPRendered) block).getRenderType() == 0)
			block.setRenderID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererBlock(block.getRenderType(), model));
		array.put(block, model);
	}

	public static void registerRendering(Block block, ModelTileEntity model) {
		Class teClass = TileEntityRegistry.getTileEntityClassForBlock(block);
		if (model instanceof ModelAnimatedMachine) {
			ClientRegistry.bindTileEntitySpecialRenderer(teClass, new RendererTileEntityAnimated(block, block.getUnlocalizedName(), (ModelAnimatedMachine) model));
		} else {
			ClientRegistry.bindTileEntitySpecialRenderer(teClass, new RendererTileEntity(block, block.getUnlocalizedName(), model));
		}
		if (((BlockContainerIPRendered) block).getRenderType() == 0) {
			((BlockContainerIPRendered) block).setRenderID(RenderingRegistry.getNextAvailableRenderId());
			RenderingRegistry.registerBlockHandler(new RendererTileBlock(block.getRenderType(), TileEntityRegistry.createNewTileEntity(block)));
		}
		arrayTE.put(block, model);
	}
}
