package ip.industrialProcessing.gui.container.syncing.info;

public class InfoLifeSpan implements IExpirable{
    public int lifeTime = -1;
    public int maxLifeTime = -1;
	
    public int ttl;

    public InfoLifeSpan() {
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
