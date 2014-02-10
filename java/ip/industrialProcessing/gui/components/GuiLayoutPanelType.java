package ip.industrialProcessing.gui.components;

public enum GuiLayoutPanelType {
    slotsInput, slotsOutput, slotsSide, slotsInventory, worker, power, tankInput, simpleTankInput, tankOutput, simpleTankOutput, heat, lifespan, simpleHeat, image,singlebutton,spinnerButton, dataview;

    public boolean isTankOutput() {
	return this == tankOutput || this == simpleTankOutput;
    }

    public boolean isTankInput() {
	return this == tankInput || this == simpleTankInput;
    }
}
