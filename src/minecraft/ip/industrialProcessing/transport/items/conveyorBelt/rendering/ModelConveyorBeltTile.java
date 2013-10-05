package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedOriented;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.BendPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.CrossPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.ItemPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.PathState;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.SlopePath;

import java.util.Iterator;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class ModelConveyorBeltTile extends ModelConnectedOriented {

	@Override
	protected void renderModelConnectedOriented(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		//super.renderModelConnectedOriented(tl, f, forward, front, right, back, left, up, down);
		ItemPath path = null;
		if (front.isConnected() && (left.isConnected() != right.isConnected()) && !back.isConnected()) {
			if (left.isConnected()) {
				path = new BendPath(true);
			} else {
				path = new BendPath(false);
			}
		} else {
			if (front.isConnected() && back.isConnected() && !left.isConnected() && !right.isConnected() && !up.isConnected() && !down.isConnected()) {
				path = new SlopePath(tl, front, back);
			} else {
				path = new CrossPath(tl, front, left, right, back, up, down);
			}
		}
		if (tl instanceof TileEntityConveyorTransportBase) {
			TileEntityConveyorTransportBase belt = (TileEntityConveyorTransportBase) tl;
			drawItems(path, f, belt);
		}
	}

	protected void drawItems(ItemPath path, float f5, TileEntityConveyorTransportBase belt) {
		RenderItem itemrenderer = (RenderItem) RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
		for (Iterator<MovingItemStack> iterator = belt.iterateStacks(); iterator.hasNext();) {
			MovingItemStack stack = iterator.next();
			renderStack(stack, itemrenderer, f5, path, belt);
		}
	}

	private void renderStack(MovingItemStack stack, RenderItem itemrenderer, float f5, ItemPath path, TileEntity tl) {
		PathState state = path.getPosition(stack);

		EntityItem entity = new EntityItem(tl.worldObj, tl.xCoord, tl.yCoord, tl.zCoord, stack.stack);
		entity.hoverStart = 0;

		float scale = 1.5f;
		float oneOverScale = 1f / scale;
		GL11.glPushMatrix();
		GL11.glScalef(oneOverScale, oneOverScale, oneOverScale);
		GL11.glTranslatef(state.x * scale, state.y * scale + 0.9f * scale, state.z * scale);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(state.pitch, 1, 0, 0);
		GL11.glRotatef(state.heading, 0, 1, 0);
		itemrenderer.doRenderItem(entity, 0, 0, 0, 0, f5);
		GL11.glPopMatrix();
	}
}
