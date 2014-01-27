package ip.industrialProcessing.subMod.logic.transport.wired.displayBox;

import ip.industrialProcessing.subMod.logic.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.subMod.logic.transport.TElogicNode;
import ip.industrialProcessing.subMod.logic.utils.UTpacket;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public class TElogicDisplayBox extends TElogicNode implements ICommunicationNode, ICommunicationTransport {

	@Override
	public void addToBlockside(int par5) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createRecheckPacket() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBlockSidesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasBlockSide(int side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasMultipleBlockSides() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isEnabled(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromBlockside(int par5) {
		// TODO Auto-generated method stub

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
	public void transition() {
		// TODO Auto-generated method stub

	}

}