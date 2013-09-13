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
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicSwitchBox extends TElogicNode {
	public TElogicSwitchBox(){
		super();
	}

	@Override
	protected void transition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ForgeDirection[] setConnectableSides() {
		return new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST};
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		worldObj.setWorldTime(6000);
	}
}
