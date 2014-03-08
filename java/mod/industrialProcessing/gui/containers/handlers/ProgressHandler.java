package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.utils.handlers.numbers.IProgressable;


public class ProgressHandler extends ProgressHandlerBase {

    private IProgressable progressableEntity;
    private int slot;

    public ProgressHandler(int slot, IProgressable progressableEntity) {
	super(100);
	this.slot = slot;
	this.progressableEntity = progressableEntity;
    }

    @Override
    public void readFromEntity() {
	float value = (this.progressableEntity.getProgress(this.slot));
	float maxValue = (this.progressableEntity.getMaxProgress(this.slot));
	this.setValues(value, maxValue);
    }
}
