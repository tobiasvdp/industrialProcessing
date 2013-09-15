package ip.industrialProcessing.logic.functions.and;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.machines.IRotateableEntity;

public class TElogicAnd extends TElogicNode implements IRotateableEntity {

	private ForgeDirection forwardDirection;

	public TElogicAnd() {
		super();
	}

	@Override
	public ForgeDirection[] setConnectableSides() {
		return new ForgeDirection[] { ForgeDirection.EAST, ForgeDirection.WEST, ForgeDirection.NORTH };
	}

	@Override
	protected void transition() {
			boolean right = (Boolean) getBuffer(ForgeDirection.EAST).get();
			boolean left = (Boolean) getBuffer(ForgeDirection.WEST).get();
			boolean front = left && right;
			send(ForgeDirection.NORTH, front);
			System.out.println(left + " " + right + " gives " + front);
	}

	@Override
	public ForgeDirection getForwardDirection() {
		return forwardDirection;
	}

	@Override
	public void setForwardDirection(ForgeDirection forwardFromMetadata) {
		this.forwardDirection = forwardFromMetadata;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		if (this.forwardDirection != null)
			par1nbtTagCompound.setByte("ForwardDirection", (byte) this.forwardDirection.ordinal());
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		// TODO Auto-generated method stub
		super.readFromNBT(par1nbtTagCompound);
		this.forwardDirection = ForgeDirection.VALID_DIRECTIONS[par1nbtTagCompound.getByte("ForwardDirection")];
	}
}
