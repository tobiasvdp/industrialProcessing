package ip.industrialProcessing.power.manualGenerator;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityManualGenerator extends TileEntityPowerGenerator {
    public TileEntityManualGenerator() {
	super(100);
    }

    // each tick, this amount of mechanical energy is converted to power.
    private static final int DRAIN_RATE = 500;
    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 1000;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing
    private static final int MAX_STORAGE = 15000; // about 15 hits in the face,
						  // about 30 ticks to deplete

    int storedPlayerForce = 0; // buffer
    private int currentProduction; // used for animation

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
	int produce = Math.min(storedPlayerForce, maxAmount);
	produce = Math.min(DRAIN_RATE, produce);
	if (doProduce) {
	    storedPlayerForce -= produce;
	    this.currentProduction = produce;
	}
	return produce;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public boolean canProducePower(ForgeDirection opposite) {
	return true;
    }
}
