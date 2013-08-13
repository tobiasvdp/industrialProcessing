package ip.industrialProcessing.transport;

import ip.industrialProcessing.client.render.ConnectionState;

public enum TransportConnectionState {
    NONE, OUTPUT, INPUT, DUAL, TRANSPORT;

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
}
