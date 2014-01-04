package ip.industrialProcessing.client.render;

import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;

public abstract class ModelWire extends ModelMachine{

	public ModelWire() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f,int side,int[] connectedSides);
}
