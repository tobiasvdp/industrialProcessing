package mod.industrialProcessing.gui.framework.custom;

import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.controls.GaugeControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;

public class LabeledGauge extends UserControl implements IProgressBinding {

    private GaugeControl gauge;
    private TextBlock label;

    public LabeledGauge(String text, int color, String format) {
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	gauge = GaugeControl.createGauge(text, format);
	stack.addChild(gauge);
	label = new TextBlock(text, color);
	label.horizontalAlign = Alignment.CENTER; 
	stack.addChild(label);
	this.child = stack;
	this.width = Float.NaN;
	this.height = Float.NaN;
	this.verticalAlign = Alignment.MIN;
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) { 
	super.renderOverride(size, renderer);

    }

    @Override
    public void setValue(float value) {
	this.gauge.setValue(value);
    }

    @Override
    public float getValue() {
	return this.gauge.getValue();
    }

    @Override
    public void setMaxValue(float value) {
	this.gauge.setMaxValue(value);
    }

    @Override
    public float getMaxValue() {
	return this.gauge.getMaxValue();
    }

    public static LabeledGauge createLabeledGauge(String label, String format) {
	return new LabeledGauge(label, 4210752, format);
    }
    public static LabeledGauge createLabeledGauge(String label, String format, int color) {
	return new LabeledGauge(label, color, format);
    }
}
