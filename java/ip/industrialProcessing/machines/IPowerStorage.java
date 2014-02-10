package ip.industrialProcessing.machines;

public interface IPowerStorage {
    float getStoredPower();

    float getPowerCapacity();

    void setStoredPower(float power);

    void setPowerCapacity(float powerCapacity);

    float fillPower(float amount, boolean doFill);

    float drainPower(float amount, boolean doDrain);
}
