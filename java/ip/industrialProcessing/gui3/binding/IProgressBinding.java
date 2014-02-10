package ip.industrialProcessing.gui3.binding;

public interface IProgressBinding extends IBinding {
    void setValue(float value);
    float getValue();
    void setMaxValue(float value);
    float getMaxValue(); 
}
