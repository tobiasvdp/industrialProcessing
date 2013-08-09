package ip.industrialProcessing.config;

public class ConfigRenderers {

	private int rendererMixerID;
	private int rendererFilterID;
	private int rendererMagneticSeperatorID;
	private int rendererCrusherID;

	public static int getRendererFilterId() {return getInstance().rendererFilterID;}
	public static void setRendererFilterId(int value) {getInstance().rendererFilterID = value;}
	
	public static int getRendererMagneticSeperatorId() {return getInstance().rendererMagneticSeperatorID;}
	public static void setRendererMagneticSeperatorId(int value) {getInstance().rendererMagneticSeperatorID = value;}
	public static int getRendererMixerId() {return getInstance().rendererMixerID;}
	public static void setRendererMixerId(int value) {getInstance().rendererMixerID = value;}
	public static int getRendererCrusherId() {return getInstance().rendererCrusherID;}
	public static void setRendererCrusherId(int value) {getInstance().rendererCrusherID = value;}

	private ConfigRenderers() {

	}

	private static ConfigRenderers instance = new ConfigRenderers();

	public static ConfigRenderers getInstance() {
		return instance;
	} 
}
