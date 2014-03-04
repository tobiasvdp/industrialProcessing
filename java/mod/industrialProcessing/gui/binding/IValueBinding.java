package mod.industrialProcessing.gui.binding;

public interface IValueBinding extends IBinding {
    void subscribe(IValueBindingChangedListener listener);
    void unsubscribe(IValueBindingChangedListener listener);
    void setValue(int value);
    void setMaxValue(int maxValue);
    void setMinValue(int minValue);
    int getValue();
}
