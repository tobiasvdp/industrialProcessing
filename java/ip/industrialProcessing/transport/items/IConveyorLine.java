package ip.industrialProcessing.transport.items;

import ip.industrialProcessing.LocalDirection;

public interface IConveyorLine {
	int getConveyorLineID();
	void setConveyorLineID(int ID);
	int isValidLineConnection(LocalDirection localdir, boolean forward);
}
