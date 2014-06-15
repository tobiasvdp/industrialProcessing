package mod.industrialProcessing.utils.handlers.packet;

public interface IProgressSync {
	public void setValues(int[] val);
	public int[] getValues();
	public int[] getPrevValues();
	public void sendUpdatesifChanged(int[] val, int[] prev);
	public int offsetForSync();
}
