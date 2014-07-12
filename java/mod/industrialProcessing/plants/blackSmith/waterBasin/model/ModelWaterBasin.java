package mod.industrialProcessing.plants.blackSmith.waterBasin.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.plants.blackSmith.waterBasin.model.core.Core;
import mod.industrialProcessing.plants.blackSmith.waterBasin.model.dummy.Dummy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelWaterBasin extends ModelBlock {

	ObjRotator core = new ObjRotator(new Core(), 0);
	ObjRotator dummy = new ObjRotator(new Dummy(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		IIcon iconStone = block.getIcon(0, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		GL11.glTranslatef(0.5f, 0f, 0f);
		core.getRotated(dir).renderMesh(iconStone);
		GL11.glTranslatef(-1f, 0f, 0f);
		dummy.getRotated(dir).renderMesh(iconStone);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);
		ITileEntityMultiblockSwitcher te = (ITileEntityMultiblockSwitcher) entity;

		IIcon iconStone = reference.getIcon(0);

		if (te.isCore()) {
			core.getRotated(dir).renderMesh(false, iconStone, reference);
		} else {
			dummy.getRotated(dir).renderMesh(false, iconStone, reference);
		}

		return true;
	}
}
