package ip.industrialProcessing.subMod.power.plant.creative;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.power.plants.TileEntityGenerator;

public class TileEntityCreativeGenerator extends TileEntityPowerGenerator {

    public TileEntityCreativeGenerator() {
    }

    @Override
    public float getCharge(float amount) {
	return amount;
    }

    @Override
    public float getVoltage() {
	return 100;
    }

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	return true;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

}
