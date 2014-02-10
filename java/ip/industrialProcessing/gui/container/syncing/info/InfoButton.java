package ip.industrialProcessing.gui.container.syncing.info;

public class InfoButton implements IExpirable{
    public int state = -1;

    public int ttl;

    public InfoButton() {
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
