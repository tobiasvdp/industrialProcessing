package ip.industrialProcessing.api.info;

public class InfoTank implements IExpirable{
    public int amount = -1;
    public int capacity;
    public int fluidId;

    public int ttl;

    public InfoTank() {
	ttl = 20;
    }

    public void tick() {
	this.ttl--;
    }

    public boolean isExpired() {
	if (this.ttl > 0)
	    return false;
	return true;
    }
}
