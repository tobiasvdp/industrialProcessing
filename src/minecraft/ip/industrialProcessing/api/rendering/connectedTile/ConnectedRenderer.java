package ip.industrialProcessing.api.rendering.connectedTile;

public abstract class ConnectedRenderer {
	public void renderConnected(ConnectionCompass compass) {
		renderCenter(compass); 
		renderN(compass, compass.connectionN);
		renderNE(compass, compass.connectionNE);
		renderE(compass, compass.connectionE);
		renderSE(compass, compass.connectionSE);
		renderS(compass, compass.connectionS);
		renderSW(compass, compass.connectionSW);
		renderW(compass, compass.connectionW);
		renderNW(compass, compass.connectionNW);
	}

	protected abstract void renderCenter(ConnectionCompass compass);

	protected abstract void renderN(ConnectionCompass compass, boolean connected);

	protected abstract void renderNE(ConnectionCompass compass, boolean connected);

	protected abstract void renderE(ConnectionCompass compass, boolean connected);

	protected abstract void renderSE(ConnectionCompass compass, boolean connected);

	protected abstract void renderS(ConnectionCompass compass, boolean connected);

	protected abstract void renderSW(ConnectionCompass compass, boolean connected);

	protected abstract void renderW(ConnectionCompass compass, boolean connected);

	protected abstract void renderNW(ConnectionCompass compass, boolean connected);
}