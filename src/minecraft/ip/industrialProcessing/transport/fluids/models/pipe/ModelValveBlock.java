package ip.industrialProcessing.transport.fluids.models.pipe;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.transport.fluids.ModelValve;
import ip.industrialProcessing.transport.fluids.TileEntityValve;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class ModelValveBlock extends ModelPipeBlock {

	ModelValve valve = new ModelValve();

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		super.renderInventory(block, metadata, modelID, renderer);
		GL11.glPushMatrix();
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glTranslatef(0, -1, 0);
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityValve(), 0.0625f, 0, 0, 0);
		GL11.glPopMatrix();
	}
}
