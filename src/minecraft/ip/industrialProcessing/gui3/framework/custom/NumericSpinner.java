package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui3.binding.IValueBinding;
import ip.industrialProcessing.gui3.binding.IValueBindingChangedListener;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.Image;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

import java.util.ArrayList;

public class NumericSpinner extends UserControl implements IButtonClickListener, IValueBinding {

    private static final Rect ARROW_DOWN_SECTION = new Rect(0, 0.5f, 1, 0.5f);
    private static final Rect ARROW_UP_SECTION = new Rect(0, 0, 1, 0.5f);
    private static final Rect BACKGROUND_SECTION = new Rect(0, 0, 1, 1);
    private static final TextureReference ARROW_TEXTURE = new TextureReference(new Size(11, 14), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Spinner.png");
    private static final TextureReference BACKGROUND_TEXTURE = new TextureReference(new Size(32, 18), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/TextField.png");
    private static final int BACKGROUND_BORDER_WIDTH = 1;

    private ArrayList<IValueBindingChangedListener> valueChangedListeners = new ArrayList<IValueBindingChangedListener>();
    private Button spinUp;
    private Button spinDown;
    private TextBlock textBlock;
    private Decorator textFieldBackground;

    private int minValue = 0;
    private int maxValue = 64;
    private int value = 0;

    public String format = "%.0f";
    public float scale = 1;

    public NumericSpinner(String format, float scale) {
	this.format = format;
	this.scale = scale;
	this.isHittestVisible = true;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	textFieldBackground = new Decorator(BACKGROUND_TEXTURE, BACKGROUND_BORDER_WIDTH, BACKGROUND_SECTION);

	textBlock = new TextBlock("00000", 0xFFFFFFFF);
	textBlock.hasShadow = false;
	textBlock.allowEllipsis = true;
	textBlock.allowWrap = false;
	textBlock.margin = new Thickness(4, 5, 3, 5);
	textBlock.horizontalAlign = Alignment.MAX;
	textFieldBackground.setChild(textBlock);
	stack.addChild(textFieldBackground);
	GridPanel spinGrid = new GridPanel();
	spinGrid.rows.add(new GridSize(9, SizeMode.ABSOLUTE));
	spinGrid.rows.add(new GridSize(9, SizeMode.ABSOLUTE));
	spinGrid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));

	Image arrowDown = Image.createImage(ARROW_TEXTURE, ARROW_DOWN_SECTION);
	Image arrowUp = Image.createImage(ARROW_TEXTURE, ARROW_UP_SECTION);
	arrowUp.margin = arrowDown.margin = new Thickness(1, 3.5f, 1, 3.5f);
	spinUp = new Button(arrowUp);
	spinDown = new Button(arrowDown);

	spinUp.subscribeClick(this);
	spinDown.subscribeClick(this);

	spinGrid.children.add(new GridCell(0, 0, spinUp));
	spinGrid.children.add(new GridCell(1, 0, spinDown));

	stack.addChild(spinGrid);

	this.child = stack;
	this.height = Float.NaN;
	this.width = Float.NaN;
    }

    public static NumericSpinner createSpinner(float textWidth) {
	NumericSpinner spinner = new NumericSpinner("%.0f", 1f);
	spinner.textFieldBackground.minWidth = textWidth;
	spinner.textFieldBackground.maxWidth = textWidth;
	return spinner;
    }

    public static NumericSpinner createSpinner(String format, float scale, float textWidth) {
	NumericSpinner spinner = new NumericSpinner(format, scale);
	spinner.textFieldBackground.minWidth = textWidth;
	spinner.textFieldBackground.maxWidth = textWidth;
	return spinner;
    }

    @Override
    public void buttonClicked(Button button, float mouseX, float mouseY, MouseButton mouseButton) {
	if (button == spinUp) {
	    setValue(getValue() + 1);
	} else if (button == spinDown) {
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
	this.textBlock.text = String.format(this.format, value * this.scale);
	this.onValueChanged(oldValue);
    }

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
