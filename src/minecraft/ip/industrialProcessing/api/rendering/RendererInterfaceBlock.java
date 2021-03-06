package ip.industrialProcessing.api.rendering;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererInterfaceBlock implements ISimpleBlockRenderingHandler {

    final int renderID;

    public RendererInterfaceBlock(int renderID) {
	this.renderID = renderID;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	if (block instanceof IModelBlock) {
	    IModelBlock blockInterface = (IModelBlock) block;
	    ModelBlock model = blockInterface.getModel();
	    model.renderInventory(block, metadata, modelID, renderer);
	}
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

	if (block == null || world == null) {
	    return false;
	}
	Minecraft mc = Minecraft.getMinecraft();
	mc.mcProfiler.startSection("IP");
	mc.mcProfiler.startSection(block.getUnlocalizedName());
	renderer.overrideBlockTexture = block.getBlockTexture(world, x, y, z, 0);

	renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);

	WorldReference reference = new WorldReference(world, x, y, z, block);
	boolean result = false;
	if (block instanceof IModelBlock) {
	    IModelBlock blockInterface = (IModelBlock) block;
	    ModelBlock model = blockInterface.getModel();
	    result = model.renderWorldBlock(reference, modelId, renderer);
	}

	renderer.clearOverrideBlockTexture();
	mc.mcProfiler.endSection();
	mc.mcProfiler.endSection();
	return result;
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
