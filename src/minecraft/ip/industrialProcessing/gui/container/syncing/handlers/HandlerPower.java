package ip.industrialProcessing.gui.container.syncing.handlers;

import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.IPowerStorage;

@Deprecated
public class HandlerPower implements IHandlerPower {
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
            return (int) this.power.getStoredPower();
        case 1:
            return (int) this.power.getPowerCapacity();
        }
        return 0;
    }

    public static InfoPower getInfo(IHandlerPower handler) {
        return handler.getInfo();
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
            this.prevInfo.storedPower = par2;
            break;
        case 1:
            this.prevInfo.powerCapacity = par2;
            break;
        }
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
        prevInfo.powerCapacity = (int) power.getPowerCapacity();
        prevInfo.storedPower = (int) power.getStoredPower();
    }

    @Override
    public void resetPrevValue() {
        prevInfo = new InfoPower();
    }

    @Override
    public GuiLayoutPanelType getPanelType() {
        return GuiLayoutPanelType.power;
    }

    @Override
    public InfoPower getInfo() {
        return prevInfo;
    }
}
