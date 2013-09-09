package ip.industrialProcessing.config;

public class ConfigRenderers {

	private static int rendererSolidBurnerId;
	private int rendererCrankGeneratorID;
	private int rendererBCGeneratorID;
	private int rendererWireID;
	private int rendererMixerID;
	private int rendererFilterID;
	private int rendererMagneticSeperatorID;
	private int rendererCrusherID;
	private int rendererDiskFilterID;
	private int rendererVoltMeterID;
	private int rendererAmpMeterID;
	private int rendererTransportFluidID;
	private int rendererEnergyCellID;
	private int rendererBlastFurnaceID;
	private int rendererTankID;
	private int rendererBlockMachineFrameID;
	private int rendererBlockMultiblockInvInputID;
	private int rendererBlockMultiblockInvOutputID;
	private int rendererBlockMultiblockTankInputID;
	private int rendererBlockMultiblockTankOutputID;
	private int rendererBlockMultiblockWeldingStationID;
	private int rendererBlockMultiblockWeldingStationRightID;
	private int rendererBlockMultiblockWeldingStationScreenID;
	private int BLmultiblockWeldingStation;
	private int BLmultiblockScreen;
	private int BLmultiblockFrame;
	private int BLmultiblockWeldingTableExt;
	private int BLmultiblockLiftDoor;
	private int BLmultiblockToggleButton2;
	private int BLmultiblockWheel;
	private int BLmultiblockWheelConnector;
	private int rendererBoilerId;
	private int rendererTurbineId;
	private int rendererManometerId;
	private int BLmultiblockDisplayPanel;

	public static int getBLmultiblockDisplayPanel() {
		return getInstance().BLmultiblockDisplayPanel;
	}
	public static void setBLmultiblockDisplayPanel(int value) {
		getInstance().BLmultiblockDisplayPanel = value;
	}
	public static int getBLmultiblockWheelConnector() {
		return getInstance().BLmultiblockWheelConnector;
	}

	public static void setBLmultiblockWheelConnector(int value) {
		getInstance().BLmultiblockWheelConnector = value;
	}

	public static int getBLmultiblockWheel() {
		return getInstance().BLmultiblockWheel;
	}

	public static void setBLmultiblockWheel(int value) {
		getInstance().BLmultiblockWheel = value;
	}

	public static int getBLmultiblockToggleButton2() {
		return getInstance().BLmultiblockToggleButton2;
	}

	public static void setBLmultiblockToggleButton2(int value) {
		getInstance().BLmultiblockToggleButton2 = value;
	}

	public static int getBLmultiblockLiftDoor() {
		return getInstance().BLmultiblockLiftDoor;
	}

	public static void setBLmultiblockLiftDoor(int value) {
		getInstance().BLmultiblockLiftDoor = value;
	}

	public static int getBLmultiblockWeldingTableExt() {
		return getInstance().BLmultiblockWeldingTableExt;
	}

	public static void setBLmultiblockWeldingTableExt(int value) {
		getInstance().BLmultiblockWeldingTableExt = value;
	}

	public static int getBLmultiblockFrame() {
		return getInstance().BLmultiblockFrame;
	}

	public static void setBLmultiblockFrame(int value) {
		getInstance().BLmultiblockFrame = value;
	}

	public static int getBLmultiblockScreen() {
		return getInstance().BLmultiblockScreen;
	}

	public static void setBLmultiblockScreen(int value) {
		getInstance().BLmultiblockScreen = value;
	}

	public static int getBLmultiblockWeldingStation() {
		return getInstance().BLmultiblockWeldingStation;
	}

	public static void setBLmultiblockWeldingStation(int value) {
		getInstance().BLmultiblockWeldingStation = value;
	}

	public static int getrendererBlockMultiblockWeldingStationScreenID() {
		return getInstance().rendererBlockMultiblockWeldingStationScreenID;
	}

	public static void setrendererBlockMultiblockWeldingStationScreenID(int value) {
		getInstance().rendererBlockMultiblockWeldingStationScreenID = value;
	}

	public static int getrendererBlockMultiblockWeldingStationRightID() {
		return getInstance().rendererBlockMultiblockWeldingStationRightID;
	}

	public static void setrendererBlockMultiblockWeldingStationRightID(int value) {
		getInstance().rendererBlockMultiblockWeldingStationRightID = value;
	}

	public static int getrendererBlockMultiblockWeldingStationID() {
		return getInstance().rendererBlockMultiblockWeldingStationID;
	}

	public static void setrendererBlockMultiblockWeldingStationID(int value) {
		getInstance().rendererBlockMultiblockWeldingStationID = value;
	}

	public static int getrendererBlockMultiblockInvInputID() {
		return getInstance().rendererBlockMultiblockInvInputID;
	}

	public static void setrendererBlockMultiblockInvInputID(int value) {
		getInstance().rendererBlockMultiblockInvInputID = value;
	}

	public static int getrendererBlockMultiblockInvOutputID() {
		return getInstance().rendererBlockMultiblockInvOutputID;
	}

	public static void setrendererBlockMultiblockInvOutputID(int value) {
		getInstance().rendererBlockMultiblockInvOutputID = value;
	}

	public static int getrendererBlockMultiblockTankInputID() {
		return getInstance().rendererBlockMultiblockTankInputID;
	}

	public static void setrendererBlockMultiblockTankInputID(int value) {
		getInstance().rendererBlockMultiblockTankInputID = value;
	}

	public static int getrendererBlockMultiblockTankOutputID() {
		return getInstance().rendererBlockMultiblockTankOutputID;
	}

	public static void setrendererBlockMultiblockTankOutputID(int value) {
		getInstance().rendererBlockMultiblockTankOutputID = value;
	}

	public static int getRendererBlockMachineFrameID() {
		return getInstance().rendererBlockMachineFrameID;
	}

	public static void setRendererBlockMachineFrameID(int value) {
		getInstance().rendererBlockMachineFrameID = value;
	}

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

	public static int getRendererTransportFluidsId() {
		return getInstance().rendererTransportFluidID;
	}

	public static void setRendererTransportFluidsId(int value) {
		getInstance().rendererTransportFluidID = value;
	}

	public static int getRendererTankId() {
		return getInstance().rendererTankID;
	}

	public static void setRendererTankId(int value) {
		getInstance().rendererTankID = value;
	}

	public static int getRendererEnergyCellId() {
		return getInstance().rendererEnergyCellID;
	}

	public static void setRendererEnergyCellId(int value) {
		getInstance().rendererEnergyCellID = value;
	}

	public static int getRendererBlastFurnaceId() {
		return getInstance().rendererBlastFurnaceID;
	}

	public static void setRendererBlastFurnaceId(int value) {
		getInstance().rendererBlastFurnaceID = value;
	}

	public static int getRendererCrankGeneratorId() {
		return getInstance().rendererCrankGeneratorID;
	}

	public static void setRendererCrankGeneratorId(int value) {
		getInstance().rendererCrankGeneratorID = value;
	}

	public static int getRendererBCGeneratorId() {
		return getInstance().rendererBCGeneratorID;
	}

	public static void setRendererBCGeneratorId(int value) {
		getInstance().rendererBCGeneratorID = value;
	}

	public static int getRendererBoilerId() {
		return getInstance().rendererBoilerId;
	}

	public static void setRendererBoilerId(int value) {
		getInstance().rendererBoilerId = value;
	}

	public static int getRendererSolidBurnerId() {
		return getInstance().rendererSolidBurnerId;
	}

	public static void setRendererSolidBurnerId(int value) {
		getInstance().rendererSolidBurnerId = value;
	}

	public static int getRendererTurbineId() {
		return getInstance().rendererTurbineId;
	}

	public static void setRendererTurbineId(int value) {
		getInstance().rendererTurbineId = value;
	}

	public static int getRendererManometerId() {
		return getInstance().rendererManometerId;
	}

	public static void setRendererManometerId(int value) {
		getInstance().rendererManometerId = value;
	}

	private ConfigRenderers() {

	}

	private static ConfigRenderers instance = new ConfigRenderers();

	public static ConfigRenderers getInstance() {
		return instance;
	}

}
