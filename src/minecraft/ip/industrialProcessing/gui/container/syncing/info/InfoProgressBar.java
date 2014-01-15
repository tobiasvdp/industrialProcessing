package ip.industrialProcessing.gui.container.syncing.info;

public class InfoProgressBar implements IExpirable{
    public int ttl;

    public InfoProgressBar() {
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
