package ip.industrialProcessing.client.render;

public abstract class ModelConnected extends ModelMachine {
 
    @Override
    public void renderModel(float f) {
	renderModelConnected(f, ConnectionState.PLUGGED, ConnectionState.DISCONNECTED, ConnectionState.CONNECTED, ConnectionState.DISCONNECTED, ConnectionState.DISCONNECTED, ConnectionState.DISCONNECTED);
    }
    
    public abstract void renderModelConnected(float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) ;
}
