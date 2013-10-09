package ip.industrialProcessing.api.handlers;

import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import ip.industrialProcessing.utils.working.IWorker;

public class HandlerWorker implements IHandlerWorker{

	private IWorker worker;
	private boolean[] hasChanged;
	private int offset;

	public HandlerWorker(IWorker worker) {
		this.worker = worker;
		this.hasChanged = new boolean[getValueCount()];
		for(int i = 0;i<getValueCount();i++){
		    hasChanged[i] = false;
		}
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
		/*InfoWorker info = new InfoWorker();
		int[] values = handler.getValueStorage();
		info.workDone = values[0];
		info.totalWork = values[1];
		return info;*/return null;
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
	    hasChanged[index] = true;
		switch (index) {
		case 0:
			this.worker.setWorkDone(par2);
		case 1:
			this.worker.setTotalWork(par2);
		}
	}

	@Override
	public int getPrevValue(int i) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public void newToOldValues() {
	    // TODO Auto-generated method stub
	    
	}
}
