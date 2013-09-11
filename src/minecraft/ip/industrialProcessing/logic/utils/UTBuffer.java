package ip.industrialProcessing.logic.utils;

public class UTBuffer {

	Object[] buffer;
	UTBusType type;
	
	public UTBuffer(UTBusType type) {
		this.type = type;
		if(type == UTBusType.bundle){
			buffer = new Object[16];
			for(int i = 0;i<15;i++){
				buffer[i] = new Boolean(false);
			}
		}
		if(type == UTBusType.cable){
			buffer = new Object[1];
			buffer[0] = new Boolean(false);
		}
		if(type == UTBusType.bus){
			buffer = new Object[32];
			for(int i = 0;i<31;i++){
				buffer[i] = new Integer(0);
			}
		}	
	}

	public void put(int index, Object value) {
		buffer[index] = value;
	}

	public Object[] iterate() {
		return buffer;
	}

}
