package ip.industrialProcessing.subMod.logic.api.network.interfaces;

public interface IMachineInterface {
	public InterfaceType[] getConnectionTypes();

	public String getName();

	public StatusType getStatus();
}
