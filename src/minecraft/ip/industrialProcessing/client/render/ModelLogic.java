package ip.industrialProcessing.client.render;

import net.minecraftforge.common.ForgeDirection;

public abstract class ModelLogic extends ModelMachine{

	public ModelLogic() {
		// TODO Auto-generated constructor stub
	}

	public abstract void renderModel(float f,int[] side, boolean[][] notificationLights);
}
