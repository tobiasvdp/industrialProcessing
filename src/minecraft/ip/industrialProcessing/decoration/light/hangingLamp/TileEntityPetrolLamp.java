package ip.industrialProcessing.decoration.light.hangingLamp;

import net.minecraft.nbt.NBTTagCompound;
import ip.industrialProcessing.decoration.light.TileEntityLamp;
import ip.industrialProcessing.machines.TileEntityMachine;

public class TileEntityPetrolLamp extends TileEntityLamp{

    @Override
    public float yOffset() {
	return 0.18F;
    }

    @Override
    public float xzOffset() {
	return 0.18F;
    }
}
