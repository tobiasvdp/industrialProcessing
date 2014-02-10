package ip.industrialProcessing.gui3.binding;

public interface IBindingSource<T extends IBinding> {
    void updateBinding(T binding);
}
