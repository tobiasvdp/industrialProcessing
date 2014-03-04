package mod.industrialProcessing.gui.framework.panels.canvas;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui3.framework.Rect;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.rendering.GuiRenderer;

import java.util.ArrayList;

public class CanvasPanel extends UIElement {

    public ArrayList<CanvasChild> children = new ArrayList<CanvasChild>();
    
    
    @Override
    protected Size measureOverride(Size maxSize) {

        float maxWidth = 0;
        float maxHeight = 0;

        for (CanvasChild canvasChild : children) {
            if (canvasChild.content != null) {
                Size size = canvasChild.content.measure(new Size(maxSize.width - canvasChild.left, maxSize.height - canvasChild.top));
                float width = size.width + canvasChild.left;
                float height = size.height + canvasChild.top;
                if (width > maxWidth)
                    maxWidth = width;
                if (height > maxHeight)
                    maxHeight = height;
            }
        }

        return new Size(maxWidth, maxHeight);
    }

    @Override
    protected Size arrangeOverride(Size maxSize) {

        float maxWidth = 0;
        float maxHeight = 0;

        for (CanvasChild canvasChild : children) {
            if (canvasChild.content != null) {
                Size size = canvasChild.content.getDesiredSize();
                canvasChild.content.arrange(new Rect(canvasChild.left, canvasChild.top, size));
                size.width += canvasChild.left;
                size.height += canvasChild.top;
                if (size.width > maxWidth)
                    maxWidth = size.width;
                if (size.height > maxHeight)
                    maxHeight = size.height;
            }
        }
        return new Size(maxWidth, maxHeight);
    }

    @Override
    protected void renderOverride(Rect size, GuiRenderer renderer) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.render(renderer);
        }
    }

    @Override
    protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.mouseDown(mouseX, mouseY, button);
        }
    }

    @Override
    protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.mouseUp(mouseX, mouseY, button);
        }
    }

    @Override
    protected void mouseMovedOverride(float mouseX, float mouseY) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.mouseMoved(mouseX, mouseY);
        }
    }

    @Override
    protected void mouseLeftOverride(float mouseX, float mouseY) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.mouseLeft(mouseX, mouseY);
        }
    }

    @Override
    protected void mouseEnteredOverride(float mouseX, float mouseY) {
        for (CanvasChild child : children) {
            if (child.content != null)
                child.content.mouseEntered(mouseX, mouseY);
        }
    }

    @Override
    protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
        for (CanvasChild child : children) {
            if (child.content != null) {
                ToolTip toolTip = child.content.getTooltip(mouseX, mouseY);
                if (toolTip != null)
                    return toolTip;
            }
        }
        return null;
    }

}
