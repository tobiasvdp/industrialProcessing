package ip.industrialProcessing.api.handlers;

import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerWorker implements IHandlerWorker{

	private IWorker worker;

	public HandlerWorker(IWorker worker) {
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
	
	@Override
	public int[] getValueStorage() {
		int[] value = new int[2];
		value[0] = worker.getWorkDone();
		value[1] = worker.getTotalWork();
		return value;
	}

	public static InfoWorker getInfo(IHandlerWorker handler)
	{
		InfoWorker info = new InfoWorker();
		int[] values = handler.getValueStorage();
		info.workDone = values[0];
		info.totalWork = values[1];
		return info;
	}
}
