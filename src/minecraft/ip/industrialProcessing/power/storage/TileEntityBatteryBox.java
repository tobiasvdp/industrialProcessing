package ip.industrialProcessing.power.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBatteryBox extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress {

    public TileEntityBatteryBox() {
	super(100);
    }

    private static final LocalDirection inputSide = LocalDirection.FRONT;
    private static final LocalDirection outputSide = LocalDirection.BACK;

    private int storedPower = 0;
    private static final int storageCapacity = 100000;

    @Override
    public void updateEntity() {
	super.updateEntity();
	notifyBlockChange();
    }

    @Override
    public int producePower(int maxAmount, boolean doProduce) {
	int amount = Math.min(maxAmount, this.storedPower);
	if (doProduce)
	    this.storedPower -= amount;
	return amount;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection dir = DirectionUtils.GetLocalDirection(opposite, getForwardDirection());
	return dir == outputSide;
    }

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (canAcceptPower(side)) {
	    int amount = Math.min(maxAmount, storageCapacity - storedPower);
	    if (doAccept)
		this.storedPower += amount;
	    return amount;
	}
	return 0;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	ForgeDirection forward = getForwardDirection();
	LocalDirection dir = DirectionUtils.GetLocalDirection(side, forward);
	return dir == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.storedPower * scale / this.storageCapacity;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("Stored", this.storedPower);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storedPower = nbt.getInteger("Stored");
    }
}
