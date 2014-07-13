package ip.industrialProcessing.subMod.logic.old.function.or;

import ip.industrialProcessing.subMod.logic.old.transport.TElogicNode;
import ip.industrialProcessing.subMod.logic.old.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariableType;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacket;
import net.minecraftforge.common.util.ForgeDirection;

public class TElogicOr extends TElogicNode {

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub

	}

	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.gate;
	}

	@Override
	public String getName() {
		return "Or gate";
	}

	@Override
	public ForgeDirection[] setConnectableInputSides() {
		return new ForgeDirection[] { ForgeDirection.EAST, ForgeDirection.WEST };
	}

	@Override
	public ForgeDirection[] setConnectableOutputSides() {
		return new ForgeDirection[] { ForgeDirection.NORTH };
	}

	@Override
	public void transition() {
		if (this.getBuffer(ForgeDirection.EAST).get().ID == UTVariableType.bit && this.getBuffer(ForgeDirection.WEST).get().ID == UTVariableType.bit) {
			System.out.println(this.getBuffer(ForgeDirection.EAST).get().value + " " + this.getBuffer(ForgeDirection.WEST).get().value);
			if ((Boolean) this.getBuffer(ForgeDirection.EAST).get().value == true || (Boolean) this.getBuffer(ForgeDirection.WEST).get().value == true) {
				System.out.println("Valid");
				if (this.getBuffer(ForgeDirection.NORTH).get().ID == UTVariableType.bit && (Boolean) this.getBuffer(ForgeDirection.NORTH).get().value == true) {
				} else {
					this.createDataPacket(ForgeDirection.NORTH, new UTVariable(0, UTVariableType.bit, true));
				}
			} else {
				System.out.println("Not valid");
				if (this.getBuffer(ForgeDirection.NORTH).get().ID == UTVariableType.bit && (Boolean) this.getBuffer(ForgeDirection.NORTH).get().value == false) {
				} else {
					this.createDataPacket(ForgeDirection.NORTH, new UTVariable(0, UTVariableType.bit, false));
				}
			}
		}
	}
}
