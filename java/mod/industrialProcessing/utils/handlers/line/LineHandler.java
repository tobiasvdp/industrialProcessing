package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorLine;

public class LineHandler implements ILineHandler {
	
	Line[] lines;
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
		int[][] lines = teLine.getLineConnectionArray(dir);
		int line = getSmallestValidLineNumber(lines);
		if(line == -1){
			int newLine = createNewLine();
			teLine.setLineID(dir.ordinal(), newLine);
			System.out.println("created new line "+newLine);
			return this.lines[newLine].registerToLine(teLine);
		}else{
			teLine.setLineID(dir.ordinal(), line);
			this.lines[line].registerToLine(teLine);
			System.out.println("added to existing line "+line);
			translateToOtherLines(lines,line);
		}
		return -1;
	}

	private void translateToOtherLines(int[][] lines, int line) {
		for(int i = 0;i<3;i++){
			for(int j = 0;j<4;j++){
				if(lines[i][j] > line){
					mergeLines(line,lines[i][j]);
				}
			}
		}
	}

	private void mergeLines(int line, int oldLine) {
		if(lines[oldLine] != null){
			System.out.println("merge line "+line+" and "+oldLine);
			lines[oldLine].mergeLine(lines[line]);
			lines[oldLine] = null;
		}
	}

	private int getSmallestValidLineNumber(int[][] lines) {
		int min = -1;
		for(int i = 0;i<3;i++){
			for(int j = 0;j<4;j++){
				if(lines[i][j] >= 0 && (min == -1 || lines[i][j]<min)){
					min = lines[i][j];
				}
			}
		}
		return min;
	}

	@Override
	public void unregisterFromLine(ILineTileEntity teLine, ForgeDirection dir) {
		if(teLine.isMicroblock()){
			unregisterMicroblockFromLine((ILineTileEntityMicroblock) teLine,dir);
		}else{

		}
	}

	private void unregisterMicroblockFromLine(ILineTileEntityMicroblock teLine, ForgeDirection dir) {
		int line = teLine.getLineID(dir.ordinal());
		teLine.setLineID(dir.ordinal(), -1);
		if(lines[line] != null){
			if(lines[line].unregisterFromLine(teLine)){
				lines[line] = null;
			}else{
				splitLine(line);
				lines[line] = null;
			}
		}
	}

	private void splitLine(int oldLine) {
		lines[oldLine].redoLine();
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
