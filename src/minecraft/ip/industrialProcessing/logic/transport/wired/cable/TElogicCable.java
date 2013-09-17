package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.machines.TileEntitySynced;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import cpw.mods.fml.common.asm.transformers.MarkerTransformer;
import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicCable extends TileEntitySynced implements ICommunicationTransport {

	@Override
	public void Receive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scheduleSend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Send() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UTBusType getBusType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UTBusType getBusType(ForgeDirection dir) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void requestRecheck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMultipleSides(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getMultipleSides() {
		// TODO Auto-generated method stub
		return false;
	}


}
