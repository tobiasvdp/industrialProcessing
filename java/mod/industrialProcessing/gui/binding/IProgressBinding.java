package mod.industrialProcessing.gui.binding;

public interface IProgressBinding extends IBinding {
    void setValue(float value);
    float getValue();
    void setMaxValue(float value);
    float getMaxValue(); 
}
