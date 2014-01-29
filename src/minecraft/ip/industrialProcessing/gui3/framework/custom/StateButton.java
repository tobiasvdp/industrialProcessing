package ip.industrialProcessing.gui3.framework.custom;

import java.util.ArrayList;

import ip.industrialProcessing.gui3.binding.IValueBinding;
import ip.industrialProcessing.gui3.binding.IValueBindingChangedListener;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.ImageTile;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class StateButton extends UserControl implements IButtonClickListener, IValueBinding {

    private ImageTile tile;
    private Button button;
    private int minValue = 0;
    private int maxValue = 3;
    private int value;
    private ArrayList<IValueBindingChangedListener> valueChangedListeners = new ArrayList<IValueBindingChangedListener>();

    public StateButton(TextureReference texture, int rows, int columns, String[] names) {
	this.width = Float.NaN;
	this.height = Float.NaN;
	this.isHittestVisible = true;
	tile = new ImageTile(texture, rows, columns, names);
	tile.margin = new Thickness(1, 1, 1, 1);
	button = new Button(tile);
	button.subscribeClick(this);
	this.child = button;
    }

    @Override
    public void buttonClicked(Button button, float mouseX, float mouseY, MouseButton mouseButton) {
	if (button == this.button) {
	    if (mouseButton == MouseButton.LEFT) {
		setValue(getValue() + 1);
	    } else if (mouseButton == MouseButton.RIGHT)
		setValue(getValue() - 1);
	}
    }

    public void setValue(int i) {
	int range = (maxValue - minValue) + 1;
	i -= minValue;

	while (i < 0)
	    i += range;
	i %= range;

	int oldValue = this.value;
	this.value = i + minValue;
	this.tile.index = value;
	this.onValueChanged(oldValue);
    }

    @Override
    public int getValue() {
	return this.value;
    }

    private void onValueChanged(int oldValue) {
	for (IValueBindingChangedListener listener : this.valueChangedListeners) {
	    listener.onValueChanged(this, oldValue, this.value);
	}
    }

    @Override
    public void subscribe(IValueBindingChangedListener listener) {
	this.valueChangedListeners.add(listener);
    }

    @Override
    public void unsubscribe(IValueBindingChangedListener listener) {
	this.valueChangedListeners.remove(listener);
    }

    @Override
    public void setMaxValue(int maxValue) {
	this.maxValue = maxValue;
    }

    @Override
    public void setMinValue(int minValue) {
	this.minValue = minValue;
    }
}
