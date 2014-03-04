package mod.industrialProcessing.gui.framework.controls;

import ip.industrialProcessing.gui3.framework.panels.MouseButton;

public interface IButtonClickListener<T> {
    void buttonClicked(Button<T> button, T tag, float mouseX, float mouseY, MouseButton mouseButton);
}
