package mod.industrialProcessing.power;

public class PowerWorkerHelper {

    public final static int DEFAULT_WORK_SPEED = 100;

    public static int getWork(float capacity, float storage, int maxWorkSpeed) {
        // change the work speed depending on the amount of power available,
        // more power = faster work = faster drain
        return (int) Math.floor(Math.min(storage, maxWorkSpeed));
    }

    public static int getWork(IPowerStorage storage, int maxWorkSpeed) {
        return getWork(storage.getPowerCapacity(), storage.getStoredPower(), maxWorkSpeed);
    }

    public static int acceptPower(int capacity, int storage, int maxAmount) {

        int drain = (capacity - storage) * maxAmount / capacity;
        return drain;
        // return Math.min(capacity - storage, maxAmount);
    }
}
