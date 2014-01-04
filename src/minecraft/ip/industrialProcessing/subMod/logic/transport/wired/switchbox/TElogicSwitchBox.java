package ip.industrialProcessing.subMod.logic.transport.wired.switchbox;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.lang3.text.WordUtils;

import ip.industrialProcessing.subMod.logic.transport.ICommunication;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.subMod.logic.transport.TElogicNode;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.subMod.logic.utils.UTpacket;
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