package mod.industrialProcessing.gui.binding;

import mod.industrialProcessing.gui.containers.handlers.BindingHandlerBase;

public class Binder<T extends IBinding> {
    private BindingHandlerBase<T> source;
    private T target;

    public Binder(BindingHandlerBase<T> source, T target) {
	this.source = source;
	this.target = target;
    }

    public void updateBinding() {
	this.source.updateBinding(target);
    }
}
