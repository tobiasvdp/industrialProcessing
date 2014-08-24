package mod.industrialProcessing.plants.industrialAge.windMill.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
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

public class ModelSails extends ModelBlock {

	ObjRotator con = new ObjRotator(new Con1(), 0);
	ObjRotator sails = new ObjRotator(new Sail(), 0);
	ObjRotator rot = new ObjRotator(new Rot(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);

		IIcon iconBronze = block.getIcon(0, 0);
		IIcon iconWood = block.getIcon(1, 0);
		IIcon iconCanvas = block.getIcon(2, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.4f, 0.4f, 0.4f);

		con.getRotated(0).renderMesh(iconBronze);
		
		GL11.glTranslatef(0, 0.5f, 0);
		rot.getRotated(0).renderMesh(iconWood);
		sails.getRotated(0).renderMesh(iconCanvas);

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);

		IIcon iconWood = reference.getIcon(0);

		con.getRotated(dir).renderMesh(false, iconWood, reference);
		return false;
	}

}
