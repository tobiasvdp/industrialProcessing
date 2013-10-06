package ip.industrialProcessing.transport.fluids.models.pipe;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.transport.fluids.TileEntityTank;

public class ModelPipeBlock extends ModelBlock {

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
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque(255, 255, 255);

		Vector3f position = new Vector3f(x, y, z);

		Icon icon = block.getIcon(0, world.getBlockMetadata(x, y, z));

		if (entity instanceof IConnectedTile) {
			IConnectedTile tile = (IConnectedTile) entity;
			ConnectionState up = tile.getConnection(ForgeDirection.UP);
			ConnectionState down = tile.getConnection(ForgeDirection.DOWN);
			ConnectionState north = tile.getConnection(ForgeDirection.NORTH);
			ConnectionState east = tile.getConnection(ForgeDirection.EAST);
			ConnectionState south = tile.getConnection(ForgeDirection.SOUTH);
			ConnectionState west = tile.getConnection(ForgeDirection.WEST);
			if (up.isConnected() && down.isConnected() && !north.isConnected() && !south.isConnected() && !east.isConnected() && !west.isConnected()) {
				straightVertical.renderMesh(false, icon, position);
			} else if (!up.isConnected() && !down.isConnected() && north.isConnected() && south.isConnected() && !east.isConnected() && !west.isConnected()) {
				straightHorizontal.getRotated(0).renderMesh(false, icon, position);
			} else if (!up.isConnected() && !down.isConnected() && !north.isConnected() && !south.isConnected() && east.isConnected() && west.isConnected()) {
				straightHorizontal.getRotated(1).renderMesh(false, icon, position);
			} else {
				if(up.isConnected())
					this.up.renderMesh(false, icon, position);
				if(down.isConnected())
					this.down.renderMesh(false, icon, position);
				if(north.isConnected())
					this.side.getRotated(0).renderMesh(false, icon, position);
				if(west.isConnected())
					this.side.getRotated(1).renderMesh(false, icon, position);
				if(south.isConnected())
					this.side.getRotated(2).renderMesh(false, icon, position);
				if(east.isConnected())
					this.side.getRotated(3).renderMesh(false, icon, position);
				center.renderMesh(false, icon, position);
			}

			if(up.isPlugged())
				this.capUp.renderMesh(false, icon, position);
			if(down.isPlugged())
				this.capDown.renderMesh(false, icon, position);
			if(north.isPlugged())
				this.cap.getRotated(0).renderMesh(false, icon, position);
			if(west.isPlugged())
				this.cap.getRotated(1).renderMesh(false, icon, position);
			if(south.isPlugged())
				this.cap.getRotated(2).renderMesh(false, icon, position);
			if(east.isPlugged())
				this.cap.getRotated(3).renderMesh(false, icon, position);
		}
		return false;
	}

}
