package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.controls.GaugeControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

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
