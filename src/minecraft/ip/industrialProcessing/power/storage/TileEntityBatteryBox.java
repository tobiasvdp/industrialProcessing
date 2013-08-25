package ip.industrialProcessing.power.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.IPowerProducer;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

// This isn't an actual battery, as it has input and outputs, so the resistance defined here is the resistance the input network sees this "battery" as
public class TileEntityBatteryBox extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress {

    public TileEntityBatteryBox() {
	super(100);
    }

    private static final LocalDirection inputSide = LocalDirection.FRONT;
    private static final LocalDirection outputSide = LocalDirection.BACK;

    private float charge = 0;
    private float capacitance = 1000; 
 

    @Override
    public float getAnimationProgress(float scale) {
	return this.getVoltage() * scale * 24f;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setFloat("Charge", this.charge);
	nbt.setFloat("Capacity", this.capacitance);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.charge = nbt.getFloat("Charge");
	this.capacitance = nbt.getFloat("Capacity");
    }
    
    @Override
    public void updateEntity() {
        System.out.println("Charge"+this.charge+" "+this.worldObj.isRemote);
        super.updateEntity();
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection side = DirectionUtils.GetLocalDirection(opposite, getForwardDirection());
	return side == outputSide;
    }

    @Override
    public float getVoltage() {
	return this.charge / this.capacitance;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {  
	float storedVoltage = this.getVoltage();
	return PowerHelper.getResistanceForStorage(voltage, storedVoltage+1);
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	this.charge += coulombs;
	notifyBlockChange();
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection input = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return input == inputSide;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public float getCharge(float amount) {
	float delta = Math.min(amount, this.charge);
	this.charge -= delta;  
	return delta;
    } 
}
