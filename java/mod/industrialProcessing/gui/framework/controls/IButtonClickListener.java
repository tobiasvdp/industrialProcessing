package mod.industrialProcessing.gui.framework.controls;

import mod.industrialProcessing.gui.framework.panels.MouseButton;

public interface IButtonClickListener<T> {
	void buttonClicked(Button<T> button, T tag, float mouseX, float mouseY, MouseButton mouseButton);
}
