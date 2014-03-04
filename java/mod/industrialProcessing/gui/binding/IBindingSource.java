package mod.industrialProcessing.gui.binding;

public interface IBindingSource<T extends IBinding> {
    void updateBinding(T binding);
}
