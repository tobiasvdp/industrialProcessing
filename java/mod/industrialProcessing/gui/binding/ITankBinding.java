package mod.industrialProcessing.gui.binding;

public interface ITankBinding extends IBinding {

    void setCapacity(int capacity);
    int getCapacity();
    int getFluidAmount();
    void setFluidAmount(int amount);
    int getFluidID();
    void setFluidID(int fluidId);
}
