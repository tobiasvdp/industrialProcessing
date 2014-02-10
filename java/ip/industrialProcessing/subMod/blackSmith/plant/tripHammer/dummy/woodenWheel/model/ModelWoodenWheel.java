package ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelWoodenWheel extends ModelBlock {

	ObjRotator wheel1 = new ObjRotator(new WheelPart1(), 0);
	ObjRotator wheel2 = new ObjRotator(new WheelPart2(), 0);
	ObjRotator wheel3 = new ObjRotator(new WheelPart3(), 0);
	ObjRotator wheel4 = new ObjRotator(new WheelPart4(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);

		Icon iconWood = block.getIcon(0, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		GL11.glTranslatef(0f, -0.5f, -0.5f);
		wheel1.getRotated(0).renderMesh(iconWood);
		GL11.glTranslatef(0f, 0f, 1f);
		wheel2.getRotated(0).renderMesh(iconWood);
		GL11.glTranslatef(0f, 1f, 0f);
		wheel3.getRotated(0).renderMesh(iconWood);
		GL11.glTranslatef(0f, 0f, -1f);
		wheel4.getRotated(0).renderMesh(iconWood);

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);
		int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();
		if(renderConnection > 3)
			dir = BlockMachine.getMetadataFromForward(forward.getOpposite());

		Icon iconWood = reference.getIcon(0);

		switch (renderConnection) {
		case 6:
		case 0:
			wheel2.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		case 7:
		case 1:
			wheel3.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		case 4:
		case 2:
			wheel1.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		case 5:
		case 3:
			wheel4.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		}

		return true;
	}
}