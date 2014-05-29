package mod.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class CrossPath extends ItemPath {

    private ForgeDirection forward;

    public CrossPath(TileEntity tl, ConnectionState front, ConnectionState left, ConnectionState right, ConnectionState back, ConnectionState up, ConnectionState down) {
        this.forward = BlockContainerIP.getForwardFromEntity(tl);
    }

    @Override
    public PathState getPosition(MovingItemStack stack) {
        PathState state = new PathState();
        float mul = 1;
        if (stack.progress < 0.5) {
            float d = 0.5f - stack.progress;
            LocalDirection inbound = stack.source;
            if (inbound == LocalDirection.UNKNOWN)
                inbound = LocalDirection.UP;
            state.x = inbound.offsetX * d;
            state.y = inbound.offsetY * d;
            state.z = inbound.offsetZ * d;
            mul = -1;
        } else {
            float d = stack.progress - 0.5f;
            LocalDirection outbound = stack.destination;
            state.x = outbound.offsetX * d;
            state.y = outbound.offsetY * d;
            state.z = outbound.offsetZ * d;
        }
        state.heading = 180 + mul * 180 * (float) (Math.atan2(state.x, -state.y) / Math.PI);

        return state;
    }

}
