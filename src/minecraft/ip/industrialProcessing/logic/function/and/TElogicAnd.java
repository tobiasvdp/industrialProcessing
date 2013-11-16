package ip.industrialProcessing.logic.function.and;

import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTLogicType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.logic.utils.UTpacket;
import net.minecraftforge.common.ForgeDirection;

public class TElogicAnd extends TElogicNode {

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
		if (getBuffer(ForgeDirection.EAST).get().ID == UTVariableType.bit && getBuffer(ForgeDirection.WEST).get().ID == UTVariableType.bit) {
			System.out.println((getBuffer(ForgeDirection.EAST).get().value) + " " + (getBuffer(ForgeDirection.WEST).get().value));
			if (((Boolean) getBuffer(ForgeDirection.EAST).get().value) == true && ((Boolean) getBuffer(ForgeDirection.WEST).get().value) == true) {
				System.out.println("Valid");
				if (getBuffer(ForgeDirection.NORTH).get().ID == UTVariableType.bit && ((Boolean) getBuffer(ForgeDirection.NORTH).get().value) == true) {
				} else {
					createDataPacket(ForgeDirection.NORTH, new UTVariable(0, UTVariableType.bit, true));
				}
			} else {
				System.out.println("Not valid");
				if (getBuffer(ForgeDirection.NORTH).get().ID == UTVariableType.bit && ((Boolean) getBuffer(ForgeDirection.NORTH).get().value) == false) {
				} else {
					createDataPacket(ForgeDirection.NORTH, new UTVariable(0, UTVariableType.bit, false));
				}
			}
		}
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "And gate";
	}
	
    @Override
    public UTLogicType getLogicType(){
    	return UTLogicType.gate;
    }

}
