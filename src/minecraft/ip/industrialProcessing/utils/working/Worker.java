package ip.industrialProcessing.utils.working;

public class Worker {

	private IWorkHandler handler;
	protected int totalWork;
	protected int workDone;

	public Worker(IWorkHandler handler, int totalWork) {
		this.handler = handler;
		this.totalWork = totalWork;
	}

	public boolean doWork(int amount) {
		boolean worked = false;
		if (amount > 0) {
			if (this.workDone == 0) {
				onBeginWork();
			}
			if (hasWork()) {
				if (canWork()) {
					worked = true;
					this.workDone += amount;
					if (this.workDone >= this.totalWork) {
						onEndWork();
					}
				}
			} else
				this.workDone = 0;
		}
		return worked;
	}
	
	protected boolean hasWork()
	{
		return this.handler.hasWork();
	}

	protected boolean canWork()
	{
		return this.handler.canWork();
	}
	
	protected void onEndWork() {
		this.handler.workDone();
		this.workDone = 0;
	}

	protected void onBeginWork() {
		this.handler.beginWork();
	}
}
