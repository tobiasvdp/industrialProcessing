package ip.industrialProcessing.transport.items.conveyorChute;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.ItemTransfers;

public class TileEntityConveyorChute extends TileEntityConveyorInventoryBase {

    public TileEntityConveyorChute() {
        super();
        setConnectionMode(LocalDirection.FRONT, ConnectionMode.ANYOUTPUT);
        setConnectionMode(LocalDirection.BACK, ConnectionMode.ANYOUTPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.ANYOUTPUT);
        setConnectionMode(LocalDirection.RIGHT, ConnectionMode.ANYOUTPUT);
        setConnectionMode(LocalDirection.UP, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.DOWN, ConnectionMode.ANYOUTPUT);
        Arrays.fill(canReverse, false);
        Arrays.fill(canSlope, false);
        canReverse[LocalDirection.DOWN.ordinal()] = true; 
    }

    @Override
    protected void rerouteStack(MovingItemStack stack) { 
        super.rerouteStack(stack);
    }
    
    @Override
    protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {
        ForgeDirection[] outputOrder = new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST };

        // search according to outputOrder for inventories
        for (int i = 0; i < outputOrder.length; i++) {
            ForgeDirection direction = outputOrder[i];
            TransportConnectionState state = this.states[direction.ordinal()];
            if (state.isOutput()) {
                LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
                if (local != source) {
                    ConnectionMode mode = this.getConnectionMode(local);
                    if (mode.isInventoryOutput()) {
                        TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction);
                        if (neighbor instanceof IInventory) {
                            IInventory inventory = (IInventory) neighbor;
                            if (ItemTransfers.canInsert(stack, inventory))
                                return local;
                        }
                    }
                }
            }
        }
        // when no inventories are found,
        // search according to outputOrder for conveyors
        for (int i = 0; i < outputOrder.length; i++) {
            ForgeDirection direction = outputOrder[i];
            TransportConnectionState state = this.states[direction.ordinal()];
            if (state == TransportConnectionState.TRANSPORT) {
                LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);
                if (local != source) {
                    ConnectionMode mode = this.getConnectionMode(local);
                    if (mode.isOutput(false))
                        return local;
                }
            }
        }

        return LocalDirection.UNKNOWN;
    }

    @Override
    protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
        return super.outputToTileEntity(stack, neighbor, direction);
    }

    @Override
    protected TransportConnectionState handleInventoryState(IInventory inventory, ForgeDirection direction, ConnectionMode mode) {
        return TransportConnectionState.OUTPUT;
    }

    @Override
    public void addCollisionBoxes(List par6List, AxisAlignedBB par5AxisAlignedBB) {
        addCollisionBox(par6List, par5AxisAlignedBB, 0, 0, 0, 1, 1 - 4 / 16f, 1);

        addCollisionBox(par6List, par5AxisAlignedBB, 15 / 16f, 1 - 4 / 16f, 0, 1, 1, 1);
        addCollisionBox(par6List, par5AxisAlignedBB, 0, 1 - 4 / 16f, 0, 1 / 16f, 1, 1);

        addCollisionBox(par6List, par5AxisAlignedBB, 0, 1 - 4 / 16f, 15 / 16f, 1, 1, 1);
        addCollisionBox(par6List, par5AxisAlignedBB, 0, 1 - 4 / 16f, 0, 1, 1, 1 / 16f);
    }
}
