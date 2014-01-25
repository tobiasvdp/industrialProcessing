package ip.industrialProcessing.power.storage;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.items.ItemBattery;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.PowerTransfers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

// This isn't an actual battery, as it has input and outputs, so the resistance defined here is the resistance the input network sees this "battery" as
public class TileEntityEnergyCell extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable, IPoweredMachine {

    private int BATTERY_SLOTS = 9;
    private PowerStorageEnergyCell storage;
    private int dischargeSlot;
    private AnimationHandler animationBatteries;
    private int updateSkip = 0;
    private int maxUpdateSkip = 20;

    public TileEntityEnergyCell() {

	this.animation = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
	this.animationBatteries = new AnimationHandler(AnimationMode.CLAMP, 9, false);
	LocalDirection batteryInterfaceSide = null;
	for (int i = 0; i < BATTERY_SLOTS; i++) {
	    addStack(null, batteryInterfaceSide, true, true);
	}
	this.dischargeSlot = addStack(null, batteryInterfaceSide, true, true);
	// battery discharge slot.

	this.storage = new PowerStorageEnergyCell(this, 0, BATTERY_SLOTS);
    }

    private static final LocalDirection inputSide = LocalDirection.FRONT;
    private static final LocalDirection outputSide = LocalDirection.BACK;

    private AnimationHandler animation;

    @Override
    public float getAnimationProgress(float scale, int index) {
	switch (index) {
	case 0:
	default:
	    return this.animation.getAnimationProgress(scale);
	case 1:
	    return this.animationBatteries.getAnimationProgress(scale);
	}
    }

    @Override
    public int getAnimationCount() {
	return 2;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	this.animation.writeToNBT(nbt);
	this.animationBatteries.writeToNBT(nbt);
	this.storage.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storage.readFromNBT(nbt);
	this.animation.readFromNBT(nbt);
	this.animationBatteries.readFromNBT(nbt);
    }

    public float getTotalJouleCapacity() {
	return this.storage.getTotalJouleCapacity();
    }

    public float getStoredJoules() {
	return this.storage.getStoredJoules();
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (updateSkip++ > maxUpdateSkip) {
	    updateSkip = 0;
	    if (!this.worldObj.isRemote) {
		float targetProgress = this.getStoredJoules() / this.getTotalJouleCapacity();
		float speed = (targetProgress - this.animation.getProgress());
		boolean incrementing = true;
		if (speed < 0) {
		    speed = -speed;
		    incrementing = false;
		}
		this.animation.setSpeed(speed);
		this.animation.setIncrementing(incrementing);
		this.animation.update();
		TileAnimationSyncHandler.sendAnimationData(this, this.animation);
		int progress = this.storage.getBatteryCount();
		if (this.animationBatteries.getProgress() != progress) {
		    this.animationBatteries.setProgress(progress);
		    TileAnimationSyncHandler.sendAnimationData(this, this.animationBatteries, 1);
		}
	    } else
		this.animation.update();
	}
	if (!this.worldObj.isRemote) {
	    ItemStack distchargeSlot = getStackInSlot(this.dischargeSlot);
	    if (PowerTransfers.isBattery(distchargeSlot)) {
		PowerTransfers.transfer(distchargeSlot, 10, this.storage);
	    }
	}
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection side = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
	return side == outputSide;
    }

    @Override
    public float getVoltage() {
	return this.getStoredJoules() * 240f / this.getTotalJouleCapacity();
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
	return PowerHelper.getResistanceForStorage(this.getStoredJoules(), this.getTotalJouleCapacity());
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	if (this.getStoredJoules() < this.getTotalJouleCapacity()) {
	    float energy = PowerHelper.getEnergy(coulombs, voltage);

	    addJoules(energy);
	}
    }

    private void addJoules(float energy) {
	if (energy > 0)
	    this.storage.addTotalJoules(energy);
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection input = DirectionUtils.getLocalDirection(side, getForwardDirection());
	return input == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot >= 0 && slot <= BATTERY_SLOTS) {
	    return Item.itemsList[itemID] instanceof ItemBattery;
	}
	return false;
    }

    @Override
    public float getCharge(float amount) {
	float voltage = getVoltage();
	float energy = PowerHelper.getEnergy(amount, voltage);
	float delta = Math.min(energy, this.getStoredJoules());
	if (delta > 0)
	    this.storage.addTotalJoules(-delta);
	return PowerHelper.getCharge(delta, voltage);
    }

    @Override
    public AnimationHandler getAnimationHandler(int index) {
	switch (index) {
	case 1:
	    return this.animationBatteries;
	default:
	    return this.animation;
	}
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
	return this.storage;
    }
}
