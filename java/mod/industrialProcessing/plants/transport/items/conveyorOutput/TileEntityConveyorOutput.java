package mod.industrialProcessing.plants.transport.items.conveyorOutput;

import java.util.Arrays;
import java.util.List;

import mod.industrialProcessing.blockContainer.transport.TransportConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorInventoryBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConnectionMode;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityConveyorOutput extends TileEntityConveyorInventoryBase {

    public TileEntityConveyorOutput() {
        super();
        setConnectionMode(LocalDirection.FRONT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.BACK, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.LEFT, ConnectionMode.INPUT);
        setConnectionMode(LocalDirection.UP, ConnectionMode.ANYINPUT);
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
