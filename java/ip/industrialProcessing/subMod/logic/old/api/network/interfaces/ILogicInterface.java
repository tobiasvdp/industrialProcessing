package ip.industrialProcessing.subMod.logic.old.api.network.interfaces;

import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariableType;

public interface ILogicInterface {
	public UTVariable[] getData(UTVariableType type);

	public IMachineInterface getMachine();

	public boolean isMachineCapable(InterfaceType type);
}
