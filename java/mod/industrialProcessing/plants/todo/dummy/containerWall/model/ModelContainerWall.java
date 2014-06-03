package mod.industrialProcessing.plants.todo.dummy.containerWall.model;

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

import org.lwjgl.util.vector.Vector3f;

public class ModelContainerWall extends ModelBlock {

	ObjRotator hull = new ObjRotator(new hull(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		IIcon iconHull = block.getIcon(0, 0);

		hull.getRotated(dir).renderMesh(iconHull);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);
		TileEntityMultiblockDummy dummy = (TileEntityMultiblockDummy) entity;
		if (dummy.getState() != MultiblockState.COMPLETED) {
			IIcon iconHull = reference.getIcon(0);
			hull.getRotated(dir).renderMesh(false, iconHull, reference);
		}
		return true;
	}
}
