package ip.industrialProcessing.machines;

public interface IPowerStorage {
	int getStoredPower();
	int getPowerCapacity();
	void setStoredPower(int power);
	void setPowerCapacity(int powerCapacity);
	int fillPower(int amount, boolean doFill);
	int drainPower(int amount, boolean doDrain);
}
