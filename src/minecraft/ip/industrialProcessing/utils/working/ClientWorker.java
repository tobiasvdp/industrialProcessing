package ip.industrialProcessing.utils.working;
/**
 * Uses the animation handler to sync the animation, no actual work is done on the clients anymore
 *
 */
@Deprecated
public class ClientWorker implements IWorker {

    private int totalWork = 0;
    private int workDone = 0; // don't start working when placed

    public int doWork(int amount) {
	int workDoneInStep = Math.min(amount, totalWork - workDone);
	if (workDone >= 1) {
	    workDone += workDoneInStep;
	}// else (work <= 0) : still in prepare stage!
	return workDoneInStep;
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
	return progressBarWidth * (workDone - 1) / totalWork;
    }

    @Override
    public boolean isWorking() {
	return workDone > 1 && workDone <= totalWork;
    }

	@Override
	public int doWork(int amount, int power) {
		return 0;
	}

}
