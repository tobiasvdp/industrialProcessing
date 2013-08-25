package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBuildcraftGenerator extends TileEntityPowerGenerator implements IPowerReceptor, IAnimationProgress {

    private static final float DRAG = 1.0f;
    private static final float ELECTRIC_DRAG = 0.20f;

    private PowerHandler powerHandler;

    private float speed;

    private float rotation;

    public TileEntityBuildcraftGenerator() {
	super(100);
	this.powerHandler = new PowerHandler(this, Type.MACHINE);
	this.powerHandler.configure(1, 50, 0, 500);
	this.powerHandler.configurePowerPerdition(2, 1);
    }

    @Override
    public void updateEntity() {
	this.powerHandler.update(); 
	super.updateEntity();

	float dt = 1 / 20f;
	
	float spread = 50f; // 50 frames

	float force = this.powerHandler.useEnergy(this.powerHandler.getEnergyStored()/spread, this.powerHandler.getEnergyStored()/spread, true);

	this.speed += force * dt * 5;

	this.speed -= DRAG * this.speed* this.speed * dt / 100; // Quadratic Drag: defines max speed 

	this.rotation += this.speed * dt / 10;
	
	while (rotation > 2 * Math.PI)
	    rotation -= 2 * Math.PI;
	
	notifyBlockChange();
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
	nbt.setFloat("Speed", this.speed);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.powerHandler.readFromNBT(nbt);
	this.speed = nbt.getFloat("Speed");
    }

    @Override
    public float getCharge(float q) {
	// q Coulomb have been used by the network
	this.speed -= q * ELECTRIC_DRAG * 2; // (q = i * dt), so this can be applied
					 // directly
	return q;
    }

    @Override
    public float getVoltage() {
	// float voltage = this.powerHandler.getEnergyStored()*
	// this.maxOutputVoltage / this.powerHandler.getMaxEnergyStored() ;
	return speed;
    }

    @Override
    public float getAnimationProgress(float scale) { 
	return this.rotation * scale;
    }

}
