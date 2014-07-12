package mod.industrialProcessing.gui.framework.custom;

import java.util.ArrayList;

import mod.industrialProcessing.gui.binding.IValueBinding;
import mod.industrialProcessing.gui.binding.IValueBindingChangedListener;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.ImageTile;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;

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
	public void buttonClicked(Button button, Object tag, float mouseX, float mouseY, MouseButton mouseButton) {
		if (button == this.button) {
			int oldValue = getValue();
			if (mouseButton == MouseButton.LEFT) {
				setValue(oldValue + 1);
			} else if (mouseButton == MouseButton.RIGHT)
				setValue(oldValue - 1);
			int newValue = getValue();
			this.onValueChanged(oldValue, newValue);
		}
	}

	@Override
	public void setValue(int i) {
		if (this.value != i) {
			int range = (maxValue - minValue) + 1;
			i -= minValue;

			while (i < 0)
				i += range;
			i %= range;

			int oldValue = this.value;
			this.value = i + minValue;
			this.tile.index = value;
		}
	}

	@Override
	public int getValue() {
		return this.value;
	}

	private void onValueChanged(int oldValue, int newValue) {
		if (this.value != oldValue) {
			for (IValueBindingChangedListener listener : this.valueChangedListeners) {
				listener.onValueChanged(this, oldValue, newValue);
			}
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
