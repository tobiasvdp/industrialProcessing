package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.blockContainer.transport.IConnectedTile;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeState;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelConveyorBeltBlock extends ModelBlock {

    protected ObjRotator straight = new ObjRotator(new Straight001(), 0);
    protected ObjRotator cornerLeft = new ObjRotator(new CornerLeft001(), 4);
    protected ObjRotator cornerRight = new ObjRotator(new CornerRight001(), 2);
    protected ObjRotator frontOut = new ObjRotator(new FrontOut001(), 1);
    protected ObjRotator leftIn = new ObjRotator(new LeftIn001(), 1);
    protected ObjRotator rightIn = new ObjRotator(new RightIn001(), 1);
    protected ObjRotator centerPiece = new ObjRotator(new CenterPiece001(), 1);
    protected ObjRotator backIn = new ObjRotator(new BackIn001(), 1);
    protected ObjSlopeRotationCombiner slopes = new ObjSlopeRotationCombiner();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Vector3f position = new Vector3f(0, 0, 0);
        IIcon icon = block.getIcon(0, 0);

        straight.getRotated(0).renderMesh(icon);
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

    protected ConnectionState getState(IConnectedTile entity, ForgeDirection forward, LocalDirection direction) {
        ForgeDirection world = DirectionUtils.getWorldDirection(direction, forward);
        return entity.getConnection(world);
    }

}
