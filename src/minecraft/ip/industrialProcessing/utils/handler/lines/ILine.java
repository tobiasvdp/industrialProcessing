package ip.industrialProcessing.utils.handler.lines;

import net.minecraft.tileentity.TileEntity;

public interface ILine {

	int registerTransport(TileEntity te);
	boolean unregisterTransport(TileEntity te);
	
	int registerDevice(TileEntity te);
	boolean unregisterDevice(TileEntity te);
	
	void registerLine(ILine line);
	void unregisterLine(ILine line);
	
	void sendToDevices(Object obj);
	
}
