package mod.industrialProcessing.utils.handlers.line;

public interface ILine {
	public int registerToLine(ILineTileEntity teLine);
	public boolean unregisterFromLine(ILineTileEntity teLine);
	public void registerToLineFromNBT(ILineTileEntity teLine);
	
	public int registerUtilityToLine(ILineTileEntity teLine);
	public boolean unregisterUtilityFromLine(ILineTileEntity teLine);
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine);
	
	public boolean mergeLine(ILine line);
	public void redoLine();
	
	public int getID();
}
