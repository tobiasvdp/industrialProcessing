package mod.industrialProcessing.work.worker;

import net.minecraft.nbt.NBTTagCompound;

public class WorkUtils {

	private static final String WORK_DONE = "IP.work.workDone";
	private static final String TOTAL_WORK = "IP.work.totalWork";
	public static void writeToNBT(IWorker worker, NBTTagCompound nbt) {
		short workDone = (short)worker.getWorkDone();
		short totalWork = (short)worker.getTotalWork();
		nbt.setShort(WORK_DONE, workDone);
		nbt.setShort(TOTAL_WORK, totalWork);
	}
	public static void readFromNBT(IWorker worker, NBTTagCompound nbt) {
		short workDone = nbt.getShort(WORK_DONE);
		short totalWork = nbt.getShort(TOTAL_WORK);
		worker.setWorkDone(workDone);
		worker.setTotalWork(totalWork);
	}

}
