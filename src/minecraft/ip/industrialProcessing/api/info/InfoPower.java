package ip.industrialProcessing.api.info;

public class InfoPower implements IExpirable{
    public int storedPower;
    public int powerCapacity;

    public int ttl;

    public InfoPower() {
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
