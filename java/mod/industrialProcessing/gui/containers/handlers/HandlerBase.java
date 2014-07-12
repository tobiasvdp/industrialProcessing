package mod.industrialProcessing.gui.containers.handlers;

import java.util.BitSet;

public abstract class HandlerBase implements IContainerHandler {

    private int[] values;
    private BitSet changed;

    public HandlerBase(int size) {
	this.values = new int[size];
	this.changed = new BitSet(size);
	this.changed.set(0, size - 1, true);
    }

    @Override
    public int getValueCount() {
	return values.length;
    }

    @Override
    public boolean hasChanged(int i) {
	boolean changed = this.changed.get(i);
	return changed;
    }

    @Override
    public int getValue(int i) { 
	return values[i];
    }

    @Override
    public void setValue(int i, int value) {
	this.changed.set(i, values[i] != value);
	this.values[i] = value;
    }

}
