package ip.industrialProcessing.power.manualGenerator;

import java.util.Iterator;

import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityManualGenerator extends TileEntityPowerGenerator {
    public TileEntityManualGenerator() {
	super(MAX_STORAGE, DRAIN_RATE); // can store power for 100 ticks, drains 100 per tick
    }

    // each tick, this amount of mechanical energy is converted to power.
    private static final int DRAIN_RATE = 100;
    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 1000;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing
    private static final int MAX_STORAGE = 15000; // about 15 hits in the face, about 15 ticks to deplete

    int storedPlayerForce = 0; // buffer
    private int currentProduction; // used for animation
 

    public void playerPushed() {
	this.storedPlayerForce += PLAYER_FORCE_RATE;
	if (this.storedPlayerForce > MAX_STORAGE)
	    this.storedPlayerForce = MAX_STORAGE;
    }
 

    @Override
    public int producePower(int maxAmount) { 
	int produce = Math.min(storedPlayerForce, maxAmount);
	produce = Math.min(DRAIN_RATE, produce);
	storedPlayerForce -= produce;
	this.currentProduction = produce; 
	return produce;
    }
   

    @Override
    protected boolean isValidInput(int slot, int itemID) { 
	return false;
    }
}
