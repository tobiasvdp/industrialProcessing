package ip.industrialProcessing.utils.working;

public class ClientWorker implements IWorker {

	private int totalWork = 0;
	private int workDone = 0; // don't start working when placed

	public boolean doWork(int amount) {
		if (workDone >= 1) {
			workDone += amount;
			if (workDone > totalWork)
				workDone = totalWork+1;
			else
				return true;
		}// else (work <= 0) : still in prepare stage!
		return false;
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
	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}

	@Override
	public void setWorkDone(int workDone) {
		this.workDone = workDone;
	}

	@Override
	public int getScaledProgress(int progressBarWidth) {
		if (totalWork == 0)
			return 0;
		return progressBarWidth * (workDone-1) / totalWork;
	}

	@Override
	public boolean isWorking() {
		return workDone > 1 && workDone <= totalWork;
	}

}
