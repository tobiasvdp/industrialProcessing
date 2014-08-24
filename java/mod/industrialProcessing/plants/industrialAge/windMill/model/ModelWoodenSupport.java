package mod.industrialProcessing.plants.industrialAge.windMill.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.IMultiblock;
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

public class ModelWoodenSupport extends ModelBlock {

	ObjRotator bar3 = new ObjRotator(new Bar3(), 0);
	ObjRotator base3 = new ObjRotator(new Box014(), 0);
	ObjRotator bar2 = new ObjRotator(new Bar2(), 0);
	ObjRotator base2 = new ObjRotator(new Box011(), 0);
	ObjRotator bar1 = new ObjRotator(new Bar1(), 0);
	ObjRotator base1 = new ObjRotator(new Box010(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);

		IIcon iconWood = block.getIcon(0, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.7f, 0.7f, 0.7f);
		GL11.glTranslatef(0, -0.5f, 0);

		bar3.getRotated(0).renderMesh(iconWood);
		base3.getRotated(0).renderMesh(iconWood);

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);
		int renderConnection = ((IMultiblock) entity).getModelConnection();

		IIcon iconWood = reference.getIcon(0);

		switch (renderConnection) {
		case 0:
			bar3.getRotated(dir).renderMesh(false, iconWood, reference);
			base3.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		case 1:
			bar2.getRotated(dir).renderMesh(false, iconWood, reference);
			base2.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		case 2:
			bar1.getRotated(dir).renderMesh(false, iconWood, reference);
			base1.getRotated(dir).renderMesh(false, iconWood, reference);
			break;
		}
		return true;
	}

}
