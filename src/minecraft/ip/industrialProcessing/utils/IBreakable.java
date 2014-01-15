package ip.industrialProcessing.utils;

public interface IBreakable {
	public boolean TickLiveTime();
	public void destroyBlock();
	public int getScaledLiveTime(int scale);
	public int getTotalLifetime();
	public void SetTotalLifeTime(int time);
	public int getLifetime();
	public void SetLifeTime(int time);
	
}
