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
    private float lastCharge;

    public TileEntityBuildcraftGenerator() {
	super(100);
	this.powerHandler = new PowerHandler(this, Type.MACHINE);
	this.powerHandler.configure(1, 50, 0, 500);
	this.powerHandler.configurePowerPerdition(2, 1);
    }

    @Override
    public void updateEntity() {
	this.lastCharge = 0;
	this.powerHandler.update();
	super.updateEntity();

	float dt = 1 / 20f;

	float spread = 50f; // 50 frames

	float force = this.powerHandler.useEnergy(this.powerHandler.getEnergyStored() / spread, this.powerHandler.getEnergyStored() / spread, true);

	this.speed += force * dt * 5;

	this.speed -= DRAG * this.speed * this.speed * dt / 100; // Quadratic
								 // Drag:
								 // defines max
								 // speed

	this.rotation += this.speed * dt /11;

	while (rotation > 1)
	    rotation -= 1;

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
	nbt.setFloat("LastCharge", this.lastCharge);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.powerHandler.readFromNBT(nbt);
	this.speed = nbt.getFloat("Speed");
	this.lastCharge = nbt.getFloat("LastCharge");
    }

    @Override
    public float getCharge(float q) {
	// q Coulomb have been used by the network
	this.speed -= q * ELECTRIC_DRAG * 1; // (q = i * dt), so this can be
					     // applied
	this.lastCharge += q; // directly
	return q;
    }

    public float getLastAmps() {
	System.out.println(this.lastCharge+" Coulombs");
	return lastCharge * 20f;
    }

    @Override
    public float getVoltage() {
	// float voltage = this.powerHandler.getEnergyStored()*
	// this.maxOutputVoltage / this.powerHandler.getMaxEnergyStored() ;
	return speed * 2;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.rotation * scale;
    }

}
