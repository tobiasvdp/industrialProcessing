package ip.industrialProcessing.transport.items.conveyorOutput;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorOutput extends TileEntityConveyorInventoryBase {

    public TileEntityConveyorOutput() {
        super();
        setConnectionMode(LocalDirection.FRONT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.BACK, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.UP, ConnectionMode.INVENTORYINPUT);
        setConnectionMode(LocalDirection.DOWN, ConnectionMode.ANYOUTPUT);
        Arrays.fill(canReverse, false);
        Arrays.fill(canSlope, false);
    }

    @Override
    protected void rerouteStack(MovingItemStack stack) {
        stack.destination = LocalDirection.DOWN;
        stack.routed = true;
    }

    @Override
    protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {
        return LocalDirection.DOWN;
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
