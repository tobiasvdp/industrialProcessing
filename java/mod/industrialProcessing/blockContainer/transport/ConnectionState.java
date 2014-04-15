package mod.industrialProcessing.blockContainer.transport;

public enum ConnectionState {
	CONNECTED, PLUGGED, DISCONNECTED, SUPPORTED;
	public boolean isConnected() {
		return this == CONNECTED || this == PLUGGED;
	}
	
	public boolean isSupported()
	{
		return this == SUPPORTED;
	}
	public boolean isPlugged()
	{
		return this == PLUGGED;
	}
}
