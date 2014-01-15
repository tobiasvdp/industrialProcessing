package ip.industrialProcessing.power.manualGenerator;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ic2.api.Direction;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.DirectionUtils;

public class TileEntityManualGenerator extends TileEntityPowerGenerator implements IAnimationProgress {
    public TileEntityManualGenerator() {
	super(100);
    }

    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 200;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing

    private float storedPlayerForce = 0; // buffer     private final static LocalDirection outputDirection = LocalDirection.BACK;
    private final static LocalDirection outputDirection = LocalDirection.BACK;
    
    private static final float DRAG = 1.0f;
    private static final float ELECTRIC_DRAG = 0.20f;

    private AnimationHandler animation = new AnimationHandler(AnimationMode.WRAP, 20f, true);

    @Override
    public void updateEntity() { 
	super.updateEntity(); 
 
	this.animation.update();
 

	    float speed = this.animation.getSpeed();
	if (this.storedPlayerForce > 0) {
	    speed += this.storedPlayerForce * this.animation.DT / 20; 
	    this.storedPlayerForce -= this.storedPlayerForce * this.animation.DT;
	}

	speed -= DRAG * speed * this.animation.DT;

	this.animation.setSpeed(speed); 
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setFloat("Force", storedPlayerForce); 
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storedPlayerForce = nbt.getFloat("Force"); 
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
	LocalDirection side = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
	return side == outputDirection;
    }

    @Override
    public float getAnimationProgress(float scale, int index) {
	return this.animation.getAnimationProgress(scale);
    }
    @Override
    public int getAnimationCount() { 
    	return 1;
    }

    @Override
    public float getCharge(float q) {
	// q Coulomb have been used by the network
	float speed = this.animation.getSpeed();
	speed -= q * ELECTRIC_DRAG; // (q = i * dt), so this can be applied directly
	this.animation.setSpeed(speed);
	return q;
    }

    @Override
    public float getVoltage() { 
	return this.animation.getSpeed() * 2;
    }

}
