package ip.industrialProcessing.config;

public class ConfigRenderers {

    private int rendererWireID;
    private int rendererMixerID;
    private int rendererFilterID;
    private int rendererMagneticSeperatorID;
    private int rendererCrusherID;
    private int rendererDiskFilterID;
    private int rendererVoltMeterID;
    private int rendererAmpMeterID;

    public static int getRendererFilterId() {
	return getInstance().rendererFilterID;
    }

    public static void setRendererFilterId(int value) {
	getInstance().rendererFilterID = value;
    }

    public static int getRendererMagneticSeperatorId() {
	return getInstance().rendererMagneticSeperatorID;
    }

    public static void setRendererMagneticSeperatorId(int value) {
	getInstance().rendererMagneticSeperatorID = value;
    }

    public static int getRendererMixerId() {
	return getInstance().rendererMixerID;
    }

    public static void setRendererMixerId(int value) {
	getInstance().rendererMixerID = value;
    }

    public static int getRendererCrusherId() {
	return getInstance().rendererCrusherID;
    }

    public static void setRendererCrusherId(int value) {
	getInstance().rendererCrusherID = value;
    }

    public static int getRendererDiskFilterId() {
	return getInstance().rendererDiskFilterID;
    }

    public static void setRendererDiskFilterIdId(int value) {
	getInstance().rendererDiskFilterID = value;
    }

    public static int getRendererWireId() {
	return getInstance().rendererWireID;
    }

    public static void setRendererWireId(int value) {
	getInstance().rendererWireID = value;
    }

    public static int getRendererVoltMeterId() {
	return getInstance().rendererVoltMeterID;
    }

    public static void setRendererVoltMeterId(int value) {
	getInstance().rendererVoltMeterID = value;
    }
    public static int getRendererAmpMeterId() {
	return getInstance().rendererAmpMeterID;
    }

    public static void setRendererAmpMeterId(int value) {
	getInstance().rendererAmpMeterID = value;
    }
    private ConfigRenderers() {

    }

    private static ConfigRenderers instance = new ConfigRenderers();

    public static ConfigRenderers getInstance() {
	return instance;
    }
}
