package mod.industrialProcessing.utils.rotation;

import net.minecraftforge.common.util.ForgeDirection;

public interface IRotateableEntity {
	ForgeDirection getForwardDirection();
	void setForwardDirection(ForgeDirection forward); 
	boolean canWrenchRotate();
	LocalDirection getLocalDirection(ForgeDirection dir);
	LocalDirection getLocalDirection(int dir);
	ForgeDirection getExternalDirection(LocalDirection dir);
}