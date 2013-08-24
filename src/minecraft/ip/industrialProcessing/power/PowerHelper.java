package ip.industrialProcessing.power;

public class PowerHelper {
    public static float getResistanceForStorage(float storedEnergy, float maxEnergy) {
	float filled = storedEnergy / maxEnergy;
	if (filled == 1)
	    return Float.POSITIVE_INFINITY;
	float ohms = -1 / (float) Math.log(filled);
	if (Float.isNaN(ohms))
	    return Float.POSITIVE_INFINITY;
	return ohms;
    }
    
    public static float getEnergy(float charge, float voltage)
    {
	return charge * voltage; // joules = coulomb * volt;
    }
    
    public static float getCharge(float energy, float voltage)
    {
	return energy / voltage; // coulomb = energy / volt
    }
}
