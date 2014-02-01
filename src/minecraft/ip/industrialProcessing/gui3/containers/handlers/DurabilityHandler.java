package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.utils.IDurability;

public class DurabilityHandler extends ProgressHandlerBase {

    private IDurability breakable;

    public DurabilityHandler(IDurability breakable) {
	super(1);
	this.breakable = breakable;
    }

    @Override
    public void readFromEntity() {
	int damage = this.breakable.getLifetime();
	int total = this.breakable.getTotalLifetime();
	this.setValues(damage, total);
    }
}
