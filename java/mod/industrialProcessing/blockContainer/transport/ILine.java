package mod.industrialProcessing.blockContainer.transport;

import mod.industrialProcessing.utils.rotation.LocalDirection;

public interface ILine {
	int getLineID();
	void setLineID(int ID);
	int isValidLineConnection(LocalDirection localdir, boolean forward);
}
