package ip.industrialProcessing.logic.transport.wired.switchbox;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.lang3.text.WordUtils;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.TElogicNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicSwitchBox extends TElogicNode {
	public TElogicSwitchBox(){
		super();
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

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}