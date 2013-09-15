package ip.industrialProcessing.client.render;

import ip.industrialProcessing.logic.utils.UTBuffer;
import net.minecraftforge.common.ForgeDirection;

public abstract class ModelLogic extends ModelMachine{

	public ModelLogic() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f,boolean[] side,boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels);
}
