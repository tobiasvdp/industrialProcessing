package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenWheel.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
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

		IIcon iconWood = block.getIcon(0, 0);

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

		if (((TileEntityMultiblockDummy) entity).getState() != MultiblockState.COMPLETED) {

			ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
			int dir = BlockContainerIP.getMetadataFromForward(forward);
			int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();
			if (renderConnection > 3)
				dir = BlockContainerIP.getMetadataFromForward(forward.getOpposite());

			IIcon iconWood = reference.getIcon(0);

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
		}
		return true;
	}
}