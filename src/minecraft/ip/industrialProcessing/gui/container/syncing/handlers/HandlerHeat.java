package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoHeat;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.handler.heat.IHeatStorage;

public class HandlerHeat implements IHandlerHeat{
	private IHeatStorage heat;
	private InfoHeat prevInfo;
	private int offset;

	public HandlerHeat(IHeatStorage heat) {
		this.heat = heat;
		prevInfo = new InfoHeat();
	}
	
	@Override
	public int getValueCount() {
		return 5;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.heat.getBurnTime();
		case 1:
			return this.heat.getMaxBurnTime();
		case 2:
			return (int) this.heat.getHeat();
		case 3:
			return (int) this.heat.getHeatFuel();
		case 4:
			return (int) this.heat.getMaxHeat();
		}
		return 0;
	}

	public static InfoHeat getInfo(IHandlerHeat handler)
	{
		InfoHeat heatInfo = new InfoHeat();
		heatInfo.burnTime = handler.getValue(0);
		heatInfo.maxBurnTime = handler.getValue(1);
		heatInfo.heat = handler.getValue(2);
		heatInfo.heatFuel = handler.getValue(3);
		heatInfo.maxHeat = handler.getValue(4);
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
		switch (index) {
		case 0:
			this.heat.setBurnTime(par2);break;
		case 1:
			this.heat.setMaxBurnTime(par2);break;
		case 2:
			this.heat.setHeat(par2);break;
		case 3:
			this.heat.setHeatFuel(par2);break;
		}
		prevInfo.burnTime = heat.getBurnTime();
		prevInfo.maxBurnTime = heat.getMaxBurnTime();
		prevInfo.heat = (int) heat.getHeat();
		prevInfo.heatFuel = (int) heat.getHeatFuel();
		prevInfo.maxHeat = (int) heat.getMaxHeat();
	}

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.burnTime;
		case 1:
		    return prevInfo.maxBurnTime;
		case 2:
		    return prevInfo.heat;
		case 3:
		    return prevInfo.heatFuel;
		case 4:
		    return prevInfo.maxHeat;
		}
		
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.burnTime = heat.getBurnTime();
		prevInfo.maxBurnTime = heat.getMaxBurnTime();
		prevInfo.heat = (int) heat.getHeat();
		prevInfo.heatFuel = (int) heat.getHeatFuel();
		prevInfo.maxHeat = (int) heat.getMaxHeat();
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoHeat();
	}

	@Override
	public GuiLayoutPanelType getPanelType() {
		return GuiLayoutPanelType.heat;
	}
}
