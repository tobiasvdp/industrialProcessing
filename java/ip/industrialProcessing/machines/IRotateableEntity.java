package ip.industrialProcessing.machines;

import net.minecraftforge.common.util.ForgeDirection;

public interface IRotateableEntity {
	ForgeDirection getForwardDirection();
	void setForwardDirection(ForgeDirection forward); 
	boolean canWrenchRotate();
}