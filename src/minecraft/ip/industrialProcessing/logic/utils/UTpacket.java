package ip.industrialProcessing.logic.utils;

import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;

import java.util.ArrayList;

import com.google.common.base.Objects;

import net.minecraftforge.common.ForgeDirection;

public class UTpacket {
	private UTpacketType type;
    private Object[] data;
	public UTpacket(UTpacketType type ,Object... data) {
		this.type = type;
		this.data = data.clone();
	}
	public UTpacket(UTpacket packet) {
		this.type = packet.type;
		data = new Object[packet.data.length];
		for(int i =0;i<data.length;i++)
			this.data[i] =packet.data[i];
	}
	public Object getData(int index) {
		if (index >=0 && index <data.length)
			return data[index];
		return null;
	}
	public void setData(int index, Object obj) {
		data[index] = obj;
	}
	public UTpacketType getType(){
		return type;
	}

}
