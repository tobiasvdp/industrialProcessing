package mod.industrialProcessing.power.network;


public class PowerHelper {

    public static float getResistanceForStorage(IPowerStorage storage) {
        return getResistanceForStorage(storage.getStoredPower(), storage.getPowerCapacity());
    }

    public static float getResistanceForStorage(float storedEnergy, float maxEnergy) {
        float filled = storedEnergy / maxEnergy;

        if (filled >= 1)
            return Float.POSITIVE_INFINITY;
        float ohms = -1 / ((float) Math.log(filled / 10) + 1);
        if (Float.isNaN(ohms))
            return Float.POSITIVE_INFINITY;
        return (ohms + 4) * 0.12f;
    }

    public static float getEnergy(float charge, float voltage) {
        return charge * voltage; // joules = coulomb * volt;
    }

    public static float getCharge(float energy, float voltage) {
        return energy / voltage; // coulomb = energy / volt
    }
}
