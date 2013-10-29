package ip.industrialProcessing.api.handlers;

public interface IHandler {
	int getValueCount();
	
	int getValue(int i);
	int getPrevValue(int i);
	void resetPrevValue();
	
	void newToOldValues();
	
	int getIndexOffset();
	void setIndexOffset(int offset);
	
	void put(int index, int par2);

	
}
