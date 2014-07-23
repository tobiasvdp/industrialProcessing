package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorLine;

public class LineHandler implements ILineHandler {
	
	Line[] lines;;
	String name;

	public LineHandler(String name) {
		lines = new Line[1];
		this.name=name;
	}
	
	public int createNewLine() {
		int id = 0;
		while (true) {
			if (id == lines.length) {
				Line[] lines = new Line[this.lines.length * 2];
				for (int i = 0; i < this.lines.length; i++) {
					lines[i] = this.lines[i];
				}
				this.lines = lines;
			}
			if (lines[id] == null) {
				lines[id] = new Line(id);
				return id;
			}
			id++;
		}
	}

	@Override
	public int registerToLine(ILineTileEntity teLine, ForgeDirection dir) {
		if(teLine.isMicroblock()){
			return registerMicroblockToLine((ILineTileEntityMicroblock) teLine,dir);
		}else{
			return -1;
		}
	}

	private int registerMicroblockToLine(ILineTileEntityMicroblock teLine, ForgeDirection dir) {
		int[] lines = teLine.getLineConnectionArray(dir);
		return 0;
	}

	@Override
	public void unregisterFromLine(ILineTileEntity teLine, ForgeDirection dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerToLineFromNBT(ILineTileEntity teLine, ForgeDirection dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public int registerUtilityToLine(ILineTileEntity teLine, ForgeDirection dir) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unregisterUtilityFromLine(ILineTileEntity teLine, ForgeDirection dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine, ForgeDirection dir) {
		if(teLine.isMicroblock()){
			
		}else{
			
		}
	}

	@Override
	public ILine[] getLines() {
		return lines;
	}

	@Override
	public String getName() {
		return name;
	}

}
