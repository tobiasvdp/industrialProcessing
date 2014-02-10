package ip.industrialProcessing.utils;

public interface IBreakable extends IDurability {
	public boolean TickLiveTime();
	public void destroyBlock();
	public int getScaledLiveTime(int scale);
	public void SetTotalLifeTime(int time);
	public void SetLifeTime(int time);
	
}
