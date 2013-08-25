package ip.industrialProcessing.power.manualGenerator;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityManualGenerator extends TileEntityPowerGenerator implements IAnimationProgress {
    public TileEntityManualGenerator() {
	super(100);
    }

    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 100;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing

    private float storedPlayerForce = 0; // buffer
    private float rotation;
    private final static LocalDirection outputDirection = LocalDirection.BACK;

    private static final float DRAG = 1.0f;
    private static final float ELECTRIC_DRAG = 0.20f;

    private float speed = 0;

    @Override
    public void updateEntity() { 
	super.updateEntity();
	if (Float.isNaN(this.rotation))
	    this.rotation = 0;

	this.rotation += speed/100f/4;

	float dt = 1 / 20f;

	//System.out.println(this.worldObj.isRemote+" "+this.storedPlayerForce + " " + this.speed + " " + this.rotation);
	if (this.storedPlayerForce > 0) {
	    this.speed += this.storedPlayerForce * dt / 20;
	    this.storedPlayerForce -= this.storedPlayerForce * dt;
	}

	this.speed -= DRAG * this.speed * dt;

	while (rotation > 1)
	    rotation -= 1;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setFloat("Force", storedPlayerForce);
	nbt.setFloat("Speed", speed);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storedPlayerForce = nbt.getFloat("Force");
	this.speed = nbt.getFloat("Speed");
    }

    public void playerPushed() {
	this.storedPlayerForce += PLAYER_FORCE_RATE;
	this.notifyBlockChange();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection side = DirectionUtils.GetLocalDirection(opposite, getForwardDirection());
	return side == outputDirection;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.rotation * scale;
    }

    @Override
    public float getCharge(float q) {
	// q Coulomb have been used by the network
	this.speed -= q * ELECTRIC_DRAG; // (q = i * dt), so this can be applied directly
	return q;
    }

    @Override
    public float getVoltage() { 
	return speed * 2;
    }

}
