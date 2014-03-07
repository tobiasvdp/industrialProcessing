package mod.industrialProcessing.gui.framework.controls;

import java.util.ArrayList;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;

import org.lwjgl.opengl.GL11;

public class Button<T> extends UIElement {

	private ArrayList<IButtonClickListener<T>> clickEventHandlers = new ArrayList<IButtonClickListener<T>>();

	public void subscribeClick(IButtonClickListener<T> listener) {
		this.clickEventHandlers.add(listener);
	}

	public void unssubscribeClick(IButtonClickListener<T> listener) {
		this.clickEventHandlers.remove(listener);
	}

	private static TextureReference DEFAULT_BUTTON_TEXTURE = new TextureReference(new Size(200, 60), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Buttons.png");

	private TextureReference texture;
	public T tag;
	public Button(UIElement child) {
		this(DEFAULT_BUTTON_TEXTURE, child, null);
	} 
	public Button(UIElement child, T tag) {
		this(DEFAULT_BUTTON_TEXTURE, child, tag);
	} 
	// texture size: 128x32 for each state: 128x96
	public Button(TextureReference texture, UIElement child, T tag) {
		this.isHittestVisible = true;
		this.texture = texture;
		this.child = child;
		this.tag = tag;
	}

	public UIElement child;

	boolean hover = false;
	boolean mouseDown = false;

	@Override
	protected void renderOverride(Rect size, GuiRenderer renderer) {
		if (hover || mouseDown) {
			if (mouseDown) {
				drawButton(size, 1, renderer);
			} else {
				drawButton(size, 2, renderer);
			}
		} else {
			drawButton(size, 0, renderer);
		}
		GL11.glPushMatrix();
		if (mouseDown)
			GL11.glTranslatef(0.5f, 0.5f, 0);
		if (this.child != null)
			this.child.render(renderer);
		GL11.glPopMatrix();
	}

	private void drawButton(Rect rect, int i, GuiRenderer renderer) {
		float uMin = 0;
		float vMin = i / 3f;
		float uSize = 1;
		float vSize = 1 / 3f;

		float cornerSize = 4;
		renderer.drawNineGrid(rect, new Thickness(cornerSize, cornerSize, cornerSize, cornerSize), new Rect(uMin, vMin, uSize, vSize), this.texture);
	}

	@Override
	protected Size measureOverride(Size maxSize) {
		if (child != null)
			return child.measure(maxSize);
		return new Size(0, 0);
	}

	@Override
	protected Size arrangeOverride(Size maxSize) {
		if (child != null) {
			Size size = child.getDesiredSize();
			child.arrange(new Rect(0, 0, maxSize));
			return size;
		}
		return new Size(0, 0);
	}

	@Override
	protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
		if (this.mouseDown) {
			this.mouseDown = false;
			for (IButtonClickListener listener : this.clickEventHandlers) {
				listener.buttonClicked(this, tag, mouseX, mouseY, button);
			}
		}
	}

	@Override
	protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
		if (this.hover) {
			this.mouseDown = true;
		}
	}

	@Override
	protected void mouseLeftOverride(float mouseX, float mouseY) {
		this.hover = false;
		this.mouseDown = false;
	}

	@Override
	protected void mouseEnteredOverride(float mouseX, float mouseY) {
		this.hover = true;
	}

	@Override
	protected void mouseMovedOverride(float mouseX, float mouseY) {
	}

	@Override
	protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
		if (child != null)
			return child.getTooltip(mouseX, mouseY);
		return null;
	}  
}
