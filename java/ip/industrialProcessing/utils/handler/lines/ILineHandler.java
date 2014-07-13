package ip.industrialProcessing.utils.handler.lines;

public interface ILineHandler {
	public ILine getLine(int id);
	
	/*
	 * Registering of devices
	 */
	public boolean registerDevice(int id, ILineDevice te) ;
	public void unregisterDevice(int id, ILineDevice te);
	
	/*
	 * Registering of transport
	 */
	public int registerTransport(ILineTransport te);
	public void registerTransportToLine(int id, ILineTransport te);
	public void registerTransportFromNBT(ILineTransport te);
	public void unregisterTransport(ILineTransport te);
	public void unregisterTransportToLine(int id, ILineTransport te);
	
	/*
	 * Handling of events
	 */
	public void splitLine(int id1, ILineTransport te);
	public int mergeLine(int id1, int id2, ILineTransport te);
	public int createNewLine();
	
}
