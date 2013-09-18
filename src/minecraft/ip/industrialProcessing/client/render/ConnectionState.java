package ip.industrialProcessing.client.render;

public enum ConnectionState {
	CONNECTED, PLUGGED, DISCONNECTED, SUPPORTED;
	public boolean isConnected() {
		return this == CONNECTED || this == PLUGGED;
	}
	
	public boolean isSupported()
	{
		return this == SUPPORTED;
	}
}
