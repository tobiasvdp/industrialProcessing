package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoSimpleHeat;
import ip.industrialProcessing.utils.handler.heat.IHeated;

public class HandlerSimpleHeat implements IHandlerSimpleHeat {

    private IHeated heat;
    private InfoSimpleHeat prevInfo;
    private int offset;

    public HandlerSimpleHeat(IHeated heat) {
	this.heat = heat;
	prevInfo = new InfoSimpleHeat();
    }

    @Override
    public int getValueCount() {
	return 2;
    }

    @Override
    public int getValue(int i) {
	switch (i) {
	case 0:
	    return (int) this.heat.getHeat();
	case 1:
	    return (int) this.heat.getMaxHeat();
	}
	return 0;
    }

    public static InfoSimpleHeat getInfo(IHandlerSimpleHeat handler) {
	InfoSimpleHeat heatInfo = new InfoSimpleHeat();
	heatInfo.heat = handler.getValue(0);
	heatInfo.maxHeat = handler.getValue(1);
	return heatInfo;
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
    }

    @Override
    public int getPrevValue(int i) {
	switch (i) {
	case 0:
	    return prevInfo.heat;
	case 1:
	    return prevInfo.maxHeat;
	}

	return 0;
    }

    @Override
    public void newToOldValues() {
	prevInfo.heat = (int) heat.getHeat();
	prevInfo.maxHeat = (int) heat.getMaxHeat();
    }

    @Override
    public void resetPrevValue() {
	prevInfo = new InfoSimpleHeat();
    }

    @Override
    public GuiLayoutPanelType getPanelType() {
	return GuiLayoutPanelType.heat;
    }
}
