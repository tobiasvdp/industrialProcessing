package ip.industrialProcessing.logic.utils;

public class UTVariable {

    public UTVariableType ID;
    public int index;
    public Object value;

    public UTVariable(int index, UTVariableType ID, Object value) {
	this.index = index;
	this.ID = ID;
	this.value = value;
    }
    
    public UTVariable(UTVariableType ID) {
	this.index = 0;
	this.ID = ID;
	this.value = null;
    }

    public UTVariable(UTVariable item) {
	ID = item.ID;
	value = item.value;
	index = item.index;
    }

}
