package ip.industrialProcessing.api.handlers;

public interface IHandler {
	int getValueCount();
	int getValue(int i);
	boolean hasChanged(int i);
	int[] getValueStorage();
	int getIndexOffset();
	void setIndexOffset(int offset);
	void put(int index, int par2);
}
