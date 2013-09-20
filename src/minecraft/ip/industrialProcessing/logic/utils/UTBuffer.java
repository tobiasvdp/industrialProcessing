package ip.industrialProcessing.logic.utils;

public class UTBuffer {

	UTVariable[] buffer;
	UTBufferType type;
	
	public UTBuffer(UTBufferType type, int size) {
		buffer = new UTVariable[size];
		for(int i = 0;i<size;i++){
			buffer[i] = new UTVariable(i,-1,null);
		}
	}

	public void put(int index, Object value) {
		buffer[index].value = value;
	}
	
	public void put(int index, int ID, Object value) {
		buffer[index].value = value;
		buffer[index].ID = ID;
	}

	public Object[] iterate() {
		return buffer;
	}

	public Object get() {
		return buffer[0];
	}
	
	public Object get(int i) {
		return buffer[i];
	}
	
	public int size(){
		return buffer.length;
	}

	public void put(UTVariable item) {
		buffer[item.index] = new UTVariable(item);
	}
}
