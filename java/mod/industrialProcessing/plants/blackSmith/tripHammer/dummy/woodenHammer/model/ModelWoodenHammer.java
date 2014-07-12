package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer.model;

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

public class ModelWoodenHammer extends ModelBlock {

	ObjRotator hammer = new ObjRotator(new Hammer(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);

		IIcon iconWood = block.getIcon(0, 0);

		GL11.glPushMatrix();

		hammer.getRotated(0).renderMesh(iconWood);

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();

		if (((TileEntityMultiblockDummy) entity).getState() != MultiblockState.COMPLETED) {

			ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
			int dir = BlockContainerIP.getMetadataFromForward(forward);
			int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();

			IIcon iconWood = reference.getIcon(0);

			hammer.getRotated(dir).renderMesh(false, iconWood, reference);
		}
		return true;
	}
}