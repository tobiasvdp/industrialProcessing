package ip.industrialProcessing.transport.items.conveyorModels;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.utils.DirectionUtils;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelConveyorOutputBlock extends ModelBlock {

    HopperBottom bottom = new HopperBottom();
    ObjRotator hopperSideFull = new ObjRotator(new HopperSideFull(), 0);
    ObjRotator hopperSideIntake = new ObjRotator(new HopperSideIntake(), 1);
    ObjRotator hopperIntakeConveyor = new ObjRotator(new HopperIntakeConveyor(), 1);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        Vector3f position = new Vector3f(0, 0, 0);
        Icon icon = block.getIcon(0, 0);
        Icon icon1 = block.getIcon(1, 0);
        Icon icon2 = block.getIcon(2, 0);

        bottom.renderMesh(icon2);

        for (int i = 0; i < 4; i++) {
            hopperSideFull.getRotated(i).renderMesh(icon1);
        }
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 4 - BlockMachine.getMetadataFromForward(forward);

        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);

        if (entity instanceof TileEntityConveyorConnectionsBase) {
            TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) entity;

            Icon iconConveyor = reference.getIcon(0);
            Icon iconSide = reference.getIcon(1);
            Icon iconHopper = reference.getIcon(2);
            bottom.renderMesh(false, iconHopper, reference);

            for (int i = 2; i < 6; i++) {

                ForgeDirection direction = ForgeDirection.getOrientation(i);

                ConnectionState state = belt.getConnection(direction);

                dir = 4 - BlockMachine.getMetadataFromForward(direction) + 1;
                if (state.isConnected()) {
                    hopperSideIntake.getRotated(dir).renderMesh(false, iconSide, reference);
                    hopperIntakeConveyor.getRotated(dir).renderMesh(false, iconConveyor, reference);
                } else {
                    hopperSideFull.getRotated(dir).renderMesh(false, iconSide, reference);
                }
            }
        }
        return false;
    }

    private ConnectionState getState(IConnectedTile entity, ForgeDirection forward, LocalDirection direction) {
        ForgeDirection world = DirectionUtils.getWorldDirection(direction, forward);
        return entity.getConnection(world);
    }
}
