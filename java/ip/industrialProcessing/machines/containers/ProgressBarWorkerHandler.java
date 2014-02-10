package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.utils.working.IWorker;

public class ProgressBarWorkerHandler implements IProgressBarHandler {

	private IWorker worker;

	public ProgressBarWorkerHandler(IWorker worker) {
		this.worker = worker;
	}

	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return this.worker.getWorkDone();
		case 1:
			return this.worker.getTotalWork();
		}
		return 0;
	}

	public static ProgressInfoWorker getInfo(ProgressBarHandlerInfo info)
	{
		ProgressInfoWorker worker = new ProgressInfoWorker();
		int[] values = info.getValueStorage();
		worker.workDone = values[0];
		worker.totalWork = values[1];
		return worker;
	}
}
