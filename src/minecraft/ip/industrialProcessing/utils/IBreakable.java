package ip.industrialProcessing.utils;

public interface IBreakable {
	public void SetLiveTime(int time);
	public boolean TickLiveTime();
	public void destroyBlock();
	public int getScaledLiveTime(int scale);
}
