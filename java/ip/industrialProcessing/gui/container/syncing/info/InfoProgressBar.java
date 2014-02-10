package ip.industrialProcessing.gui.container.syncing.info;

public class InfoProgressBar implements IExpirable{
    public int ttl;

    public InfoProgressBar() {
	ttl = 20;
    }

	@Override
	public boolean tick() {
		if (ttl > 0){
			this.ttl--;
			return true;
		}
		return false;
	}

    @Override
	public boolean isExpired() {
	if (this.ttl > 0)
	    return false;
	return true;
    }
}
