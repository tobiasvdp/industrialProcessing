package ip.industrialProcessing.api.info;

public class InfoWorker implements IExpirable{
    public int workDone = -1;
    public int totalWork;

    public int ttl;

    public InfoWorker() {
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
