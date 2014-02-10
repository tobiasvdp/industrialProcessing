package ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class CrossPath extends ItemPath {

    private ForgeDirection forward;

    public CrossPath(TileEntity tl, ConnectionState front, ConnectionState left, ConnectionState right, ConnectionState back, ConnectionState up, ConnectionState down) {
        this.forward = BlockMachine.getForwardFromEntity(tl);
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
