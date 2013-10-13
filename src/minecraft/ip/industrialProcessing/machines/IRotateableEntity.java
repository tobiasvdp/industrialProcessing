package ip.industrialProcessing.machines;

import net.minecraftforge.common.ForgeDirection;

public interface IRotateableEntity {
	ForgeDirection getForwardDirection();
	void setForwardDirection(ForgeDirection forward); 
	boolean canWrenchRotate();
}