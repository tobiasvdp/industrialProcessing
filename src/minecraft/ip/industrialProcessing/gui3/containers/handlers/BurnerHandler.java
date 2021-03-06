package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.utils.handler.fuel.IBurner;

public class BurnerHandler extends ProgressHandlerBase {
    private IBurner burner;

    public BurnerHandler(IBurner burner) {
	super(1);
	this.burner = burner;
    }

    @Override
    public void readFromEntity() {
	int burn = burner.getBurnTime();
	int maxBurn = burner.getMaxBurnTime();
	this.setValues(burn, maxBurn);
    }
}
