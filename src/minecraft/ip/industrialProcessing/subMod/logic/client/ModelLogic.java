package ip.industrialProcessing.subMod.logic.client;

import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;

public abstract class ModelLogic extends ModelMachine {

	public ModelLogic() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f, boolean[] side, boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels);
}
