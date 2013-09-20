package ip.industrialProcessing.transport.items.conveyorBelt;

public enum ConnectionMode {
	INPUT, OUTPUT, DUAL, NONE, INVENTORYINPUT, INVENTORYOUTPUT;
	public boolean canConnect(ConnectionMode other) {
		if (this == INPUT) {
			return other == OUTPUT || other == DUAL;
		} else if (this == OUTPUT) {
			return other == INPUT || other == DUAL;
		}
		return false;
	}
	
	public boolean isOutput(boolean strict)
	{
		return strict ? this == OUTPUT: this == OUTPUT || this == DUAL;
	}
	
	public boolean isInventoryOutput()
	{
		return this == INVENTORYOUTPUT;
	}
}
