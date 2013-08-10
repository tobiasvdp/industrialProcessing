package ip.industrialProcessing.power.manualGenerator;

import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityManualGenerator extends TileEntityPowerGenerator {
    public TileEntityManualGenerator() {
	super(1000, 10); // can store power for 100 ticks
    }

    // each tick, this amount of mechanical energy is converted to power.
    private static final int DRAIN_RATE = 10;
    // if the player hits, 100 mechanical energy is stored in this generator
    private static final int PLAYER_FORCE_RATE = 100;
    // how much mechanical energy can this generator store, prevents the player
    // from spamming this thing
    private static final int MAX_STORAGE = 1500; // about 15 hits in the face, about 150 ticks to deplete

    int storedPlayerForce = 0; // buffer
    private int currentProduction; // used for animation

    
    
    @Override
    protected int generatePower(int maxGeneration) {
	int produce = Math.min(storedPlayerForce, maxGeneration);
	produce = Math.min(DRAIN_RATE, produce);
	storedPlayerForce -= produce;
	this.currentProduction = produce; 
	return produce;
    }

    public void playerPushed() {
	this.storedPlayerForce += PLAYER_FORCE_RATE;
	if (this.storedPlayerForce > MAX_STORAGE)
	    this.storedPlayerForce = MAX_STORAGE;
    }
}
