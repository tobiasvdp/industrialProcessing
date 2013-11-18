package ip.industrialProcessing.api.info;

import ip.industrialProcessing.logic.api.network.interfaces.StatusType;

public class InfoMachine implements IExpirable {
	public InfoPower power = new InfoPower();
	public InfoWorker worker = new InfoWorker();
	public StatusType status = StatusType.idle;

	public int ttl;

	public InfoMachine() {
		ttl = 20;
	}

	public boolean tick() {
		boolean tick = false;
		if (ttl > 0) {
			this.ttl--;
			tick = true;
		}
		if (power.tick())
			tick = true;
		if (worker.tick())
			tick = true;
		return tick;
	}

	public boolean isExpired() {
		if (this.ttl > 0)
			return false;
		return true;
	}

}
