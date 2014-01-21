package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedOriented;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.BendPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.CrossPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.ItemPath;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.PathState;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths.SlopePath;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorCornerLeftTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorCornerRightTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorStraightTileEntity;

import java.util.Iterator;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class ModelConveyorBeltTile extends ModelConnectedOriented {

    ConveyorStraightTileEntity straight = new ConveyorStraightTileEntity();
    ConveyorCornerRightTileEntity cornerRight = new ConveyorCornerRightTileEntity();
    ConveyorCornerLeftTileEntity cornerLeft = new ConveyorCornerLeftTileEntity();

    @Override
    protected void renderModelConnectedOriented(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
	// super.renderModelConnectedOriented(tl, f, forward, front, right,
	// back, left, up, down);
	ItemPath path = null;
	if (front.isConnected() && (left.isConnected() != right.isConnected()) && !back.isConnected()) {
	    if (left.isConnected()) {
		path = new BendPath(true);
		drawPath(cornerLeft, tl, f, -90);
	    } else {
		path = new BendPath(false);
		drawPath(cornerRight, tl, f, 90);
	    }
	} else {
	    if (front.isConnected() && back.isConnected() && !left.isConnected() && !right.isConnected() && !up.isConnected() && !down.isConnected()) {
		path = new SlopePath(tl, front, back);
		ObjMesh conveyorBand = getSlopeBand((TileEntityConveyorConnectionsBase) tl, front, back);
		drawPath(conveyorBand, tl, f, 0);
	    } else {
		path = new CrossPath(tl, front, left, right, back, up, down);
		if (front.isConnected() && back.isConnected())
		    drawPath(straight, tl, f, 0);
	    }
	} 
	if (tl instanceof TileEntityConveyorTransportBase) {
	    TileEntityConveyorTransportBase belt = (TileEntityConveyorTransportBase) tl;
	    drawItems(path, f, belt);
	}
    }

    private ObjMesh getSlopeBand(TileEntityConveyorConnectionsBase tl, ConnectionState front, ConnectionState back) {
	if (front.isConnected() && back.isConnected()) {
	    SlopeState frontSlope = tl.getSlope(LocalDirection.FRONT);
	    SlopeState backSlope = tl.getSlope(LocalDirection.BACK);
	    if (frontSlope == SlopeState.FLAT && backSlope == SlopeState.FLAT)
		return straight;
	}
	return null;
    }

    private void drawPath(ObjMesh conveyorBand, TileEntity tl, float f, float rotation) {
	if (tl instanceof TileEntityConveyorTransportBase) {
	    TileEntityConveyorTransportBase conveyor = (TileEntityConveyorTransportBase) tl;
	    float progress = conveyor.getDummyProgress();
	    Icon icon = getIcon(-progress);
	    GL11.glPushMatrix();
	    GL11.glRotatef(180, 0, 0, 1);
	    GL11.glRotatef(-90 + rotation, 0, 1, 0);
	    GL11.glTranslatef(0, -1, 0);
	    conveyorBand.rerenderMesh(icon);
	    GL11.glPopMatrix();
	}
    }

    private Icon getIcon(float progress) {
	return new ScrollIcon(progress);
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
