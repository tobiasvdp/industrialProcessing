package ip.industrialProcessing.gui.container.syncing.info;

public class InfoSlot {
    public int amount = -1;
    public int id = -1;
    public int damage = -1;
    public boolean input = false;
    public boolean output = false;

    public int ttl;

    public InfoSlot() {
	ttl = 20;
    }

    public boolean tick() {
	if (ttl > 0) {
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
