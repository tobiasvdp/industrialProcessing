package ip.industrialProcessing.config;

public class ConfigRenderers {

	private int rendererFilterID;

	public static int getRendererFilterId() {
		return getInstance().rendererFilterID;
	}

	public static void setRendererFilterId(int value) {
		getInstance().rendererFilterID = value;
	}

	private ConfigRenderers() {

	}

	private static ConfigRenderers instance = new ConfigRenderers();

	public static ConfigRenderers getInstance() {
		return instance;
	}
}
