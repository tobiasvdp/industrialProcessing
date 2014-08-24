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

public class ModelWindMill extends ModelBlock {

	ObjRotator con = new ObjRotator(new Bar5(), 0);
	ObjRotator frame = new ObjRotator(new Frame(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);

		IIcon iconWood = block.getIcon(1, 0);
		IIcon iconBronze = block.getIcon(0, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.7f, 0.7f, 0.7f);
		GL11.glTranslatef(0, -0.5f, 0);

		frame.getRotated(0).renderMesh(iconBronze);
		con.getRotated(0).renderMesh(iconWood);

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);

		IIcon iconBronze = reference.getIcon(0);
		IIcon iconWood = reference.getIcon(1);

		frame.getRotated(dir).renderMesh(false, iconBronze, reference);
		con.getRotated(dir).renderMesh(false, iconWood, reference);
		return false;
	}

}
