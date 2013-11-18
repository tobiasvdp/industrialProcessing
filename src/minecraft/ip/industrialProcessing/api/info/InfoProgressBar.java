package ip.industrialProcessing.api.info;

public class InfoProgressBar implements IExpirable{
    public int ttl;

    public InfoProgressBar() {
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
