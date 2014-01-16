package ip.industrialProcessing.gui.container.syncing.info;

public class InfoHeat implements IExpirable{
    public int heat = -1;
    public int heatFuel = -1;
    public int burnTime = -1;
    public int maxBurnTime = -1;
    public int maxHeat = -1;

    public int ttl;

    public InfoHeat() {
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
