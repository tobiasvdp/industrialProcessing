package ip.industrialProcessing.transport.items.conveyorModels;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelConveyorBeltBlock extends ModelBlock {

	ObjRotator straight = new ObjRotator(new Straight001(), 0);
	ObjRotator cornerLeft = new ObjRotator(new CornerLeft001(), 4);
	ObjRotator cornerRight = new ObjRotator(new CornerRight001(), 2);
	ObjRotator frontOut = new ObjRotator(new FrontOut001(), 1);
	ObjRotator leftIn = new ObjRotator(new LeftIn001(), 1);
	ObjRotator rightIn = new ObjRotator(new RightIn001(), 1);
	ObjRotator centerPiece = new ObjRotator(new CenterPiece001(), 1);
	ObjRotator backIn = new ObjRotator(new BackIn001(), 1);
	ObjSlopeRotationCombiner slopes = new ObjSlopeRotationCombiner();

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		Icon icon = block.getIcon(0, 0);

		straight.getRotated(0).renderMesh(true, icon, position);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		System.out.println("ModelConveyorBeltBlock.renderWorldBlock()");
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = 4 - BlockMachine.getMetadataFromForward(forward);

		Icon icon = reference.getIcon(0);
		Icon iconCenter = reference.getIcon(1);

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
			} else if (front.isConnected() && left.isConnected() && !back.isConnected() && !right.isConnected()) {
				cornerLeft.getRotated(dir).renderMesh(false, icon, reference);
			} else if (front.isConnected() && right.isConnected() && !back.isConnected() && !left.isConnected()) {
				cornerRight.getRotated(dir).renderMesh(false, icon, reference);
			} else {
				if (left.isConnected())
					leftIn.getRotated(dir).renderMesh(false, icon, reference);

				if (right.isConnected())
					rightIn.getRotated(dir).renderMesh(false, icon, reference);

				if (back.isConnected())
					backIn.getRotated(dir).renderMesh(false, icon, reference);

				if (front.isConnected() && back.isConnected()) {
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

	private ConnectionState getState(IConnectedTile entity, ForgeDirection forward, LocalDirection direction) {
		ForgeDirection world = DirectionUtils.getWorldDirection(direction, forward);
		return entity.getConnection(world);
	}

}
