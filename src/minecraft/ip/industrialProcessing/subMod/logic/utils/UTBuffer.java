package ip.industrialProcessing.subMod.logic.utils;

import ip.industrialProcessing.api.info.InfoMachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class UTBuffer {

	ArrayList<UTVariable> buffer;
	UTBufferType type;

	public UTBuffer(UTBufferType type) {
		this.type = type;
		buffer = new ArrayList<UTVariable>();
	}

	public void add(UTVariableType ID) {
			buffer.add(new UTVariable(ID));
	}

	public void setType(UTBufferType type) {
		this.type = type;
		buffer.clear();
	}

	public void put(int index,int index1, UTVariableType ID, Object value) {
		if (isValidType(value)) {
			buffer.get(index).index = index1;
			buffer.get(index).value = value;
			buffer.get(index).ID = ID;
		}
	}

	public UTVariable get() {
		return buffer.get(0);
	}

	public UTVariable get(int i) {
		return buffer.get(i);
	}

	public int size() {
		return buffer.size();
	}

	public void put(UTVariable item) {
		buffer.set(0,new UTVariable(item));
	}

	public boolean isValidType(Object data) {
		switch (type) {
		case Bit:
			if (data instanceof Boolean) {
				return true;
			}
		case Byte:
			break;
		case Integer:
			if (data instanceof Integer) {
				return true;
			}
		case collection:
			return true;
		default:
			break;
		}
		return false;
	}

	public void add(int i, UTVariableType type, Object object) {
		buffer.add(new UTVariable(i,type,object));
	}

	public void clear() {
		buffer.clear();
	}
}
