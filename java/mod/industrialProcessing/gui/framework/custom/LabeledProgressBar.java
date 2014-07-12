package mod.industrialProcessing.gui.framework.custom;

import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

public class LabeledProgressBar extends UserControl implements IProgressBinding {
	private TextBlock label;
	private ProgressBar progressBar;
	private TextBlock valueLabel;
	private String valueFormat;
	private float valueDisplayScale;

	public LabeledProgressBar(String text, int color, String value, float valueDisplayScale) {
		StackPanel panel = new StackPanel();
		panel.orientation = Orientation.HORIZONTAL;
		label = new TextBlock(text, color);
		label.horizontalAlign = Alignment.MAX;
		label.width = 54;
		label.margin = new Thickness(1, 0, 0, 0);
		panel.addChild(label);

		progressBar = ProgressBar.createHorizontal2(); 
		progressBar.margin = new Thickness(0, 0, 1, 0);
		panel.addChild(progressBar);
		if (value != null) {
			this.valueFormat = value;
			this.valueDisplayScale = valueDisplayScale;
			valueLabel = new TextBlock("", color);
			valueLabel.horizontalAlign = Alignment.STRETCH;
			valueLabel.margin = new Thickness(1, 0, 0, 5);
			panel.addChild(valueLabel);
			this.updateValueLabel();
		}
		this.width = Float.NaN;
		this.height = Float.NaN;
		this.child = panel;
	}

	@Override
	protected void renderOverride(Rect size, GuiRenderer renderer) { 
		super.renderOverride(size, renderer);
	}

	public static LabeledProgressBar createProgressBar(String text, int color) {
		return new LabeledProgressBar(text, color, "%.0f/%.0f%%", 100f);
	}

	public static LabeledProgressBar createProgressBar(String text, int color, String format) {
		return new LabeledProgressBar(text, color, format, 1f);
	}

	public static LabeledProgressBar createProgressBar(String text, int color, String format, float formatScale) {
		return new LabeledProgressBar(text, color, format, formatScale);
	}

	@Override
	public void setValue(float value) {
		this.progressBar.value = value;
		this.updateValueLabel();
	}

	private void updateValueLabel() {
		if (this.valueLabel != null && this.valueFormat != null) {
			this.valueLabel.text = String.format(valueFormat, this.progressBar.value * valueDisplayScale, this.progressBar.maxValue * valueDisplayScale);
		}
	}

	@Override
	public float getValue() {
		return this.progressBar.value;
	}

	@Override
	public void setMaxValue(float value) {
		this.progressBar.maxValue = value;
		this.updateValueLabel();
	}

	@Override
	public float getMaxValue() {
		return this.progressBar.maxValue;
	}
}
