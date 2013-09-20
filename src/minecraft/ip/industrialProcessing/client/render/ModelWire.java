package ip.industrialProcessing.client.render;

import ip.industrialProcessing.logic.utils.UTBuffer;

public abstract class ModelWire extends ModelMachine{

	public ModelWire() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f,int side,int[] connectedSides);
}
