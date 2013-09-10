package ip.industrialProcessing.transport.items.interfaces;

import net.minecraftforge.common.ForgeDirection;

public interface IItemTransport {
	public void setOutputDirection();
	public void setInputsDirection();
	public ForgeDirection getOutputDirection();
	public ForgeDirection[] getInputDirections();
}
