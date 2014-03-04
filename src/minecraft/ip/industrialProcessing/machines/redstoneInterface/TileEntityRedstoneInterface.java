package ip.industrialProcessing.machines.redstoneInterface;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityRedstoneInterface extends TileEntityMachine implements IStateConfig {

    private int output;
    private IWorker worker;
    private RedstoneMode idleOutput = RedstoneMode.OFF; // no work
    private RedstoneMode workingOutput = RedstoneMode.OFF; // working
    private RedstoneMode suspendedOutput = RedstoneMode.OFF; // no power or full

    public TileEntityRedstoneInterface() {
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            IWorker worker = getWorker();

            if (worker != null) {
                int output = 0;
                if (workingOutput != RedstoneMode.OFF) {
                    if (worker.isEnabled() && worker.isWorking()) {

                        int workOutput;
                        if (workingOutput == RedstoneMode.DEPENDANT)
                            workOutput = worker.getWorkDone() * 15 / worker.getTotalWork();
                        else
                            workOutput = 15;
                        if (workOutput > output)
                            output = workOutput;
                    }
                }
                if (idleOutput != RedstoneMode.OFF) {
                    if (worker.isEnabled() && !worker.isWorking() && worker.getWorkDone() <= 1)
                        output = 15;
                }
                if (suspendedOutput != RedstoneMode.OFF) {
                    if (worker.isEnabled() && !worker.isWorking() && worker.getWorkDone() > 1)
                        output = 15;
                }
                setOutput(output);
            }
        }
    }

    private IWorker getWorker() {

        if (this.worker == null)
            this.worker = findWorker();

        return worker;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        writeConfig(nbt);
        nbt.setInteger("SignalOutput", output);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        readConfig(nbt);
        output = nbt.getInteger("SignalOutput");
    }

    private IWorker findWorker() {
        ForgeDirection dir = this.getForwardDirection();
        if (dir != null) {
            TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
            if (entity instanceof IWorkingEntity) {
                IWorkingEntity workingEntity = (IWorkingEntity) entity;
                return workingEntity.getWorker();
            }
        }
        return null;
    }

    private void setOutput(int i) {
        if (output != i) {
            output = i;
            this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.blockMetadata);
            this.notifyBlockChange();
        }
    }

    @Override
    public boolean canWrenchRotate() {
        return false;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return false;
    }

    public int getOutput() {
        return output;
    }

    private void readConfig(NBTTagCompound nbt) {
        int[] values = nbt.getIntArray("RStates");
        for (int i = 0; i < values.length; i++) {
            setStateValue(i, values[i]);
        }
    }

    private void writeConfig(NBTTagCompound nbt) {
        int[] values = new int[getStateCount()];
        for (int i = 0; i < values.length; i++) {
            values[i] = getStateValue(i);
        }
        nbt.setIntArray("RStates", values);
    }

    @Override
    public int getStateValue(int index) {
        switch (index) {
        case 0:
            return this.idleOutput.ordinal();
        case 1:
            return this.workingOutput.ordinal();
        case 2:
            return this.suspendedOutput.ordinal();
        default:
            return 0;
        }
    }

    @Override
    public void setStateValue(int index, int value) {

        switch (index) {
        case 0:
            this.idleOutput = RedstoneMode.modes[value];
            break;
        case 1:
            this.workingOutput = RedstoneMode.modes[value];
            break;
        case 2:
            this.suspendedOutput = RedstoneMode.modes[value];
            break;
        default:
            break;
        }
    }

    @Override
    public int getMaxStateValue(int index) {

        switch (index) {
        case 0: // idle
            return 1; // on, off
        case 1:// working
            return 2; // on, off, dependant
        case 2:// suspended
            return 1; // on, off
        default:
            return 0;
        }
    }

    @Override
    public int getMinStateValue(int index) {
        return 0;
    }

    @Override
    public int getStateCount() {
        return 3;
    }
}
