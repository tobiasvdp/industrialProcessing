package ip.industrialProcessing.logic.client;

import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.logic.utils.UTBuffer;

public abstract class ModelLogic extends ModelMachine{

	public ModelLogic() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f,boolean[] side,boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels);
}
