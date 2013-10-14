package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class TileEntityGrate extends TileEntityFluidMachine {

    AirTree airTree = new AirTree();
    FluidTree fluidTree = new FluidTree();
    boolean airNotCompleted = true;
    boolean fluidNotCompleted = true;
    int skip = 0;
    private float pressure = 0;

    public TileEntityGrate() {
        addTank(2 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.UP, true, true);
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
        return true;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return false;
    }

    @Override
    public void updateEntity() {
        expandSearch();
        this.pressure /= 2;

        FluidTank tank = getTankInSlot(0);
        skip++;
        if (skip == 10) {
            skip = 0;
            if (this.pressure > 0) {
                if (tank.getFluidAmount() > FluidContainerRegistry.BUCKET_VOLUME) {
                    airTree.reset();
                    airNotCompleted = true;
                    while (airNotCompleted)
                        airNotCompleted = airTree.iterate(worldObj, xCoord, yCoord, zCoord);
                    dumpToWorld();
                }
            } else if (this.pressure < 0) {
                if (tank.getFluidAmount() < (tank.getCapacity() - FluidContainerRegistry.BUCKET_VOLUME)) {
                    fluidTree.reset();
                    fluidNotCompleted = true;
                    while (fluidNotCompleted)
                        fluidNotCompleted = fluidTree.iterate(worldObj, xCoord, yCoord, zCoord);
                    suckFromWorld();
                }
            }
        }
    }

    private void expandSearch() {
    }

    private void suckFromWorld() {
        FluidCoordinate coordinate = fluidTree.getFarest();
        if (coordinate != null && (coordinate.x != 0 || coordinate.y != 0 || coordinate.z != 0)) {
            int x = coordinate.x + xCoord;
            int y = coordinate.y + yCoord;
            int z = coordinate.z + zCoord;
            int id = worldObj.getBlockId(x, y, z);
            if (id == coordinate.blockId) {
                FluidStack stack = FluidUtils.drainBlock(id, worldObj, x, y, z, false);
                FluidTank tank = getTankInSlot(0);
                int fill = tank.fill(stack, false);
                if (fill == stack.amount && stack != null) {
                    stack = FluidUtils.drainBlock(id, worldObj, x, y, z, true);
                    tank.fill(stack, true);
                }
            }
        }
    }

    private void dumpToWorld() {
        FluidCoordinate coordinate = airTree.getClosest();
        if (coordinate != null && (coordinate.x != 0 || coordinate.y != 0 || coordinate.z != 0)) {
            int x = coordinate.x + xCoord;
            int y = coordinate.y + yCoord;
            int z = coordinate.z + zCoord;
            int id = worldObj.getBlockId(x, y, z);
            if (id == coordinate.blockId) {
                FluidTank tank = getTankInSlot(0);
                FluidStack stack = tank.drain(FluidContainerRegistry.BUCKET_VOLUME, false);
                if (stack != null && stack.amount == FluidContainerRegistry.BUCKET_VOLUME) {
                    if (worldObj.setBlock(x, y, z, stack.getFluid().getBlockID())) {
                        tank.drain(FluidContainerRegistry.BUCKET_VOLUME, true);
                    }
                }
            }
        }
    }

    @Override
    public void addPressure(ForgeDirection from, float pressure) {
        this.pressure += pressure;
    }

    @Override
    public float getPressure(ForgeDirection from) {
        return pressure;
    }

}
