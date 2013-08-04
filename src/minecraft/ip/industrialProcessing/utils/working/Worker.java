package ip.industrialProcessing.utils.working;

import net.minecraft.nbt.NBTTagCompound;

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

	protected void onBeginWork() {
		this.handler.beginWork();
	}

	public int getProgress() {
		if(this.totalWork == 0) return -1;
		return 100 * this.workDone / this.totalWork;
	}

	public void writeToNBT(NBTTagCompound nbt) {
		this.workDone = nbt.getShort("IP.Worker.WorkDone");
		this.totalWork = nbt.getShort("IP.Worker.TotalWork");
	}

	public void readFromNBT(NBTTagCompound nbt) {
		nbt.setShort("IP.Worker.WorkDone", (short)this.workDone);
		nbt.setShort("IP.Worker.TotalWork", (short)this.totalWork);		
	}
}
