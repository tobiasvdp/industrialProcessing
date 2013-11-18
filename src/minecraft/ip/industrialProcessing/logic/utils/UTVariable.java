package ip.industrialProcessing.logic.utils;

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
    
    public UTVariable(UTVariableType ID) {
	this.index = 0;
	this.ID = ID;
	this.value = null;
	this.ttl = 20;
    }
    
    public void tick(){
	this.ttl--;
    }
    
    public boolean isExpired(){
	if(this.ttl > 0)
	    return false;
	return true;
    }

    public UTVariable(UTVariable item) {
	ID = item.ID;
	value = item.value;
	index = item.index;
	ttl = item.ttl;
    }

}
