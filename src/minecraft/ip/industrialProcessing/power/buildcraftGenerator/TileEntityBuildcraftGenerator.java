package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBuildcraftGenerator extends TileEntityPowerGenerator implements IPowerReceptor {

    private static final float CONVERSION_RATE = 0.10f; // for every 0.5 BC
						      // Joules, one unit of IP
						      // Power is generated
    private PowerHandler powerHandler;
    private int convertedStored = 0;
    private int convertedCapacity = 10000;

    public TileEntityBuildcraftGenerator() {
	super(100);
	this.powerHandler = new PowerHandler(this, Type.MACHINE);
	this.powerHandler.configure(1, 50, 0, 15000);
	this.powerHandler.configurePowerPerdition(2, 1);
    }

    @Override
    public int producePower(int maxAmount, boolean doProduce) {
	int amount = Math.min(maxAmount, this.convertedStored);
	if (doProduce)
	    this.convertedStored -= amount;
	return amount;
    }

    private int convertEnergy(int maxAmount) {
	float max = maxAmount * CONVERSION_RATE;
	float amount = this.powerHandler.useEnergy(0, max, true);
	return (int) (amount / CONVERSION_RATE);
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
	int produced = convertEnergy(this.convertedCapacity - this.convertedStored);
	if (produced > 0) {
	    this.convertedStored += produced;
	    notifyBlockChange();
	}
    }

    @Override
    public World getWorld() {
	return this.worldObj;
    }

    @Override
    public boolean canProducePower(ForgeDirection opposite) {
	return true;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("Conv", this.convertedStored);
	this.powerHandler.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.convertedStored = nbt.getInteger("Conv");
	this.powerHandler.readFromNBT(nbt);
    }

}
