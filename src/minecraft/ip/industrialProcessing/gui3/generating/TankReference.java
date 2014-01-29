package ip.industrialProcessing.gui3.generating;

class TankReference {
    public TankReference(int slot) {
	this(slot, -1, -1);
    }

    public TankReference(int tankSlot, int inputSlot, int outputSlot) {
	this.tankSlot = tankSlot;
	this.inputSlot = inputSlot;
	this.outputSlot = outputSlot;
    }

    public int tankSlot;
    public int inputSlot;
    public int outputSlot;
    int outputContainerSlot;
    int inputContainerSlot;
    int handlerIndex;
}
