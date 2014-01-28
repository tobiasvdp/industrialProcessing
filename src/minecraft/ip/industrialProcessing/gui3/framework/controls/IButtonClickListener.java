package ip.industrialProcessing.gui3.framework.controls;

import ip.industrialProcessing.gui3.framework.panels.MouseButton;

public interface IButtonClickListener {
    void buttonClicked(Button button, float mouseX, float mouseY, MouseButton mouseButton);
}
