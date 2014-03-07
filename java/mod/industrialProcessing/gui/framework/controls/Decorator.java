package mod.industrialProcessing.gui.framework.controls;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.gui.framework.Rect;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.rendering.GuiRenderer;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;

public class Decorator extends UIElement {

	private static final TextureReference DEFAULT_TEXTURE = new TextureReference(new Size(256, 256), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Background.png");
	private static final TextureReference DEFAULT_TAB_TEXTURE = new TextureReference(new Size(256, 64), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/TabBackground.png");
	private static final TextureReference DEFAULT_EXPANDER_TEXTURE = new TextureReference(new Size(128, 32), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Expander.png");
	private static final Rect DEFAULT_SECTION = new Rect(0, 0, 1, 1);
	private static final Rect DEFAULT_TAB_ACTIVE_SECTION = new Rect(0, 0, 1, 0.5f);
	private static final Rect DEFAULT_TAB_SECTION = new Rect(0, 0.5f, 1, 0.5f);
	private static final int DEFAULT_BORDER_SIZE = 7;
	private static final int DEFAULT_EXPANDER_BORDER_SIZE = 3;
	private UIElement child;
	public int borderWidth;
	private TextureReference texture;
	private Rect section;

	public static Decorator createDecorator() {
		return new Decorator(DEFAULT_TEXTURE, DEFAULT_BORDER_SIZE, DEFAULT_SECTION);
	}

	public static Decorator createExpanderDecorator(boolean active) {
		Decorator decorator = new Decorator(DEFAULT_EXPANDER_TEXTURE, DEFAULT_EXPANDER_BORDER_SIZE, active ? DEFAULT_TAB_ACTIVE_SECTION : DEFAULT_TAB_SECTION);
		return decorator;
	}
	public static Decorator createTabDecorator(boolean active) {
		Decorator decorator = new Decorator(DEFAULT_TAB_TEXTURE, DEFAULT_BORDER_SIZE, active ? DEFAULT_TAB_ACTIVE_SECTION : DEFAULT_TAB_SECTION);
		decorator.margin = new Thickness(active?-3:0, 0, -3, 0);
		return decorator;
	}

	public void setChild(UIElement child) {
		this.child = child;
		if (this.child == null)
			this.isHittestVisible = false;
		else
			this.isHittestVisible = child.isHittestVisible;
	}

	public Decorator(TextureReference texture, int borderWidth, Rect section) {
		this.texture = texture;
		this.borderWidth = borderWidth;
		this.section = section;
	}

	@Override
	protected Size measureOverride(Size maxSize) {
		Size size;
		if (child != null) {
			size = new Size(maxSize.width - borderWidth * 2, maxSize.height - borderWidth * 2);
			size = child.measure(size);
		} else
			size = new Size(0, 0);
		return new Size(size.width + borderWidth * 2, size.height + borderWidth * 2);
	}

	@Override
	protected Size arrangeOverride(Size maxSize) {
		if (child != null) {
			Size size = child.getDesiredSize();
			child.arrange(new Rect(borderWidth, borderWidth, new Size(maxSize.width - borderWidth * 2, maxSize.height - borderWidth * 2)));
			return new Size(size.width + borderWidth * 2, size.height + borderWidth * 2);
		}
		return new Size(borderWidth * 2, borderWidth * 2);
	}

	@Override
	protected void renderOverride(Rect size, GuiRenderer renderer) {
		if (borderWidth > 0)
			renderer.drawNineGrid(size, new Thickness(borderWidth, borderWidth, borderWidth, borderWidth), section, texture);
		else
			renderer.drawTexture(size, section, texture.resource);
		if (child != null)
			child.render(renderer);
	}

	@Override
	protected void mouseUpOverride(float mouseX, float mouseY, MouseButton button) {
		if (child != null)
			child.mouseUp(mouseX, mouseY, button);
	}

	@Override
	protected void mouseDownOverride(float mouseX, float mouseY, MouseButton button) {
		if (child != null)
			child.mouseDown(mouseX, mouseY, button);
	}

	@Override
	protected void mouseLeftOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseLeft(mouseX, mouseY);
	}

	@Override
	protected void mouseEnteredOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseEntered(mouseX, mouseY);
	}

	@Override
	protected void mouseMovedOverride(float mouseX, float mouseY) {
		if (child != null)
			child.mouseMoved(mouseX, mouseY);
	}

	@Override
	protected ToolTip getTooltipOverride(float mouseX, float mouseY) {
		if (child != null)
			return child.getTooltip(mouseX, mouseY);
		return null;
	}

}
