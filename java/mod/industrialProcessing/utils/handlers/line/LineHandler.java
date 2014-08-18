package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorLine;

public class LineHandler implements ILineHandler {

	ILine[] lines;
	String name;

	public LineHandler(String name) {
		lines = new Line[1];
		this.name = name;
	}

	public int createNewLine(int id) {
		while (true) {
			while (id >= lines.length) {
				ILine[] lines = new Line[this.lines.length * 2];
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

	public int createNewLine() {
		return createNewLine(0);
	}

	@Override
	public int registerToLine(ILineTileEntity teLine, ForgeDirection dir) {
		if (teLine.isMicroblock()) {
			return registerMicroblockToLine((ILineTileEntityMicroblock) teLine, dir);
		} else {
			return -1;
		}
	}

	private int registerMicroblockToLine(ILineTileEntityMicroblock teLine, ForgeDirection dir) {
		int[] lines = teLine.getLineConnectionArray(dir);
		int line = getSmallestValidLineNumber(lines);
		if (line == -1) {
			int newLine = createNewLine();
			teLine.setLineID(dir.ordinal(), newLine);
			System.out.println("created new line " + newLine);
			return this.lines[newLine].registerToLine(teLine);
		} else {
			teLine.setLineID(dir.ordinal(), line);
			this.lines[line].registerToLine(teLine);
			System.out.println("added to existing line " + line);
			translateToOtherLines(lines, line);
		}
		return -1;
	}

	private void translateToOtherLines(int[] lines, int line) {
		for (int i = 0; i < lines.length; i++) {
				if (lines[i] > line) {
					mergeLines(line, lines[i]);
				}
			}
	}

	private void mergeLines(int line, int oldLine) {
		if (lines[oldLine] != null) {
			System.out.println("merge line " + line + " and " + oldLine);
			lines[oldLine].mergeLine(lines[line]);
			lines[oldLine] = null;
		}
	}

	private int getSmallestValidLineNumber(int[] lines) {
		int min = -1;
		for (int i = 0; i < lines.length; i++) {
				if (lines[i] >= 0 && (min == -1 || lines[i] < min)) {
					min = lines[i];
				}
		}
		return min;
	}

	@Override
	public void unregisterFromLine(ILineTileEntity teLine, ForgeDirection dir) {
		if (teLine.isMicroblock()) {
			unregisterMicroblockFromLine((ILineTileEntityMicroblock) teLine, dir);
		} else {

		}
	}

	private void unregisterMicroblockFromLine(ILineTileEntityMicroblock teLine, ForgeDirection dir) {
		int line = teLine.getLineID(dir.ordinal());
		teLine.setLineID(dir.ordinal(), -1);
		if (line != -1) {
			if (lines[line] != null) {
				if (lines[line].unregisterFromLine(teLine)) {
					lines[line] = null;
				} else {
					splitLine(line);
					lines[line] = null;
				}
			}
		}
	}

	private void splitLine(int oldLine) {
		lines[oldLine].redoLine();
	}

	@Override
	public void registerToLineFromNBT(ILineTileEntity teLine) {
		if (teLine.isMicroblock()) {
			registerMicroblockToLineFromNBT((ILineTileEntityMicroblock) teLine);
		} else {
			// TODO
		}
	}

	private void registerMicroblockToLineFromNBT(ILineTileEntityMicroblock teLine) {
		if (!teLine.isLineNull()) {
			for (int i = 0; i < 6; i++) {
				int id = teLine.getLineID(i);
				if (id >= 0) {
					if (id >= lines.length || lines[id] == null)
						createNewLine(id);
					lines[id].registerToLineFromNBT(teLine);
					System.out.println("Registered to line " + id + " from NBT");
				}
			}
		}
	}

	@Override
	public int registerUtilityToLine(ILineTileEntity teLine, ForgeDirection dir) {
		int[] lines = teLine.getLineConnectionArray(dir);
		if(teLine.hasMultipleLineSupport()){
			for(int i = 0;i<lines.length;i++){
				if(lines[i] >= 0){
					this.lines[i].registerUtilityToLine(teLine);
					System.out.println("registered util to line "+i);
				}
			}
		}else{
			int line = getSmallestValidLineNumber(lines);
			if(line >= 0){
				if(teLine instanceof ILineTileEntityMicroblock){
					
				}else{
					((ILineTileEntitySolidBlock)teLine).setLineID(line);
				}
				this.lines[line].registerUtilityToLine(teLine);
				System.out.println("registered util to line "+line);
			}
		}
		return 0;
	}

	@Override
	public void unregisterUtilityFromLine(ILineTileEntity teLine, ForgeDirection dir) {
		for(int i = 0;i<lines.length;i++){
			lines[i].unregisterUtilityFromLine(teLine);
		}
		System.out.println("unregistered Util");
	}

	@Override
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine) {
		if (teLine.isMicroblock()) {
			
		} else {
			ILineTileEntitySolidBlock teSolid = ((ILineTileEntitySolidBlock)teLine);
			int id = teSolid.getLineId();
			if (id >= 0) {
				if (id >= lines.length || lines[id] == null)
					createNewLine(id);
				lines[id].registerUtilityToLineFromNBT(teLine);
				System.out.println("Registered utility to line " + id + " from NBT");
			}
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

	@Override
	public void reset() {
		lines = new Line[1];
		lines[0] = null;
	}

}
