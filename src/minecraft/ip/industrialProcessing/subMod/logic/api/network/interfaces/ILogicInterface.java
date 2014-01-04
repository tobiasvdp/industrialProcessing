package ip.industrialProcessing.subMod.logic.api.network.interfaces;

import ip.industrialProcessing.subMod.logic.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.utils.UTVariableType;

public interface ILogicInterface {
	public boolean isMachineCapable(InterfaceType type);
	public IMachineInterface getMachine();
	public UTVariable[] getData(UTVariableType type);
}
