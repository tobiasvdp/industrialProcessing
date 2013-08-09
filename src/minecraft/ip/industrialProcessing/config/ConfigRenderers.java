package ip.industrialProcessing.config;

public class ConfigRenderers {

	private int rendererFilterID;
	private int rendererMagneticSeperatorID;

	public static int getRendererFilterId() {return getInstance().rendererFilterID;}
	public static void setRendererFilterId(int value) {getInstance().rendererFilterID = value;}
	
	public static int getRendererMagneticSeperatorId() {return getInstance().rendererMagneticSeperatorID;}
	public static void setRendererMagneticSeperatorId(int value) {getInstance().rendererMagneticSeperatorID = value;}

	private ConfigRenderers() {

	}

	private static ConfigRenderers instance = new ConfigRenderers();

	public static ConfigRenderers getInstance() {
		return instance;
	}
}
