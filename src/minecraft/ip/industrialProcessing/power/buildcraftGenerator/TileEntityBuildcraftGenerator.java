package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBuildcraftGenerator extends TileEntityPowerGenerator implements IPowerReceptor {

    private static final float JOULE_BALANCE = 0.5f; // 1 BC joule = 2 Physical
						     // joules

    private static final float GENERATOR_VOLTAGE = 0;

    private PowerHandler powerHandler;

    private float capacitance;

    public TileEntityBuildcraftGenerator() {
	super(100);
	this.powerHandler = new PowerHandler(this, Type.MACHINE);
	this.powerHandler.configure(1, 50, 0, 15000);
	this.powerHandler.configurePowerPerdition(2, 1);
    }

    @Override
    public void updateEntity() {
	this.powerHandler.update();
	super.updateEntity();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public PowerReceiver getPowerReceiver(ForgeDirection side) {
	return this.powerHandler.getPowerReceiver();
    }

    @Override
    public void doWork(PowerHandler workProvider) {
	notifyBlockChange();
    }

    @Override
    public World getWorld() {
	return this.worldObj;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	return true;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	this.powerHandler.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.powerHandler.readFromNBT(nbt);
    }

    @Override
    public float getCharge(float charge) {
	float voltage = getVoltage();
	float joules = PowerHelper.getEnergy(charge, voltage) * JOULE_BALANCE;
	float usedEnergy = this.powerHandler.useEnergy(0, joules, true);
	return PowerHelper.getCharge(usedEnergy / JOULE_BALANCE, voltage);
    }

    @Override
    public float getVoltage() {
	float joules = this.powerHandler.getEnergyStored() / JOULE_BALANCE;
	float voltage = (float) Math.sqrt(2 * joules / this.capacitance);
	return voltage;
    }

}
