package mod.industrialProcessing.transport.items.conveyorBelt.rendering;

import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeState;

public class SlopeCombiner {
	SlopeRenderer[][][][] slopes = new SlopeRenderer[3][2][3][2];

	public SlopeCombiner() {
		for (int f = 0; f < 3; f++) {
			for (int fc = 0; fc < 2; fc++) {
				for (int b = 0; b < 3; b++) {
					for (int bc = 0; bc < 2; bc++) {
						slopes[f][fc][b][bc] = createSlope(SlopeState.VALID_STATES[f], fc == 1, SlopeState.VALID_STATES[b], bc == 1);
					}
				}
			}
		}
	}

	private SlopeRenderer createSlope(SlopeState front, boolean frontConnected, SlopeState back, boolean backConnected) {

		float endHeight = -(front.ordinal() - 1) / 2f;
		float startHeight = -(back.ordinal() - 1) / 2f;
		float midHeight = 0;

		float startNormalAngle = 3.14159265359f * (startHeight) / 2f;
		float endNormalAngle = 3.14159265359f * (-endHeight) / 2f;

		float marginStart = backConnected ? 0 : 4 / 16f;
		float marginEnd = frontConnected ? 0 : 4 / 16f;

		return new SlopeRenderer(16, startHeight, midHeight, endHeight, startNormalAngle, endNormalAngle, marginStart, marginEnd, true, true);
	}

	public SlopeRenderer getRenderer(SlopeState front, boolean frontConnected, SlopeState back, boolean backConnected) {
		return slopes[front.ordinal()][frontConnected ? 1 : 0][back.ordinal()][backConnected ? 1 : 0];
	}
}
