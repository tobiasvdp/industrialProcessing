package ip.industrialProcessing.machines;

public interface IPowerStorage {
	int getStoredPower();
	int getPowerCapacity();
	void setStoredPower(int power);
	void setPowerCapacity(int powerCapacity);
}
