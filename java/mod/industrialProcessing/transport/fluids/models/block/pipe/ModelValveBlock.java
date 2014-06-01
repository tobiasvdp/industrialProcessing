package mod.industrialProcessing.transport.fluids.models.block.pipe;

import mod.industrialProcessing.plants.transport.fluids.valve.TileEntityValve;
import mod.industrialProcessing.transport.fluids.models.tileEntity.ModelValve;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;

import org.lwjgl.opengl.GL11;

public class ModelValveBlock extends ModelPipeBlock {

	ModelValve valve = new ModelValve();

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		super.renderInventory(block, metadata, modelID, renderer);
	}
}
