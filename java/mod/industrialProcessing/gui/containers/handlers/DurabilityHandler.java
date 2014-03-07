package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.utils.block.IDurability;

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
