package ip.industrialProcessing.decoration;

import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.util.vector.Vector3f;

public class ModelPlatform extends ModelBlock {

	FloorCenterMesh meshCenter = new FloorCenterMesh();
	FloorConnectedSide meshConnectedSide = new FloorConnectedSide();

	public ModelPlatform() {
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		Icon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(0, 0, 0);
		meshCenter.renderMesh(true, icon, position);
		meshConnectedSide.renderMesh(true, icon, position);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		Icon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(x, y, z);
		meshCenter.renderMesh(false, icon, position);
		meshConnectedSide.renderMesh(false, icon, position);
		return true;
	}
}
