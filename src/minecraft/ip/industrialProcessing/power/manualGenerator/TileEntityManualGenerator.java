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

    // each tick, this amount of mechanical energy is converted to power.
    private static final int DRAIN_RATE = 100;
    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 1000;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing
    private static final int MAX_STORAGE = 15000; // about 15 hits in the face,
						  // about 30 ticks to deplete

    int storedPlayerForce = 0; // buffer
    private int currentProduction; // used for animation
    private float rotation;
    private final static LocalDirection outputDirection = LocalDirection.BACK;

    @Override
    public void updateEntity() {
	if (Float.isNaN(this.rotation))
	    this.rotation = 0; 
	float log = (float) Math.log(this.storedPlayerForce + 1);
	this.rotation += (1 / 360f) * log;
	if (this.rotation > 1)
	    this.rotation--;
	super.updateEntity();

	if (this.storedPlayerForce > 0) {
	    this.storedPlayerForce -= Math.max(1, this.storedPlayerForce / 10);
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("PlrFrc", storedPlayerForce);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	this.storedPlayerForce = nbt.getInteger("PlrFrc");
    }

    public void playerPushed() {
	this.storedPlayerForce += PLAYER_FORCE_RATE;
	if (this.storedPlayerForce > MAX_STORAGE)
	    this.storedPlayerForce = MAX_STORAGE;
	this.notifyBlockChange();
    }

    @Override
    public int producePower(int maxAmount, boolean doProduce) {
	int produce = Math.min(maxAmount, (int) (Math.log(this.storedPlayerForce + 1) * DRAIN_RATE));
	if (doProduce) {
	    this.currentProduction += produce;
	}
	return produce;
    }

    
    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	LocalDirection side = DirectionUtils.GetLocalDirection(opposite, getForwardDirection());
	return side == outputDirection ;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return this.rotation * scale;
    }
 
}
