package ip.industrialProcessing.logic.utils;

public class UTVariable {

	public int ID;
	public int index;
	public Object value;
	
	public UTVariable(int index, int ID, Object value) {
		this.ID = ID;
		this.value = value;
	}

	public UTVariable(UTVariable item) {
		ID = item.ID;
		value = item.value;
		index = item.index;
	}

}
