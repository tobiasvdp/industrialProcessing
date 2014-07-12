package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.blockContainer.transport.IConnectedTile;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
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
        IIcon icon = block.getIcon(0, 0);
        IIcon icon1 = block.getIcon(1, 0);
        IIcon icon2 = block.getIcon(2, 0);

        bottom.renderMesh(icon2);

        for (int i = 0; i < 4; i++) {
            hopperSideFull.getRotated(i).renderMesh(icon1);
        }
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = 4 - BlockContainerIP.getMetadataFromForward(forward);

        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);

        if (entity instanceof TileEntityConveyorConnectionsBase) {
            TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) entity;

            IIcon iconConveyor = reference.getIcon(0);
            IIcon iconSide = reference.getIcon(1);
            IIcon iconHopper = reference.getIcon(2);
            bottom.renderMesh(false, iconHopper, reference);

            for (int i = 2; i < 6; i++) {

                ForgeDirection direction = ForgeDirection.getOrientation(i);

                ConnectionState state = belt.getConnection(direction);

                dir = 4 - BlockContainerIP.getMetadataFromForward(direction) + 1;
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
