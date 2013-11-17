package ip.industrialProcessing.api.handlers;

import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.api.info.InfoWorker;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerWorker implements IHandlerWorker{

	private IWorker worker;
	private InfoWorker prevInfo;
	private int offset;

	public HandlerWorker(IWorker worker) {
		this.worker = worker;
		prevInfo = new InfoWorker();
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


	public static InfoWorker getInfo(IHandlerWorker handler)
	{
		InfoWorker workerInfo = new InfoWorker();
		workerInfo.workDone = handler.getValue(0);
		workerInfo.totalWork = handler.getValue(1);
		return workerInfo;
	}
	@Override
	public int getIndexOffset() {
	    return this.offset;
	}

	@Override
	public void setIndexOffset(int offset) {
	    this.offset = offset;
	}

	@Override
	public void put(int index, int par2) {
		switch (index) {
		case 0:
			this.worker.setWorkDone(par2);break;
		case 1:
			this.worker.setTotalWork(par2);break;
		}
	}

	@Override
	public int getPrevValue(int i) {
		switch (i) {
		case 0:
		    return prevInfo.workDone;
		case 1:
		    return prevInfo.totalWork;
		}
		return 0;
	}

	@Override
	public void newToOldValues() {
		prevInfo.totalWork = worker.getTotalWork();
		prevInfo.workDone = worker.getWorkDone();
	}

	@Override
	public void resetPrevValue() {
		prevInfo = new InfoWorker();
	}
}
