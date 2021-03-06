package ip.industrialProcessing.gui.container.syncing.info;

public class InfoPower implements IExpirable{
    public int storedPower = -1;
    public int powerCapacity = -1;

    public int ttl;

    public InfoPower() {
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
