package ip.industrialProcessing.utils.working;

public interface IWorkHandler {
	/**
	 * verify if there is work to be done, if not, reset work counter to 0
	 * @return
	 */
	boolean hasWork();
	/**
	 * verify if the work can be completed, if not, pause until it can be
	 * @return
	 */
	boolean canWork();
	/**
	 * this method gets called when the work is done
	 */
	void workDone();
	
	/**
	 * this method gets called when the work begins
	 */
	void beginWork();
}
