package ip.industrialProcessing.transport.items.interfaces;

import net.minecraftforge.common.ForgeDirection;

public interface IItemTransport {
	public void setOutputDirection(ForgeDirection dir, boolean isValid);
	public void setInputDirection(ForgeDirection dir, boolean isValid);
	public ForgeDirection[] getOutputDirections();
	public ForgeDirection[] getInputDirections();
	public void updatePath();
}
