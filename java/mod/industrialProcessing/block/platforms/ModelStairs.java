package mod.industrialProcessing.block.platforms;

import javax.swing.Icon;

import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.connectedTile.ConnectionCompass;
import mod.industrialProcessing.client.rendering.obj.connectedTile.TileConnection;
import mod.industrialProcessing.client.rendering.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ModelStairs extends ModelBlock {

	Stairs[] stairs = new Stairs[4];
	StairsHandRail1[] handrail1 = new StairsHandRail1[4];
	StairsHandRail2[] handrail2 = new StairsHandRail2[4];

	StairsCap1[] stairsCap1 = new StairsCap1[4];
	StairsCap2[] stairsCap2 = new StairsCap2[4];

	StairsConnected1[] stairsConnected1 = new StairsConnected1[4];
	StairsConnected2[] stairsConnected2 = new StairsConnected2[4];

	public ModelStairs() {
		Matrix4f rotation = Matrix4f.rotate((float) Math.PI / 2, new Vector3f(0, 1, 0), new Matrix4f(), null);

		stairs[0] = new Stairs();
		handrail1[0] = new StairsHandRail1();
		handrail2[0] = new StairsHandRail2();
		stairsCap1[0] = new StairsCap1();
		stairsCap2[0] = new StairsCap2();
		stairsConnected1[0] = new StairsConnected1();
		stairsConnected2[0] = new StairsConnected2();

		for (int i = 1; i < 4; i++) {
			stairs[i] = (Stairs) stairs[i - 1].cloneTransformed(rotation);
			handrail1[i] = (StairsHandRail1) handrail1[i - 1].cloneTransformed(rotation);
			handrail2[i] = (StairsHandRail2) handrail2[i - 1].cloneTransformed(rotation);
			stairsCap1[i] = (StairsCap1) stairsCap1[i - 1].cloneTransformed(rotation);
			stairsCap2[i] = (StairsCap2) stairsCap2[i - 1].cloneTransformed(rotation);
			stairsConnected1[i] = (StairsConnected1) stairsConnected1[i - 1].cloneTransformed(rotation);
			stairsConnected2[i] = (StairsConnected2) stairsConnected2[i - 1].cloneTransformed(rotation);
		}
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		IIcon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(0, 0, 0);
		GL11.glPushMatrix();
		// GL11.glTranslatef(0, -0.5f, 0);
		// GL11.glScalef(0.7f, 0.7f, 0.7f);
		stairs[0].renderMesh(icon);
		handrail1[0].renderMesh(icon);
		// handrail2[0].renderMesh(true, icon, position);
		stairsCap1[0].renderMesh(icon);
		stairsCap2[0].renderMesh(icon);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		IIcon icon = reference.getIcon(0);
		int rotation = reference.getBlockMetadata();
		rotation %= 4;


		ConnectionCompass compass = new ConnectionCompass();

		if (reference.block instanceof BlockStairs)
			compass = ((BlockStairs) reference.block).getConnections(reference.world, reference.x, reference.y, reference.z);

		TileConnection[] lefts = new TileConnection[4];
		lefts[0] = compass.connectionE;
		lefts[1] = compass.connectionN;
		lefts[2] = compass.connectionW;
		lefts[3] = compass.connectionS;
		TileConnection[] rights = new TileConnection[4];
		rights[0] = compass.connectionW;
		rights[1] = compass.connectionS;
		rights[2] = compass.connectionE;
		rights[3] = compass.connectionN;

		boolean forceRailing = true;

		stairs[rotation].renderMesh(false, icon, reference);
		if (lefts[rotation] != TileConnection.CONNECTED) {
			if (forceRailing || lefts[rotation] != TileConnection.WALL)
				handrail1[rotation].renderMesh(false, icon, reference);
			stairsCap1[rotation].renderMesh(false, icon, reference);
		} else {
			stairsConnected1[rotation].renderMesh(false, icon, reference);
		}
		if (rights[rotation] != TileConnection.CONNECTED) {
			if (forceRailing || rights[rotation] != TileConnection.WALL)
				handrail2[rotation].renderMesh(false, icon, reference);
			stairsCap2[rotation].renderMesh(false, icon, reference);
		} else {
			stairsConnected2[rotation].renderMesh(false, icon, reference);
		}
		return true;
	}

}
