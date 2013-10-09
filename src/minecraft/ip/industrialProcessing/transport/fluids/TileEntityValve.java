package ip.industrialProcessing.transport.fluids;

import java.util.Arrays;

import org.lwjgl.Sys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityValve extends TileEntityTransportFluidsBase implements IAnimationProgress, IAnimationSyncable, IRotateableEntity {
    private AnimationHandler animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
    private final FluidTank[] tanks = new FluidTank[6];
    private float[] pressures = new float[6];
    private float pressure;
    private FluidTank tank;
    // TODO: add orientation!
    private ForgeDirection frontDirection = ForgeDirection.NORTH;
    private float moveForce;
    private float moveSpeed;

    public TileEntityValve() {
	for (int i = 0; i < 6; i++) {
	    pressures[i] = 0;
	    this.tanks[i] = new FluidTank(1000);
	}
	this.tank = new FluidTank(6000);
	this.tankHandler = new TankHandler(this, new int[] { 0, 1, 2, 3, 4, 5 });
	this.animationHandler.setSpeed(1f);
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (!this.worldObj.isRemote) {
	    int connectionCount = 0;
	    float pressureAverage = 0;
	    for (int i = 0; i < 6; i++) {
		FluidTank sideTank = tanks[i];
		if (states[i] != TransportConnectionState.NONE) {
		    int amount = (int) (sideTank.getFluidAmount() * this.animationHandler.getProgress());
		    if (amount > 0) {
			FluidTransfers.transfer(amount, sideTank, this.tank);
		    }
		    pressureAverage += this.pressures[i];
		    connectionCount++;
		}
	    }
	    if (connectionCount > 0) {
		pressureAverage /= connectionCount;
		int amount = this.tank.getFluidAmount() / connectionCount;
		for (int i = 0; i < 6; i++) {
		    FluidTank sideTank = tanks[i];
		    if (states[i] != TransportConnectionState.NONE) {
			pressures[i] += (pressureAverage - pressures[i]) / 2f;
			FluidTransfers.transfer(amount, this.tank, sideTank);
		    } else {
			sideTank.setFluid(null);
			pressures[i] = 0;
		    }
		}
	    }

	    this.moveForce -= this.moveForce * this.animationHandler.DT * 2;
	    this.moveSpeed += this.moveForce * this.animationHandler.DT;
	    this.moveSpeed -= this.moveSpeed * this.animationHandler.DT * 5;

	    this.animationHandler.setIncrementing(this.moveSpeed > 0);
	    this.animationHandler.setSpeed(Math.abs(moveSpeed));

	    if (this.animationHandler.isIncrementing() && this.animationHandler.getProgress() == 1) {
		this.moveSpeed = 0;
		this.moveForce = 0;
	    }
	    if (!this.animationHandler.isIncrementing() && this.animationHandler.getProgress() == 0) {
		this.moveForce = 0;
		this.moveSpeed = 0;
	    }

	    this.animationHandler.update();
	    TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
	}
    }

    @Override
    protected float getPressure(ForgeDirection direction) {
	float averaged = 0;
	float connections = 0;

	for (int i = 0; i < 6; i++) {
	    if (states[i] != TransportConnectionState.NONE) {
		if (i == direction.ordinal()) {
		    averaged += pressures[i];
		    connections++;
		} else {
		    averaged += pressures[i] * this.animationHandler.getProgress();
		    connections += this.animationHandler.getProgress();
		}
	    }
	}

	return averaged / connections;
    }

    @Override
    protected void addPressure(ForgeDirection direction, float value) {
	float scaled = value * this.animationHandler.getProgress();
	for (int i = 0; i < 6; i++) {
	    if (states[i] != TransportConnectionState.NONE) {
		if (i == direction.ordinal()) {
		    pressures[i] += value;
		} else {
		    pressures[i] += scaled;
		}
	    }
	}
    }

    @Override
    protected IFluidTank getTank(ForgeDirection direction) {
	return tanks[direction.ordinal()];
    }

    @Override
    protected void leakPressure() {
	for (int i = 0; i < pressures.length; i++) {
	    pressures[i] -= pressures[i] * 0.005f;
	}
    }

    @Override
    public int getTankCount() {
	return this.tanks.length;
    }

    @Override
    public FluidTankInfo[] getTanks() {
	FluidTankInfo[] info = new FluidTankInfo[6];
	for (int i = 0; i < tanks.length; i++) {
	    info[i] = this.tanks[i].getInfo();
	}
	return null;
    }

    @Override
    public IFluidTank getTankInSlot(int slot) {
	if (slot >= 0 && slot < this.tanks.length)
	    return this.tanks[slot];
	return null;
    }

    @Override
    protected boolean canConnect(ForgeDirection direction) {
	return direction != frontDirection;
    }

    public void toggleValve() {
	this.animationHandler.setIncrementing(!this.animationHandler.isIncrementing());
    }

    @Override
    public int getAnimationCount() {
	return 1;
    }

    @Override
    public float getAnimationProgress(float scale, int animationIndex) {
	return this.animationHandler.getAnimationProgress(scale);
    }

    @Override
    public AnimationHandler getAnimationHandler() {
	return this.animationHandler;
    }

    public void openValveHit() {
	if (!this.worldObj.isRemote) {
	    this.animationHandler.setIncrementing(true);
	    this.moveForce += 1;
	}
    }

    public void closeValveHit() {
	if (!this.worldObj.isRemote) {
	    this.animationHandler.setIncrementing(false);
	    this.moveForce -= 1;
	}
    }

    public void setForwardDirection(ForgeDirection forwardFromMetadata) {
	this.frontDirection = forwardFromMetadata; // set forward
	this.notifyBlockChange(); //sync nbt
	if(this.worldObj!= null) // notify neighbors
	    this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType().blockID);
    }

    public ForgeDirection getForwardDirection() {
	return this.frontDirection;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
	super.readFromNBT(par1nbtTagCompound);
	this.animationHandler.readFromNBT(par1nbtTagCompound);

	this.tank.readFromNBT(par1nbtTagCompound);
	this.pressure = par1nbtTagCompound.getFloat("Pressure");

	NBTTagList list = par1nbtTagCompound.getTagList("Tanks");
	for (int i = 0; i < list.tagCount(); i++) {
	    NBTTagCompound compound = (NBTTagCompound) list.tagAt(i);
	    this.tanks[i].readFromNBT(compound);
	    this.pressures[i] = compound.getFloat("Pressure");
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
	super.writeToNBT(par1nbtTagCompound);
	this.animationHandler.writeToNBT(par1nbtTagCompound);

	this.tank.writeToNBT(par1nbtTagCompound);
	par1nbtTagCompound.setFloat("Pressure", this.pressure);

	NBTTagList list = new NBTTagList();
	for (int i = 0; i < 6; i++) {
	    NBTTagCompound compound = new NBTTagCompound();
	    this.tanks[i].writeToNBT(compound);
	    this.pressures[i] = compound.getFloat("Pressure");
	    list.appendTag(compound);
	}
	par1nbtTagCompound.setTag("Tanks", list);
    }

    @Override
    public boolean canWrenchRotate() {
	return true;
    }
}
