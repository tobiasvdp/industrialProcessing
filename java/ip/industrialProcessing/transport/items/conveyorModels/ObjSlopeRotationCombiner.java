package ip.industrialProcessing.transport.items.conveyorModels;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;

public class ObjSlopeRotationCombiner {
	ObjRotator[][] slopes = new ObjRotator[3][3];

	public ObjSlopeRotationCombiner() {
		for (int f = 0; f < 3; f++) {
			for (int b = 0; b < 3; b++) {
				slopes[f][b] = createSlope(SlopeState.VALID_STATES[f], SlopeState.VALID_STATES[b]);
			}
		}
	}

	private ObjRotator createSlope(SlopeState front, SlopeState back) {
		int offset = 0;
		ObjMesh mesh = null;
		if (front == SlopeState.UP) {
			if (back == SlopeState.DOWN)
				mesh = new BackDownFrontUp001();
			else
				mesh = new BackFlatFrontUp001();
		} else if (front == SlopeState.DOWN) {
			if (back == SlopeState.UP) {
				mesh = new BackUpFrontDown001();
			} else {
				mesh = new BackFlatFrontDown001();
			}
		} else {
			if (back == SlopeState.UP) {
				mesh = new BackUpFrontFlat001();
			} else if (back == SlopeState.DOWN) {
				mesh = new BackDownFrontFlat001();
			} else {
				mesh = new Straight001();
			}
		}
		return new ObjRotator(mesh, 0);
	}

	public ObjRotator getRenderer(SlopeState front, SlopeState back) {
		return slopes[front.ordinal()][back.ordinal()];
	}
}
