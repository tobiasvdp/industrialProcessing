package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.IGuiLayoutTriggerAcceptor;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoDataView;

public class HandlerDataView implements IHandlerDataView{
	private IGuiLayoutTriggerAcceptor trigger;
	private int id;
	private InfoDataView prevInfo;
	private int offset;

	public HandlerDataView(IGuiLayoutTriggerAcceptor trigger,int id) {
		this.trigger = trigger;
		this.id = id;
		prevInfo = new InfoDataView();
	}
	
	@Override
	public int getValueCount() {
		return 1;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.trigger.getDataViewState(id);
		}
		return 0;
	}

	public static InfoDataView getInfo(IHandlerDataView handler)
	{
		InfoDataView buttonInfo = new InfoDataView();
		buttonInfo.state = handler.getValue(0);
		return buttonInfo;
	}

	@Override
	public int getIndexOffset() {
	    return this.offset;
	}

	@Override
	public void setIndexOffset(int offset) {
	    this.offset = offset;
	}

	@Override
	public void put(int index, int par2) {
		switch (index) {
		case 0:
			this.trigger.setDataViewState(id,par2);break;
		}
		prevInfo.state = trigger.getDataViewState(id);
	}

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.state;
		}
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.state = trigger.getDataViewState(id);
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoDataView();
	}

	@Override
	public GuiLayoutPanelType getPanelType() {
		return GuiLayoutPanelType.dataview;
	}
}
