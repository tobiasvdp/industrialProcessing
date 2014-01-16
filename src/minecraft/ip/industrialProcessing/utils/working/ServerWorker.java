package ip.industrialProcessing.utils.working;

public class ServerWorker implements IWorker {

	private IWorkHandler handler;
	protected int totalWork;
	protected int workDone;

	public ServerWorker(IWorkHandler handler, int totalWork) {
		this.handler = handler;
		this.totalWork = totalWork;
	}

	@Override
	public int doWork(int amount) {
		int workToDo = 0;
		if (amount > 0) {
			if (this.workDone == 0) {
				onPrepareWork();
			}
			if (hasWork()) {
				if (canWork()) {
					if (workDone == 1)
						onBeginWork();
					workToDo = Math.min(amount, totalWork - workDone+1);
					onWorkProgressed(workToDo);
					if (this.workDone > this.totalWork) {
						onEndWork();
					}
				}
			} else if (workDone > 1) {
				this.onWorkCancelled();
			} else
				this.workDone = 0; // prepare again next tick

		}
		return workToDo;
	}

	protected void onBeginWork() {
		this.handler.beginWork();
	}

	protected void onWorkProgressed(int amount) {
		this.workDone += amount;
		this.handler.workProgressed(amount);
	}

	protected void onWorkCancelled() {
		this.handler.workCancelled();
		this.workDone = 0;
	}

	public boolean hasWork() {
		return this.handler.hasWork();
	}

	public boolean canWork() {
		return this.handler.canWork();
	}

	protected void onEndWork() {
		this.handler.workDone();
		this.workDone = 0;
	}

	protected void onPrepareWork() {
		this.handler.prepareWork();
		this.workDone = 1;
	}

	@Override
	public int getTotalWork() {
		return totalWork;
	}

	@Override
	public int getWorkDone() {
		return workDone;
	}

	@Override
	public void setTotalWork(int x) {
		totalWork = x;
	}

	@Override
	public void setWorkDone(int x) {
		workDone = x;
	}

	@Override
	public int getScaledProgress(int progressBarWidth) {
		return progressBarWidth * (workDone - 1) / totalWork;
	}

	@Override
	public boolean isWorking() {
		return workDone > 1 && workDone <= totalWork;
	}

	@Override
	public int doWork(int amount, int power) {
		// TODO Auto-generated method stub
		return 0;
	}
}
