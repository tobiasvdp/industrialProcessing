package ip.industrialProcessing.utils.handler.lines;

import java.util.Iterator;

import net.minecraft.tileentity.TileEntity;

public interface ILine {

	int registerTransport(ILineTransport te);
	boolean unregisterTransport(ILineTransport te);
	
	int registerDevice(ILineDevice te);
	boolean unregisterDevice(ILineDevice te);
	
	void registerLine(ILine line);
	void unregisterLine(ILine line);
	
	void sendToDevices(Object obj);
	
	Iterator<ILineDevice> getDevices();
	Iterator<ILineTransport> getTransport();
	
	int getID();
	
}
