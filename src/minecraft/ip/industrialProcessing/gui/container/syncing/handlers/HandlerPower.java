package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerPower implements IHandlerPower{
	private IPowerStorage power;
	private InfoPower prevInfo;
	private int offset;

	public HandlerPower(IPowerStorage power) {
		this.power = power;
		prevInfo = new InfoPower();
	}
	
	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.power.getStoredPower();
		case 1:
			return this.power.getPowerCapacity();
		}
		return 0;
	}

	public static InfoPower getInfo(IHandlerPower handler)
	{
		InfoPower powerInfo = new InfoPower();
		powerInfo.storedPower = handler.getValue(0);
		powerInfo.powerCapacity = handler.getValue(1);
		return powerInfo;
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
			this.power.setStoredPower(par2);break;
		case 1:
			this.power.setPowerCapacity(par2);break;
		}
		prevInfo.powerCapacity = power.getPowerCapacity();
		prevInfo.storedPower = power.getStoredPower();
	}

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.storedPower;
		case 1:
		    return prevInfo.powerCapacity;
		}
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.powerCapacity = power.getPowerCapacity();
		prevInfo.storedPower = power.getStoredPower();
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoPower();
	}

	@Override
	public GuiLayoutPanelType getPanelType() {
		return GuiLayoutPanelType.power;
	}
}
