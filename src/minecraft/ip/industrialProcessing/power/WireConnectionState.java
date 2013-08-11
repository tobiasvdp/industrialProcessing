package ip.industrialProcessing.power;

import ip.industrialProcessing.client.render.ConnectionState;

public enum WireConnectionState {
    INPUT, OUTPUT, WIRE, NONE;

    public ConnectionState getConnectionState() {
	switch (this) {
	case OUTPUT:
	case INPUT:
	    return ConnectionState.PLUGGED;
	case WIRE:
	    return ConnectionState.CONNECTED;
	case NONE:
	default:
	    return ConnectionState.DISCONNECTED;
	}
    }
}
