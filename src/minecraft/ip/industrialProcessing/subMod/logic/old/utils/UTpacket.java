package ip.industrialProcessing.subMod.logic.old.utils;

public class UTpacket {
	private UTpacketType type;
	private Object[] data;

	public UTpacket(UTpacket packet) {
		this.type = packet.type;
		this.data = new Object[packet.data.length];
		for (int i = 0; i < this.data.length; i++) {
			this.data[i] = packet.data[i];
		}
	}

	public UTpacket(UTpacketType type, Object... data) {
		this.type = type;
		this.data = data.clone();
	}

	public Object getData(int index) {
		if (index >= 0 && index < this.data.length) {
			return this.data[index];
		}
		return null;
	}

	public UTpacketType getType() {
		return this.type;
	}

	public int lenght() {
		return this.data.length;
	}

	public void setData(int index, Object obj) {
		this.data[index] = obj;
	}

}
