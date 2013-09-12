package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.client.render.ModelLogic;

public class MDlogicCable extends ModelLogic {

	public MDlogicCable() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void renderModel(float f, int[] side, boolean[][] notificationLights) {
		for (int i = 0; i < side.length; i++) {
			switch (side[i]) {
			case 0:
				break;
			case 1:
				break;
			}
		}
	}

	@Override
	public void renderModel(float f) {
		// TODO Auto-generated method stub

	}

}
