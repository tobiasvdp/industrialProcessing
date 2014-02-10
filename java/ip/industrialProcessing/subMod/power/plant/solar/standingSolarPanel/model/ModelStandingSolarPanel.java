package ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelStandingSolarPanel extends ModelBlock {

	ObjRotator frame = new ObjRotator(new SolarFrame(), 0);
	ObjRotator connect = new ObjRotator(new Cone001(), 0);
	ObjRotator bracket = new ObjRotator(new Cone002(), 0);
	ObjRotator topping = new ObjRotator(new Cylinder001(), 0);
	ObjRotator solar = new ObjRotator(new SolarTop(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconFrame = block.getIcon(0, 0);
		Icon iconPost = block.getIcon(1, 0);
		Icon iconSolar = block.getIcon(2, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		GL11.glTranslatef(0f, -0.3f, 0f);
		frame.getRotated(0).renderMesh(iconFrame);
		connect.getRotated(0).renderMesh(iconPost);
		topping.getRotated(0).renderMesh(iconPost);
		bracket.getRotated(0).renderMesh(iconPost);
		solar.getRotated(0).renderMesh(iconSolar);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);

		Icon iconFrame = reference.getIcon(0);
		Icon iconPost = reference.getIcon(1);
		Icon iconSolar = reference.getIcon(2);

		frame.getRotated(dir).renderMesh(false, iconFrame, reference);
		connect.getRotated(dir).renderMesh(false, iconPost, reference);
		topping.getRotated(dir).renderMesh(false, iconPost, reference);
		bracket.getRotated(dir).renderMesh(false, iconPost, reference);
		solar.getRotated(dir).renderMesh(false, iconSolar, reference);
		return true;
	}
}
