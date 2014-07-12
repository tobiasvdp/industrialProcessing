package mod.industrialProcessing.gui.containers.handlers;

import mod.industrialProcessing.work.worker.IWorker;
import mod.industrialProcessing.work.worker.IWorkingEntity;


public class WorkHandler extends ProgressHandlerBase {

    private IWorkingEntity workingEntity;

    public WorkHandler(IWorkingEntity workingEntity) {
	super(1);
	this.workingEntity = workingEntity;
    }

    @Override
    public void readFromEntity() {
	IWorker worker = workingEntity.getWorker();
	int workDone = worker.getWorkDone();
	int totalWork = worker.getTotalWork();
	setValues(workDone, totalWork);
    }

}
