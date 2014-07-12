package mod.industrialProcessing.gui.binding;

public interface IValueBindingChangedListener {
    void onValueChanged(IValueBinding binding, int oldValue, int newValue);
}
