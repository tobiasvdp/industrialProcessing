package ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.model.core.Core;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.model.dummy.Dummy;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
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
		Icon iconStone = block.getIcon(0, 0);

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
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);
		ITileEntityMultiblockSwitcher te = (ITileEntityMultiblockSwitcher) entity;

		Icon iconStone = reference.getIcon(0);

		if (te.isCore()) {
			core.getRotated(dir).renderMesh(false, iconStone, reference);
		} else {
			dummy.getRotated(dir).renderMesh(false, iconStone, reference);
		}

		return true;
	}
}
