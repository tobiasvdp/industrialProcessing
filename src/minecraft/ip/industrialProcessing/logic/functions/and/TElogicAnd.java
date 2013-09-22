package ip.industrialProcessing.logic.functions.and;

import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTpacket;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public class TElogicAnd extends TElogicNode {

	private ForgeDirection forwardDirection;

	public TElogicAnd() {
		super();
	}

	@Override
	public void transition() {
			//boolean right = (Boolean) getBuffer(ForgeDirection.EAST).get();
			//boolean left = (Boolean) getBuffer(ForgeDirection.WEST).get();
			//boolean front = left && right;
			//System.out.println(left + " " + right + " gives " + front);
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

	@Override
	public ForgeDirection[] setConnectableInputSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForgeDirection[] setConnectableOutputSides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}
}
