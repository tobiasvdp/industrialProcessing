package ip.industrialProcessing.transport;

import ip.industrialProcessing.client.render.ConnectionState;

public enum TransportConnectionState {
	NONE, OUTPUT, INPUT, DUAL, TRANSPORT, SUPPORTED;

	public ConnectionState getConnectionState() {
		switch (this) {
		case DUAL:
		case OUTPUT:
		case INPUT: 
			return ConnectionState.PLUGGED;
		case TRANSPORT:
			return ConnectionState.CONNECTED;
		case NONE:
		default:
			return ConnectionState.DISCONNECTED;
		}
	}

	public boolean isConnected() {
		return this != NONE && this != SUPPORTED;
	}

	public boolean isSuported() {
		return this == SUPPORTED;
	}

	public boolean isInventory() {
		return this == DUAL || this == OUTPUT || this == INPUT;
	}

	public boolean isInput() {
		return this == DUAL || this == INPUT;
	}

	public boolean isOutput() {
		return this == DUAL || this == OUTPUT;
	}
}
