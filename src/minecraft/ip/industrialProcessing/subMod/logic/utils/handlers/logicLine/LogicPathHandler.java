package ip.industrialProcessing.subMod.logic.utils.handlers.logicLine;

import ip.industrialProcessing.transport.items.ConveyorLine;

import java.util.ArrayList;

public class LogicPathHandler {
private static LogicLine[] lines;

public LogicPathHandler() {
	lines = new LogicLine[1];
}

public LogicLine getLine(int id) {
	return lines[id];
}

}
