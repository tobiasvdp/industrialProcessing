package ip.industrialProcessing.subMod.logic.api.network.interfaces;

import ip.industrialProcessing.subMod.logic.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.utils.UTVariableType;

public interface ILogicInterface {
	public UTVariable[] getData(UTVariableType type);

	public IMachineInterface getMachine();

	public boolean isMachineCapable(InterfaceType type);
}
