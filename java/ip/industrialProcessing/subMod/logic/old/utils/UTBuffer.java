package ip.industrialProcessing.subMod.logic.old.utils;

import java.util.ArrayList;

public class UTBuffer {

	ArrayList<UTVariable> buffer;
	UTBufferType type;

	public UTBuffer(UTBufferType type) {
		this.type = type;
		this.buffer = new ArrayList<UTVariable>();
	}

	public void add(int i, UTVariableType type, Object object) {
		this.buffer.add(new UTVariable(i, type, object));
	}

	public void add(UTVariableType ID) {
		this.buffer.add(new UTVariable(ID));
	}

	public void clear() {
		this.buffer.clear();
	}

	public UTVariable get() {
		return this.buffer.get(0);
	}

	public UTVariable get(int i) {
		return this.buffer.get(i);
	}

	public boolean isValidType(Object data) {
		switch (this.type) {
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

	public void put(int index, int index1, UTVariableType ID, Object value) {
		if (this.isValidType(value)) {
			this.buffer.get(index).index = index1;
			this.buffer.get(index).value = value;
			this.buffer.get(index).ID = ID;
		}
	}

	public void put(UTVariable item) {
		this.buffer.set(0, new UTVariable(item));
	}

	public void setType(UTBufferType type) {
		this.type = type;
		this.buffer.clear();
	}

	public int size() {
		return this.buffer.size();
	}
}
