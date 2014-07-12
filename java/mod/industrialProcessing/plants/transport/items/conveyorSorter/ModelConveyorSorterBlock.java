package mod.industrialProcessing.plants.transport.items.conveyorSorter;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.FilterLeft001;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.FilterRight001;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.ModelConveyorBeltBlock;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeState;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelConveyorSorterBlock extends ModelConveyorBeltBlock {
	ObjRotator leftOut = new ObjRotator(new FilterLeft001(), 1);
	ObjRotator rightOut = new ObjRotator(new FilterRight001(), 1);

	public ModelConveyorSorterBlock() {

	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		IIcon icon = block.getIcon(0, 0);

		straight.getRotated(0).renderMesh(icon);
		leftOut.getRotated(0).renderMesh(icon);
		rightOut.getRotated(0).renderMesh(icon);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = 4 - BlockContainerIP.getMetadataFromForward(forward);

		IIcon icon = reference.getIcon(0);
		IIcon iconCenter = reference.getIcon(1);

		if (entity instanceof TileEntityConveyorConnectionsBase) {
			TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) entity;
			ConnectionState front = getState(belt, forward, LocalDirection.BACK);
			ConnectionState left = getState(belt, forward, LocalDirection.RIGHT);
			ConnectionState right = getState(belt, forward, LocalDirection.LEFT);
			ConnectionState back = getState(belt, forward, LocalDirection.FRONT);

			SlopeState fs = belt.getSlope(LocalDirection.BACK);
			SlopeState bs = belt.getSlope(LocalDirection.FRONT);

			if (fs != SlopeState.FLAT || bs != SlopeState.FLAT || front.isConnected() && back.isConnected() && !left.isConnected() && !right.isConnected()) {
				slopes.getRenderer(fs, bs).getRotated(dir).renderMesh(false, icon, reference);
			} else {
				boolean requireBack = false;

				if (left.isConnected()) {
					leftOut.getRotated(dir).renderMesh(false, icon, reference);
					requireBack = true;
				}

				if (right.isConnected()) {
					rightOut.getRotated(dir).renderMesh(false, icon, reference);
					requireBack = true;
				}

				if (back.isConnected() || requireBack)
					backIn.getRotated(dir).renderMesh(false, icon, reference);

				if (front.isConnected() && (back.isConnected() || requireBack)) {
					straight.getRotated(dir).renderMesh(false, icon, reference);
				} else {
					if (front.isConnected())
						frontOut.getRotated(dir).renderMesh(false, icon, reference);
					centerPiece.getRotated(dir).renderMesh(false, iconCenter, reference);
				}
			}
		}
		return true;
	}
}
