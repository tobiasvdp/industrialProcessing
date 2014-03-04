package ip.industrialProcessing.subMod.power.plant.creative;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;

public class TileEntityCreativeGenerator extends TileEntityPowerGenerator implements IStateConfig {

    private int voltage;

    public TileEntityCreativeGenerator() {
    }
 
    @Override
    public float getVoltage() {
        return this.voltage;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger("Voltage", voltage);
        super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("Voltage"))
            this.voltage = nbt.getInteger("Voltage");
        else
            this.voltage = 100;
        super.readFromNBT(nbt);
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
        return true;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return false;
    }

    @Override
    public int getStateValue(int index) {
        if (index == 0)
            return this.voltage;
        return 0;
    }

    @Override
    public void setStateValue(int index, int value) {
        if (index == 0)
            this.voltage = value;

    }

    @Override
    public int getMaxStateValue(int index) {
        if (index == 0)
            return 1000;
        return 0;
    }

    @Override
    public int getMinStateValue(int index) {
        return 0;
    }

    @Override
    public int getStateCount() { 
        return 1;
    }

}
