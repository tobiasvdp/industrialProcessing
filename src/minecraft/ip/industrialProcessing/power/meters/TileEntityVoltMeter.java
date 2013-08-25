package ip.industrialProcessing.power.meters;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityVoltMeter extends TileEntityMachine implements IPowerAcceptor, IAnimationProgress {

    private LocalDirection inputSide = LocalDirection.BACK;
    private float angle;
    private int producers;
    private float voltage;
    private int inputs;
    private float averageVoltage;

    @Override
    public void updateEntity() {

	if (!this.worldObj.isRemote) {
	    this.averageVoltage = inputs == 0 ? 0 : this.voltage / inputs;
	    this.voltage = 0;
	    this.inputs = 0;
	    notifyBlockChange();
	} 
	this.angle = Math.min(1, averageVoltage / 24f); // MAX Voltage = 24
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.angle;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
	return Float.MAX_VALUE; // 10MΩ
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	// DO nothing with the power, as it should be equal or close to 0
	// Coulomb.
	this.voltage += voltage;
	this.inputs++;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection local = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return local == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	// TODO: input slot for batteries to measure charge
	return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.averageVoltage = nbt.getFloat("Voltage"); 
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setFloat("Voltage", averageVoltage); 
    }
}
