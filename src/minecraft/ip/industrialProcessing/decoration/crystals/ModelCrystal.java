package ip.industrialProcessing.decoration.crystals;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal1;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal2;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal3;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal4;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal5;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal6;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal7;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal8;
import ip.industrialProcessing.decoration.crystals.meshes.Crystal9;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class ModelCrystal extends ModelBlock {

	private ObjMesh[] meshes = new ObjMesh[] { new Crystal1(), new Crystal2(), new Crystal3(), new Crystal4(), new Crystal5(), new Crystal6(), new Crystal7(), new Crystal8(), new Crystal9() };

	private void renderModels(int seed, boolean startDraw, Icon icon, Vector3f position) {
		// meshes[0].renderMesh(startDraw, icon, position);
		Random rnd = new Random(seed);

		for (int i = 0; i < meshes.length; i++) {
			if (rnd.nextGaussian() > 0) {
				meshes[i].renderMesh(startDraw, icon, position);
			}
		}
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Icon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(-0.5f, -0.5f, -0.5f);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0.25f, 0);
		GL11.glScalef(2f, 2f, 2f);

		renderModels(0, true, icon, position);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		Icon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		renderModels(x ^ y ^ z, false, icon, position);
		return false;
	}

}