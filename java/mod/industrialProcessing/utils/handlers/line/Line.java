package mod.industrialProcessing.utils.handlers.line;

public class Line implements ILine {
	
	int ID;
	
	public Line(int id) {
		this.ID = id;
	}

	@Override
	public int registerToLine(ILineTileEntity teLine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unregisterFromLine(ILineTileEntity teLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerToLineFromNBT(ILineTileEntity teLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public int registerUtilityToLine(ILineTileEntity teLine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unregisterUtilityFromLine(ILineTileEntity teLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine) {
		// TODO Auto-generated method stub

	}

}
