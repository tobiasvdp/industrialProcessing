package ip.industrialProcessing.gui;

public interface IGuiLayoutTriggerAcceptor {

	//buttons
	void triggerButton(int id);
	int getButtonState(int id);
	int setButtonState(int id, int par2);

}
