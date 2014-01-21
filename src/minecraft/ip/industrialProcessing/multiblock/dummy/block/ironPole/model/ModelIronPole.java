package ip.industrialProcessing.multiblock.dummy.block.ironPole.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelIronPole extends ModelBlock {

	ObjRotator frame = new ObjRotator(new Cone001(), 0);
	ObjRotator post = new ObjRotator(new Box001(), 0);
	ObjRotator con = new ObjRotator(new PowerConnector(), 0);
	ObjRotator pow = new ObjRotator(new PowerOutlet(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconFrame = block.getIcon(0, 0);
		Icon iconPost = block.getIcon(1, 0);

		frame.getRotated(0).renderMesh(iconFrame);
		post.getRotated(0).renderMesh(iconPost);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);

		Icon iconFrame = reference.getIcon(0);
		Icon iconPost = reference.getIcon(1);
		Icon iconOutlet = reference.getIcon(2);

		frame.getRotated(dir).renderMesh(false, iconFrame, reference);
		if (reference.world.getBlockId(reference.x, reference.y - 1, reference.z) != 00 && reference.world.isBlockSolidOnSide(reference.x, reference.y - 1, reference.z, ForgeDirection.UP, false)) {
			post.getRotated(dir).renderMesh(false, iconPost, reference);
			con.getRotated(dir).renderMesh(false, iconPost, reference);
			pow.getRotated(dir).renderMesh(false, iconOutlet, reference);
		}
		return true;
	}
}
