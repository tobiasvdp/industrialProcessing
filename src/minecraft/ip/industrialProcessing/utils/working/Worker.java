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

	public boolean doWork(int amount, boolean remote) {
		boolean worked = false;
		if (amount > 0) {
			if (this.workDone == 0) {
				onBeginWork(remote);
			}
			if (hasWork()) {
				if (canWork()) {
					worked = true;
					this.workDone += amount;
					if (this.workDone >= this.totalWork) {
						onEndWork(remote);
					}
				}
			} else {
				this.onWorkCancelled(remote);
			}
		}
		return worked;
	}

	protected void onWorkCancelled(boolean remote) {
		this.handler.workCancelled(remote);
		this.workDone = 0;
	}

	public boolean hasWork() {
		return this.handler.hasWork();
	}

	public boolean canWork() {
		return this.handler.canWork();
	}

	protected void onEndWork(boolean remote) {
		this.handler.workDone(remote);
		this.workDone = 0;
	}

	protected void onBeginWork(boolean remote) {
		this.handler.beginWork(remote);
	}

	public int getProgress() {
		if (this.totalWork == 0)
			return -1;
		return 100 * this.workDone / this.totalWork;
	}

	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setShort("IP.Worker.WorkDone", (short) this.workDone);
		nbt.setShort("IP.Worker.TotalWork", (short) this.totalWork);
	}

	public void readFromNBT(NBTTagCompound nbt) {
		this.workDone = nbt.getShort("IP.Worker.WorkDone");
		this.totalWork = nbt.getShort("IP.Worker.TotalWork");
	}
}
