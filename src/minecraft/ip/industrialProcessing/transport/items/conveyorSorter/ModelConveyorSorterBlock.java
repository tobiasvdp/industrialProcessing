package ip.industrialProcessing.transport.items.conveyorSorter;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.transport.items.conveyorModels.FilterLeft001;
import ip.industrialProcessing.transport.items.conveyorModels.FilterRight001;
import ip.industrialProcessing.transport.items.conveyorModels.ModelConveyorBeltBlock;

public class ModelConveyorSorterBlock extends ModelConveyorBeltBlock {
    ObjRotator leftOut = new ObjRotator(new FilterLeft001(), 1);
    ObjRotator rightOut = new ObjRotator(new FilterRight001(), 1);

    public ModelConveyorSorterBlock() {

    }

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Vector3f position = new Vector3f(0, 0, 0);
        Icon icon = block.getIcon(0, 0);

        straight.getRotated(0).renderMesh(true, icon, position);
        leftOut.getRotated(0).renderMesh(true, icon, position);
        rightOut.getRotated(0).renderMesh(true, icon, position);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
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
                    leftOut.getRotated(dir).renderMesh(false, icon, reference);

                if (right.isConnected())
                    rightOut.getRotated(dir).renderMesh(false, icon, reference);

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
}
