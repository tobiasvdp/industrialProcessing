package mod.industrialProcessing.block.crystals;

import java.util.Random;

import javax.swing.Icon;

import mod.industrialProcessing.block.crystals.meshes.Crystal1;
import mod.industrialProcessing.block.crystals.meshes.Crystal2;
import mod.industrialProcessing.block.crystals.meshes.Crystal3;
import mod.industrialProcessing.block.crystals.meshes.Crystal4;
import mod.industrialProcessing.block.crystals.meshes.Crystal5;
import mod.industrialProcessing.block.crystals.meshes.Crystal6;
import mod.industrialProcessing.block.crystals.meshes.Crystal7;
import mod.industrialProcessing.block.crystals.meshes.Crystal8;
import mod.industrialProcessing.block.crystals.meshes.Crystal9;
import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelCrystal extends ModelBlock {

	private ObjMesh[] meshes = new ObjMesh[] { new Crystal1(), new Crystal2(), new Crystal3(), new Crystal4(), new Crystal5(), new Crystal6(), new Crystal7(), new Crystal8(), new Crystal9() };

	private void renderModels(int seed, IIcon icon, WorldReference position) {
		Random rnd = new Random(seed);

		for (int i = 0; i < meshes.length; i++) {
			if (rnd.nextGaussian() > 0) {
				meshes[i].renderMesh(false, icon, position);
			}
		}
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		IIcon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(-0.5f, -0.5f, -0.5f);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0.45f, 0);
		GL11.glScalef(2f, 2f, 2f);

		Random rnd = new Random(0);
		for (int i = 0; i < meshes.length; i++) {
			if (rnd.nextGaussian() > 0) {
				meshes[i].renderMesh(icon);
			}
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		IIcon icon = reference.getIcon(0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		renderModels(reference.x ^ reference.y ^ reference.z, icon, reference);
		return false;
	}

}
