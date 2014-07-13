package ip.industrialProcessing.utils.handler.lines;

public interface ILinePart {
	int getLineID();
	int getLineID(int subBlock);
	void setLineID( int id);
	void setLineID(int subBlock, int id);
}
