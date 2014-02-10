package ip.industrialProcessing.multiblock.dummy.block.containerWall.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelContainerWall extends ModelBlock {

	ObjRotator hull = new ObjRotator(new hull(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconHull = block.getIcon(0, 0);

		hull.getRotated(dir).renderMesh(iconHull);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);
		TileEntityMultiblockDummy dummy = (TileEntityMultiblockDummy) entity;
		if (dummy.getState() != MultiblockState.COMPLETED) {
			Icon iconHull = reference.getIcon(0);
			hull.getRotated(dir).renderMesh(false, iconHull, reference);
		}
		return true;
	}
}
