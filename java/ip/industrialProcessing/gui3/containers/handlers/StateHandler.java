package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.gui3.binding.IValueBinding;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;

public class StateHandler extends BindingHandlerBase<IValueBinding> {

    private static final int INDEX_MIN = 0;
    private static final int INDEX_MAX = 1;
    private static final int INDEX_VAL = 2;
    private IStateConfig stateEntity;
    private int stateSlot;

    public StateHandler(int slot, IStateConfig stateEntity) {
	super(3);
	this.stateEntity = stateEntity;
	this.stateSlot = slot;
    }

    @Override
    public void readFromEntity() {
	int minValue = stateEntity.getMinStateValue(this.stateSlot);
	int maxValue = stateEntity.getMaxStateValue(this.stateSlot);
	int value = stateEntity.getStateValue(this.stateSlot);

	this.setValue(INDEX_MIN, minValue);
	this.setValue(INDEX_MAX, maxValue);
	this.setValue(INDEX_VAL, value);
    }

    public void updateBinding(IValueBinding binding) {
	binding.setMaxValue(this.getValue(INDEX_MAX));
	binding.setMinValue(this.getValue(INDEX_MIN));
	binding.setValue(this.getValue(INDEX_VAL));
    }
}
