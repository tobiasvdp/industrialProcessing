package mod.industrialProcessing.utils.handlers.line;

import mod.industrialProcessing.plants.transport.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConveyorLine;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class LineHandler implements ILineHandler {
	ConveyorLine[] lines;;

	public LineHandler() {
		lines = new ConveyorLine[1];
	}

	@Override
	public boolean registerPowercontainer(int id, TileEntityConveyorBeltPowerInput te) {
		if (id < lines.length && id != -1) {
			ConveyorLine line = lines[id];
			if (line != null) {
				line.registerPowercontainer(te);
				return true;
			}
		}
		return false;
	}

	@Override
	public void unregisterPowercontainer(int id, TileEntityConveyorBeltPowerInput te) {
		if (id < lines.length && id != -1) {
			ConveyorLine line = lines[id];
			if (line != null) {
				line.unregisterPowercontainer(te);
			}
		}
	}

	public ConveyorLine getConveyorLine(int id) {
		return lines[id];
	}

	@Override
	public void unregisterLine(TileEntityConveyorConnectionsBase te) {
		if (te.getLineID() != -1) {
			unregisterConveyorToLine(te.getLineID(), te);
			ConveyorLine line = lines[te.getLineID()];
			if (line != null) {
				splitLine(te.getLineID(), te);
			}
		}
	}

	@Override
	public int registerLine(TileEntityConveyorConnectionsBase te) {
		int id1 = te.isValidLineConnection(LocalDirection.BACK, true);
		int id2 = -1;
		switch (te.getCornerState()) {
		case crossing:
		case invalid:
		case multi:
		case straight:
			id2 = te.isValidLineConnection(LocalDirection.FRONT, false);
			break;
		case left:
			id2 = te.isValidLineConnection(LocalDirection.LEFT, false);
			break;

		case right:
			id2 = te.isValidLineConnection(LocalDirection.RIGHT, false);
			break;
		default:
			break;
		}
		if (id1 == -1 && id2 == -1) {
			if (te.getLineID() == -1) {
				System.out.println("new line");
				int id = createNewLine();
				registerConveyorToLine(id, te);
				return id;
			}
			return te.getLineID();
		} else if (id1 == id2) {
			if (te.getLineID() == -1) {
				System.out.println("added to line " + id1);
				registerConveyorToLine(id1, te);
			}
			System.out.println("line" + id1);
			return id1;
		} else if (id1 != -1 && id2 == -1) {
			System.out.println("added to line " + id1);
			registerConveyorToLine(id1, te);
			if (te.getLineID() != 1 && (te.getLineID() != id1 && te.getLineID() != id2)) {
				unregisterConveyorToLine(te.getLineID(), te);
			}
			return id1;
		} else if (id1 == -1 && id2 != -1) {
			System.out.println("added to line " + id2);
			registerConveyorToLine(id2, te);
			if (te.getLineID() != -1 && (te.getLineID() != id1 && te.getLineID() != id2)) {
				unregisterConveyorToLine(te.getLineID(), te);
			}
			return id2;
		} else if (id1 != id2) {
			System.out.println("merge lines " + id1 + " " + id2);
			int id = mergeLine(id1, id2, te);
			if (te.getLineID() == -1)
				registerConveyorToLine(id, te);
			return id;
		}
		return te.getLineID();
	}

	public void registerConveyorToLine(int id, TileEntityConveyorConnectionsBase te) {
		ConveyorLine line = lines[id];
		line.registerConveyor(te);
	}

	public void unregisterConveyorToLine(int id, TileEntityConveyorConnectionsBase te) {
		if (id != -1) {
			ConveyorLine line = lines[id];
			if (line != null)
				if (line.unregisterConveyor(te))
					lines[id] = null;
		}
	}

	public void evaluateLine(int id) {
		ConveyorLine line = lines[id];
	}

	public void splitLine(int id1, TileEntityConveyorConnectionsBase te) {
		int idBack = te.isValidLineConnection(LocalDirection.BACK, true);
		int idFront = -1;
		switch (te.getCornerState()) {
		case crossing:
		case invalid:
		case multi:
		case straight:
			idFront = te.isValidLineConnection(LocalDirection.FRONT, false);
			break;
		case left:
			idFront = te.isValidLineConnection(LocalDirection.RIGHT, false);
			break;

		case right:
			idFront = te.isValidLineConnection(LocalDirection.LEFT, false);
			break;
		default:
			break;
		}
		if (idBack == -1 || idFront == -1) {
		} else {
			System.out.println("split required");
			int id2 = createNewLine();
			translateNewIDToLineForward(id1, id2, te);
		}

	}

	private void translateNewIDToLineForward(int id1, int id2, TileEntityConveyorConnectionsBase base) {
		TileEntityConveyorConnectionsBase[] te = new TileEntityConveyorConnectionsBase[] { base };
		boolean doNext = true;
		while (doNext) {
			ForgeDirection dir = DirectionUtils.getWorldDirection(LocalDirection.BACK, te[0].getForwardDirection());
			int offsetSlope = te[0].getOffsetfromSlope(LocalDirection.BACK);
			TileEntity next = te[0].getWorldObj().getTileEntity(te[0].xCoord + dir.offsetX, te[0].yCoord + dir.offsetY + offsetSlope, te[0].zCoord + dir.offsetZ);
			if (next != null && next instanceof TileEntityConveyorConnectionsBase) {
				TileEntityConveyorConnectionsBase nextTe = ((TileEntityConveyorConnectionsBase) next);
				if (nextTe.getLineID() == id1) {
					registerConveyorToLine(id2, nextTe);
					unregisterConveyorToLine(id1, nextTe);
					nextTe.setLineID(id2);
					te[0] = nextTe;
				} else {
					doNext = false;
				}

			} else {
				doNext = false;
			}
		}
	}

	public int mergeLine(int id1, int id2, TileEntityConveyorConnectionsBase te) {
		translateNewIDToLineForward(id1, id2, te);
		return id2;
	}

	public int createNewLine() {
		int id = 0;
		while (true) {
			if (id == lines.length) {
				ConveyorLine[] lines = new ConveyorLine[this.lines.length * 2];
				for (int i = 0; i < this.lines.length; i++) {
					lines[i] = this.lines[i];
				}
				this.lines = lines;
			}
			if (lines[id] == null) {
				lines[id] = new ConveyorLine(id);
				return id;
			}
			id++;
		}
	}

	@Override
	public void registerLineFromNBT(TileEntityConveyorConnectionsBase conveyorBelt) {
		int id = conveyorBelt.getLineID();
		if (id != -1) {
			while (id >= lines.length) {
				ConveyorLine[] lines = new ConveyorLine[this.lines.length * 2];
				for (int i = 0; i < this.lines.length; i++) {
					lines[i] = this.lines[i];
				}
				this.lines = lines;
			}
			if (lines[id] == null)
				lines[id] = new ConveyorLine(id);
			lines[id].registerConveyor(conveyorBelt);
		}
	}

	@Override
	public float getResistanceForLine(int id) {
		if (id < lines.length) {
			ConveyorLine line = lines[id];
			if (line != null) {
				return line.getResistance();
			}
		}
		return 0;
	}

	@Override
	public float getSpeedForLine(int id) {
		if (id < lines.length) {
			ConveyorLine line = lines[id];
			if (line != null) {
				return line.getSpeed();
			}
		}
		return 0;
	}
}
