package ip.industrialProcessing.logic.api.network.interfaces;

import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;

public interface ILogicInterface {
	public boolean isMachineCapable(InterfaceType type);
	public IMachineInterface getMachine();
	public UTVariable[] getData(UTVariableType type);
}
