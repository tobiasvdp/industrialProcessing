package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.gui.binding.IProgressBinding;

public abstract class ProgressHandlerBase extends BindingHandlerBase<IProgressBinding> {

    private static final int INDEX_VAL = 0;
    private static final int INDEX_MAX = 1;
    private float scale;

    public ProgressHandlerBase(float scale) {
	super(2);
	this.scale = scale;
    }

    protected void setValues(float value, float maxValue) {
	this.setValue(INDEX_VAL, (int) (value * scale));
	this.setValue(INDEX_MAX, (int) (maxValue * scale));
    }

    protected int getValue() {
	return getValue(INDEX_VAL);
    }

    protected int getMaxValue() {
	return getValue(INDEX_MAX);
    }
    
    @Override
	public void updateBinding(IProgressBinding binding) {
	binding.setValue(getValue() / scale);
	binding.setMaxValue(getMaxValue() / scale);
    }
}
