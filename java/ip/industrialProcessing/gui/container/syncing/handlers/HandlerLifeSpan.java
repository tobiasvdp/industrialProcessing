package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoLifeSpan;
import ip.industrialProcessing.utils.IBreakable;

public class HandlerLifeSpan implements IHandlerLifeSpan{
	private IBreakable te;
	private InfoLifeSpan prevInfo;
	private int offset;

	public HandlerLifeSpan(IBreakable te) {
		this.te = te;
		prevInfo = new InfoLifeSpan();
	}
	
	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.te.getLifetime();
		case 1:
			return this.te.getTotalLifetime();
		}
		return 0;
	}

	public static InfoLifeSpan getInfo(IHandlerLifeSpan handler)
	{
		InfoLifeSpan lifeSpan = new InfoLifeSpan();
		lifeSpan.lifeTime = handler.getValue(0);
		lifeSpan.maxLifeTime = handler.getValue(1);
		return lifeSpan;
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
			this.te.SetLifeTime(par2);break;
		case 1:
			this.te.SetTotalLifeTime(par2);break;
		}
		prevInfo.lifeTime = te.getLifetime();
		prevInfo.maxLifeTime = te.getTotalLifetime();
	}

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.lifeTime;
		case 1:
		    return prevInfo.maxLifeTime;
		}
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.lifeTime = te.getLifetime();
		prevInfo.maxLifeTime = te.getTotalLifetime();
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoLifeSpan();
	}

	@Override
	public GuiLayoutPanelType getPanelType() {
		return GuiLayoutPanelType.lifespan;
	}
}
