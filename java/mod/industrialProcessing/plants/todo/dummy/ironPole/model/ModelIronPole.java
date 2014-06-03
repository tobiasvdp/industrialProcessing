package mod.industrialProcessing.plants.todo.dummy.ironPole.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelIronPole extends ModelBlock {

	ObjRotator frame = new ObjRotator(new Cone001(), 0);
	ObjRotator post = new ObjRotator(new Box001(), 0);
	ObjRotator con = new ObjRotator(new PowerConnector(), 0);
	ObjRotator pow = new ObjRotator(new PowerOutlet(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		IIcon iconFrame = block.getIcon(0, 0);
		IIcon iconPost = block.getIcon(1, 0);

		frame.getRotated(0).renderMesh(iconFrame);
		post.getRotated(0).renderMesh(iconPost);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);

		IIcon iconFrame = reference.getIcon(0);
		IIcon iconPost = reference.getIcon(1);
		IIcon iconOutlet = reference.getIcon(2);

		frame.getRotated(dir).renderMesh(false, iconFrame, reference);
		if (reference.world.getBlock(reference.x, reference.y - 1, reference.z) != null && reference.world.getBlock(reference.x, reference.y - 1, reference.z).isSideSolid(reference.world,reference.x, reference.y - 1, reference.z, ForgeDirection.UP)) {
			post.getRotated(dir).renderMesh(false, iconPost, reference);
			con.getRotated(dir).renderMesh(false, iconPost, reference);
			pow.getRotated(dir).renderMesh(false, iconOutlet, reference);
		}
		return true;
	}
}
