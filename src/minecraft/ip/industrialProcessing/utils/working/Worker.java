package ip.industrialProcessing.utils.working;

public class Worker {

	private IWorkHandler handler;
	private int totalWork;
	private int workDone;

	public Worker(IWorkHandler handler, int totalWork) {
		this.handler = handler;
		this.totalWork = totalWork;
	}

	public boolean doWork(int amount) {
		boolean worked = false;
		if (amount > 0) {
			if (this.handler.hasWork()) {
				if (this.handler.canWork()) {
					if (this.workDone == 0) {
						this.handler.beginWork();
					}
					worked = true;
					this.workDone += amount;
					if (this.workDone >= this.totalWork) {
						this.handler.workDone();
						this.workDone = 0;
					}
				}
			} else
				this.workDone = 0;
		}
		return worked;
	}
}
