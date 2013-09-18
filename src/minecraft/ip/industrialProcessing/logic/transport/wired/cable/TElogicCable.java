package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.TElogicTransport;
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

public class TElogicCable extends TElogicTransport {

	@Override
	public UTBusType getBusType() {
		return UTBusType.cable;
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
		// TODO Auto-generated method stub
		
	}


}
