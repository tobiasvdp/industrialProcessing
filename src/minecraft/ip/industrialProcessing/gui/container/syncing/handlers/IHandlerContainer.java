package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;

public interface IHandlerContainer {
	int getValueCount();
	
	int getValue(int i);
	int getPrevValue(int i);
	void resetPrevValue();
	
	void newToOldValues();
	
	int getIndexOffset();
	void setIndexOffset(int offset);
	
	void put(int index, int par2);
	
	GuiLayoutPanelType getPanelType();

	
}
