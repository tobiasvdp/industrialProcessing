package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.utils.handler.heat.IHeated;

public class HeatedHandler extends ProgressHandlerBase {
    private IHeated heatedEntity;

    public HeatedHandler(IHeated heatedEntity) {
	super(100);
	this.heatedEntity = heatedEntity;
    }

    @Override
    public void readFromEntity() {
	float maxHeat = (this.heatedEntity.getMaxHeat());
	float heat = (this.heatedEntity.getHeat());
	setValues(heat, maxHeat);
    }

}
