package mod.industrialProcessing.utils.handlers.line;

public interface ILine {
	public int registerToLine(ILineTileEntity teLine);
	public void unregisterFromLine(ILineTileEntity teLine);
	public void registerToLineFromNBT(ILineTileEntity teLine);
	
	public int registerUtilityToLine(ILineTileEntity teLine);
	public void unregisterUtilityFromLine(ILineTileEntity teLine);
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine);
}
