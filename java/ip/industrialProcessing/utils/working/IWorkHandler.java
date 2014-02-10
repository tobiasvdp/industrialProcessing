package ip.industrialProcessing.utils.working;

import net.minecraft.tileentity.TileEntity;

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
	void prepareWork();
	
	/**
	 * this method gets called when the work gets cancelled (input removed)
	 * @param remote 
	 */
	void workCancelled();
	/**
	 * this method gets called when the work is updated
	 * @param remote
	 * @param amount work done in this update tick
	 */
	void workProgressed(int amount);
	/**
	 * called when this method has prepared the work and started working
	 * @param remote
	 */
	void beginWork( );
	/**
	 * gets the tile entity that this worker is bound to, used for synchronization with clients
	 * @return
	 */
	TileEntity getTileEntity();
	
	IWorker getWorker();
}
