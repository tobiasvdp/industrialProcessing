package ip.industrialProcessing.gui3.containers.handlers;

import ip.industrialProcessing.gui3.binding.IBinding;
import ip.industrialProcessing.gui3.binding.IBindingSource;

public abstract class BindingHandlerBase<T extends IBinding> extends HandlerBase implements IBindingSource<T> {

    public BindingHandlerBase(int size) {
	super(size);
    }
}
