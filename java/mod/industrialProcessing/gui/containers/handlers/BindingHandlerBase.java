package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.gui.binding.IBinding;
import mod.industrialProcessing.gui.binding.IBindingSource;

public abstract class BindingHandlerBase<T extends IBinding> extends HandlerBase implements IBindingSource<T> {

    public BindingHandlerBase(int size) {
	super(size);
    }
}
