package ip.industrialProcessing.transport.items.conveyorBelt;

public enum ConnectionMode {
	INPUT, OUTPUT, DUAL, NONE;
	public boolean canConnect(ConnectionMode other) {
		if (this == INPUT) {
			return other == OUTPUT || other == DUAL;
		} else if (this == OUTPUT) {
			return other == INPUT || other == DUAL;
		}
		return false;
	}
}
