package ip.industrialProcessing.power.wire.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelWireBlock extends ModelBlock {

	ObjRotator side = new ObjRotator(new EndSide(), 0);
	EndUp up = new EndUp();
	EndDown down = new EndDown();
	ObjRotator straightHorizontal = new ObjRotator(new StraightHorizontal(), 0);
	StraightVertical straightVertical = new StraightVertical();
	Center center = new Center();
	ConnectorTop capUp = new ConnectorTop();
	ConnectorBottom capDown = new ConnectorBottom();
	ObjRotator cap = new ObjRotator(new ConnectorSide(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		Vector3f position = new Vector3f(0, 0, 0);
		Icon icon = block.getIcon(0, 0);
		straightVertical.renderMesh(true, icon, position);
		capUp.renderMesh(true, icon, position);
		capDown.renderMesh(true, icon, position);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(reference.baseBrightness);
		tessellator.setColorOpaque(255, 255, 255);
 

		Icon icon = reference.getIcon(0);

		if (entity instanceof IConnectedTile) {
			IConnectedTile tile = (IConnectedTile) entity;
			ConnectionState up = tile.getConnection(ForgeDirection.UP);
			ConnectionState down = tile.getConnection(ForgeDirection.DOWN);
			ConnectionState north = tile.getConnection(ForgeDirection.NORTH);
			ConnectionState east = tile.getConnection(ForgeDirection.EAST);
			ConnectionState south = tile.getConnection(ForgeDirection.SOUTH);
			ConnectionState west = tile.getConnection(ForgeDirection.WEST);
			if (up.isConnected() && down.isConnected() && !north.isConnected() && !south.isConnected() && !east.isConnected() && !west.isConnected()) {
				straightVertical.renderMesh(false, icon, reference);
			} else if (!up.isConnected() && !down.isConnected() && north.isConnected() && south.isConnected() && !east.isConnected() && !west.isConnected()) {
				straightHorizontal.getRotated(0).renderMesh(false, icon, reference);
			} else if (!up.isConnected() && !down.isConnected() && !north.isConnected() && !south.isConnected() && east.isConnected() && west.isConnected()) {
				straightHorizontal.getRotated(1).renderMesh(false, icon, reference);
			} else {
				if(up.isConnected())
					this.up.renderMesh(false, icon, reference);
				if(down.isConnected())
					this.down.renderMesh(false, icon, reference);
				if(north.isConnected())
					this.side.getRotated(0).renderMesh(false, icon, reference);
				if(west.isConnected())
					this.side.getRotated(1).renderMesh(false, icon, reference);
				if(south.isConnected())
					this.side.getRotated(2).renderMesh(false, icon, reference);
				if(east.isConnected())
					this.side.getRotated(3).renderMesh(false, icon, reference);
				center.renderMesh(false, icon, reference);
			}

			if(up.isPlugged())
				this.capUp.renderMesh(false, icon, reference);
			if(down.isPlugged())
				this.capDown.renderMesh(false, icon, reference);
			if(north.isPlugged())
				this.cap.getRotated(0).renderMesh(false, icon, reference);
			if(west.isPlugged())
				this.cap.getRotated(1).renderMesh(false, icon, reference);
			if(south.isPlugged())
				this.cap.getRotated(2).renderMesh(false, icon, reference);
			if(east.isPlugged())
				this.cap.getRotated(3).renderMesh(false, icon, reference);
		}
		return false;
	}

}