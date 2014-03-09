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

	public static void registerRendering(BlockContainerIPRendered block, ModelTileEntity model) {
		Class teClass = TileEntityRegistry.getTileEntityClassForBlock(block);
		if (model instanceof ModelAnimatedMachine) {
			ClientRegistry.bindTileEntitySpecialRenderer(teClass, new RendererTileEntityAnimated(block, block.getUnlocalizedName(), (ModelAnimatedMachine) model));
		} else {
			ClientRegistry.bindTileEntitySpecialRenderer(teClass, new RendererTileEntity(block, block.getUnlocalizedName(), model));
		}
		block.setRenderID(RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(new RendererTileBlock(block.getRenderType(), TileEntityRegistry.createNewTileEntity(block)));
	}
}
