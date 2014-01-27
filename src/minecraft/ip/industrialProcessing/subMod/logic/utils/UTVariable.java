package ip.industrialProcessing.subMod.logic.utils;

public class UTVariable {

	public UTVariableType ID;
	public int index;
	public Object value;
	public int ttl;

	public UTVariable(int index, UTVariableType ID, Object value) {
		this.index = index;
		this.ID = ID;
		this.value = value;
		this.ttl = 20;
	}

	public UTVariable(UTVariable item) {
		this.ID = item.ID;
		this.value = item.value;
		this.index = item.index;
		this.ttl = item.ttl;
	}

	public UTVariable(UTVariableType ID) {
		this.index = 0;
		this.ID = ID;
		this.value = null;
		this.ttl = 20;
	}

	public boolean isExpired() {
		if (this.ttl > 0) {
			return false;
		}
		return true;
	}

	public boolean tick() {
		if (this.ttl > 0) {
			this.ttl--;
			return true;
		}
		return false;
	}

}
