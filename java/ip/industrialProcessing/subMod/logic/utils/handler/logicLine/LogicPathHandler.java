package ip.industrialProcessing.subMod.logic.utils.handler.logicLine;

import ip.industrialProcessing.subMod.logic.network.ILogicTransport;
import ip.industrialProcessing.subMod.logic.network.microblock.TileEntityLogicTransport;
import ip.industrialProcessing.transport.items.ConveyorLine;
import ip.industrialProcessing.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.utils.handler.lines.ILine;
import ip.industrialProcessing.utils.handler.lines.ILineDevice;
import ip.industrialProcessing.utils.handler.lines.ILineHandler;
import ip.industrialProcessing.utils.handler.lines.ILineTransport;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class LogicPathHandler implements ILineHandler {
	private static ILine[] lines;

	public LogicPathHandler() {
		lines = new LogicLine[1];
	}

	public ILine getLine(int id) {
		return lines[id];
	}

	public boolean registerDevice(int id, ILineDevice te) {
		if (id < lines.length && id != -1) {
			ILine line = lines[id];
			if (line != null) {
				line.registerDevice(te);
				return true;
			}
		}
		return false;
	}

	public void unregisterDevice(int id, ILineDevice te) {
		if (id < lines.length && id != -1) {
			ILine line = lines[id];
			if (line != null) {
				line.unregisterDevice(te);
			}
		}
	}

	public void unregisterTransport(ILineTransport te) {
		ILogicTransport logic = (ILogicTransport) te;
		if (te instanceof TileEntityLogicTransport) {
			for (int i = 0; i < 6; i++) {
				if (te.getLineID(i) != -1 && logic.isSideFree(i)) {
					ILine line = lines[te.getLineID(i)];
					if (line != null) {
						splitLine(te.getLineID(i), te);
					}
				}
			}
			unregisterTransportToLine(0, te);
		}
	}

	public int registerTransport(ILineTransport te) {
		if (te instanceof TileEntityLogicTransport) {
			ILogicTransport logic = (ILogicTransport) te;
			for (int i = 0; i < 6; i++) {
				int lineID = logic.getLineID(i);
				if (!logic.isSideFree(i) && lineID == -1) {
					boolean[] internal = logic.getInterConnections(i);
					boolean[] external = logic.getExternalConnections(i);
					boolean[] externalCorner = logic.getExternalConnectionCorners(i);

					// if no id, try to register by an internal line. Else
					// translate the lineID over the other lines.
					for (int j = 0; j < internal.length; j++) {
						if (internal[j]) {
							int side = logic.getRotated(i, j);
							int sideLineID = logic.getLineID(side);
							if (sideLineID != -1) {
								if (lineID == -1) {
									registerTransportToLine(sideLineID, te);
									lineID = sideLineID;
								} else {
									mergeLine(lineID, sideLineID, te);
								}
							}
						}
					}

					// if no id, try to register by an external line. Else
					// translate the lineID over the other line.
					for (int j = 0; j < external.length; j++) {
						if (external[j]) {

							int sideLineID = -1;

							int side = logic.getRotated(i, j);
							ILogicTransport logicSide = null;
							ForgeDirection dir = ForgeDirection.values()[side];
							if (externalCorner[j]) {
								ForgeDirection dir2 = ForgeDirection.values()[i];
								TileEntity te2 = ((TileEntity) te).worldObj.getBlockTileEntity(((TileEntity) te).xCoord + dir.offsetX + dir2.offsetX, ((TileEntity) te).yCoord + dir.offsetY + dir2.offsetY, ((TileEntity) te).zCoord + dir.offsetZ + dir2.offsetZ);
								if (te2 != null && te2 instanceof ILogicTransport) {
									logicSide = (ILogicTransport) te2;
									sideLineID = logicSide.getLineID(dir.getOpposite().ordinal());
								}
							} else {
								TileEntity te2 = ((TileEntity) te).worldObj.getBlockTileEntity(((TileEntity) te).xCoord + dir.offsetX, ((TileEntity) te).yCoord + dir.offsetY, ((TileEntity) te).zCoord + dir.offsetZ);
								if (te2 != null && te2 instanceof ILogicTransport) {
									logicSide = (ILogicTransport) te2;
									sideLineID = logicSide.getLineID(i);
								}
							}

							if (sideLineID != -1) {
								if (lineID == -1) {
									registerTransportToLine(sideLineID, te);
									lineID = sideLineID;
								} else {
									mergeLine(lineID, sideLineID, te);
								}
							}
						}
					}

					// it's no use, there is nothing to connect to, better
					// create a line
					if (lineID == -1) {
						int newLine = createNewLine();
						registerTransportToLine(newLine, te);
						lineID = newLine;
						System.out.println("new line " + lineID);
					}

				}
				if (lineID != -1)
					te.setLineID(i, lineID);
			}
			return -1;
		}
		return -1;
	}

	public void registerTransportFromNBT(ILineTransport te) {
		int id = te.getLineID();
		if (id != -1) {
			while (id >= lines.length) {
				ILine[] lines = new LogicLine[this.lines.length * 2];
				for (int i = 0; i < this.lines.length; i++) {
					lines[i] = this.lines[i];
				}
				this.lines = lines;
			}
			if (lines[id] == null)
				lines[id] = new LogicLine(id);
			lines[id].registerTransport(te);
		}
	}

	public void registerTransportToLine(int id, ILineTransport te) {
		if (id != -1) {
			ILine line = lines[id];
			line.registerTransport(te);
		}
	}

	public void unregisterTransportToLine(int id, ILineTransport te) {
		if (te instanceof TileEntityLogicTransport) {
			ILogicTransport logic = (ILogicTransport) te;
			for (int i = 0; i < 6; i++) {
				id = te.getLineID(i);
				if (logic.isSideFree(i) && id != -1)
					te.setLineID(i, -1);
				if (id != -1) {
					ILine line = lines[id];
					if (line != null)
						if (countTimesLineInBlock(id, te) == 0)
							if (line.unregisterTransport(te))
								lines[id] = null;
				}
			}
		}
	}

	private int countTimesLineInBlock(int id, ILineTransport te) {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (te.getLineID(i) == id)
				count++;
		}
		return count;
	}

	public void splitLine(int id1, ILineTransport te) {
		ILogicTransport logic = (ILogicTransport) te;
		for (int i = 0; i < 6; i++) {
			if (te.getLineID(i) == id1) {
				ILine line = lines[te.getLineID(i)];
				if (line != null) {
					translateOverLine(id1, -1, logic, i, true);
				}
			}
		}
		System.out.println("split line " + id1);
	}

	private void translateOverLine(int id1, int newLine, ILogicTransport logic, int i, boolean createNewLine) {
		boolean[] internal = logic.getInterConnections(i);
		boolean[] external = logic.getExternalConnections(i);
		boolean[] externalCorner = logic.getExternalConnectionCorners(i);
		unregisterTransportToLine(id1, logic);
		registerTransportToLine(newLine, logic);
		logic.setLineID(i, newLine);
		for (int j = 0; j < 4; j++) {
			if (createNewLine && (internal[j]||external[j])) {
				newLine = createNewLine();
			}
			if (internal[j]) {
				int side = logic.getRotated(i, j);
				if (logic.getLineID(side) == id1) {
					translateOverLine(id1, newLine, logic, side, false);
				}
			}
			if (external[j] && !externalCorner[j]) {
				int side = logic.getRotated(i, j);
				ForgeDirection dir = ForgeDirection.values()[side];
				TileEntity te = ((TileEntity) logic).worldObj.getBlockTileEntity(((TileEntity) logic).xCoord + dir.offsetX, ((TileEntity) logic).yCoord + dir.offsetY, ((TileEntity) logic).zCoord + dir.offsetZ);
				if (te instanceof ILogicTransport) {
					ILogicTransport logic2 = (ILogicTransport) te;
					if (logic2.getLineID(i) == id1) {
						translateOverLine(id1, newLine, logic2, i, false);
					}
				}
			}
			if (external[j] && externalCorner[j]) {
				int side = logic.getRotated(i, j);
				ForgeDirection dir = ForgeDirection.values()[side];
				ForgeDirection dir2 = ForgeDirection.values()[i];
				TileEntity te = ((TileEntity) logic).worldObj.getBlockTileEntity(((TileEntity) logic).xCoord + dir.offsetX + dir2.offsetX, ((TileEntity) logic).yCoord + dir.offsetY + dir2.offsetY, ((TileEntity) logic).zCoord + dir.offsetZ + dir2.offsetZ);
				if (te instanceof ILogicTransport) {
					ILogicTransport logic2 = (ILogicTransport) te;
					if (logic2.getLineID(dir.getOpposite().ordinal()) == id1) {
						translateOverLine(id1, newLine, logic2, dir.getOpposite().ordinal(), false);
					}
				}
			}
		}
		if (createNewLine){
			lines[id1] = null;
		}

	}

	public int mergeLine(int id1, int id2, ILineTransport te) {
		if (id1 != id2) {
			int newid = Math.min(id1, id2);
			if (newid == id1) {
				lines[id1].registerLine(lines[id2]);
				lines[id2] = null;
			} else {
				lines[id2].registerLine(lines[id1]);
				lines[id1] = null;
			}
			System.out.println("merge lines " + id1 + " " + id2 + " to " + newid);
			return id2;
		} else
			return id1;
	}

	public int createNewLine() {
		int id = 0;
		while (true) {
			if (id == lines.length) {
				ILine[] lines = new ILine[this.lines.length * 2];
				for (int i = 0; i < this.lines.length; i++) {
					lines[i] = this.lines[i];
				}
				this.lines = lines;
			}
			if (lines[id] == null) {
				lines[id] = new LogicLine(id);
				return id;
			}
			id++;
		}
	}
}
