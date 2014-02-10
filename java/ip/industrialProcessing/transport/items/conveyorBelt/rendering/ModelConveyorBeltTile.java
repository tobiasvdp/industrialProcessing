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
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorCenterTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorCornerLeftTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorCornerRightTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeFlatToUpTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorInputTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorOutputTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeDownToFlatTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeFlatToDownTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeStraightDownTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeStraightUpTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorStraightTileEntity;
import ip.industrialProcessing.transport.items.conveyorModels.tileEntity.ConveyorSlopeUpToFlatTileEntity;

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
    ConveyorCenterTileEntity center = new ConveyorCenterTileEntity();
    ConveyorInputTileEntity input = new ConveyorInputTileEntity();
    ConveyorOutputTileEntity output = new ConveyorOutputTileEntity();
    ConveyorSlopeStraightDownTileEntity slopeStraightDown = new ConveyorSlopeStraightDownTileEntity();
    ConveyorSlopeStraightUpTileEntity slopeStraightUp = new ConveyorSlopeStraightUpTileEntity();

    ConveyorSlopeDownToFlatTileEntity downToFlat = new ConveyorSlopeDownToFlatTileEntity();
    ConveyorSlopeFlatToDownTileEntity flatToDown = new ConveyorSlopeFlatToDownTileEntity();
    ConveyorSlopeUpToFlatTileEntity upToFlat = new ConveyorSlopeUpToFlatTileEntity();
    ConveyorSlopeFlatToUpTileEntity flatToUp = new ConveyorSlopeFlatToUpTileEntity();

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
	    TileEntityConveyorConnectionsBase connections = (TileEntityConveyorConnectionsBase) tl;
	    SlopeState frontSlope = connections.getSlope(LocalDirection.FRONT);
	    SlopeState backSlope = connections.getSlope(LocalDirection.BACK);

	    if (frontSlope != SlopeState.FLAT || backSlope != SlopeState.FLAT || front.isConnected() && back.isConnected() && !left.isConnected() && !right.isConnected() && !up.isConnected() && !down.isConnected()) {
		path = new SlopePath(tl, front, back);
		drawSlopeBand(tl, f, frontSlope, backSlope, front, back);
	    } else {
		path = new CrossPath(tl, front, left, right, back, up, down);
		if (front.isConnected() && back.isConnected())
		    drawPath(straight, tl, f, 0);
		else {
		    drawPath(center, tl, f, 0);
		    if (front.isConnected())
			drawPath(output, tl, f, 0);
		    if (back.isConnected())
			drawPath(input, tl, f, 0);
		}
		drawSides(tl, f, left, right);

	    }
	}
	if (tl instanceof TileEntityConveyorTransportBase) {
	    TileEntityConveyorTransportBase belt = (TileEntityConveyorTransportBase) tl;
	    drawItems(path, f, belt);
	}
    }

    protected void drawSlopeBand(TileEntity tl, float f, SlopeState frontSlope, SlopeState backSlope, ConnectionState front, ConnectionState back) {

	if (frontSlope == SlopeState.FLAT && backSlope == SlopeState.FLAT)
	    drawPath(straight, tl, f, 0);
	else if (frontSlope == SlopeState.DOWN && backSlope == SlopeState.UP)
	    drawPath(slopeStraightUp, tl, f, 0);
	else if (frontSlope == SlopeState.UP && backSlope == SlopeState.DOWN)
	    drawPath(slopeStraightDown, tl, f, 180);
	else if (frontSlope == SlopeState.DOWN && backSlope == SlopeState.FLAT)
	    drawPath(downToFlat, tl, f, 0);
	else if (frontSlope == SlopeState.UP && backSlope == SlopeState.FLAT)
	    drawPath(upToFlat, tl, f, 180);
	else if (frontSlope == SlopeState.FLAT && backSlope == SlopeState.UP)
	    drawPath(flatToUp, tl, f, 0);
	else if (frontSlope == SlopeState.FLAT && backSlope == SlopeState.DOWN)
	    drawPath(flatToDown, tl, f, 180);
    }

    protected void drawSides(TileEntity tl, float f, ConnectionState left, ConnectionState right) {
	if (left.isConnected())
	    drawPath(input, tl, f, -90);
	if (right.isConnected())
	    drawPath(input, tl, f, 90);
    }

    private ObjMesh getSlopeBand(SlopeState frontSlope, SlopeState backSlope, ConnectionState front, ConnectionState back) {

	return null;
    }

    protected void drawPath(ObjMesh conveyorBand, TileEntity tl, float f, float rotation) {
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
