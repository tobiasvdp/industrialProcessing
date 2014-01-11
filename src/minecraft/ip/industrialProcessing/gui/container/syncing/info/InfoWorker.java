package ip.industrialProcessing.gui.container.syncing.info;

public class InfoWorker implements IExpirable{
    public int workDone = -1;
    public int totalWork  = -1;

    public int ttl;

    public InfoWorker() {
	ttl = 20;
    }

	public boolean tick() {
		if (ttl > 0){
			this.ttl--;
			return true;
		}
		return false;
	}

    public boolean isExpired() {
	if (this.ttl > 0)
	    return false;
	return true;
    }
}
