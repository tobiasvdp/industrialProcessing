package ip.industrialProcessing.decoration.crystals;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
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

public class ModelCrystal extends ModelBlock {

	private ObjMesh[] meshes = new ObjMesh[] { new Crystal1(), new Crystal2(), new Crystal3(), new Crystal4(), new Crystal5(), new Crystal6(), new Crystal7(), new Crystal8(), new Crystal9() };

	private void renderModels(int seed, Icon icon, WorldReference position) {
		// meshes[0].renderMesh(startDraw, icon, position);
		Random rnd = new Random(seed);

		for (int i = 0; i < meshes.length; i++) {
			if (rnd.nextGaussian() > 0) {
				meshes[i].renderMesh(false, icon, position);
			}
		}
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Icon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(-0.5f, -0.5f, -0.5f);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0.45f, 0);
		GL11.glScalef(2f, 2f, 2f);

		Random rnd = new Random(0);
		for (int i = 0; i < meshes.length; i++) {
			if (rnd.nextGaussian() > 0) {
				meshes[i].renderMesh( icon);
			}
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		Icon icon = reference.getIcon(0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		renderModels(reference.x ^ reference.y ^ reference.z, icon, reference);
		return false;
	}

}
