package ip.industrialProcessing.gui3.framework.panels;

import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;

import java.util.ArrayList;

public class LayerPanel extends Panel {
 

    @Override
    protected Size measureOverride(Size maxSize) {

	float minWidth = 0;
	float minHeight = 0;
	for (UIElement child : getChildren()) {
	    Size size = child.measure(maxSize);
	    if (size.width > minWidth)
		minWidth = size.width;
	    if (size.height > minHeight)
		minHeight = size.height;

	}

	return new Size(minWidth, minHeight);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {
	for (UIElement child : getChildren()) {
	    child.arrange(new Rect(0, 0, maxSize));
	}
	return maxSize;
    }

}
