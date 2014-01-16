package ip.industrialProcessing.gui.container.syncing.info;

public class InfoTank implements IExpirable{
    public int amount = -1;
    public int capacity  = -1;
    public int fluidId  = -1;

    public int ttl;

    public InfoTank() {
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
