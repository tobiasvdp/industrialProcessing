package ip.industrialProcessing.power.buildcraftGenerator;

import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import ip.industrialProcessing.power.TileEntityPowerGenerator;

public class TileEntityBuildcraftGenerator extends TileEntityPowerGenerator implements IPowerReceptor {

    private static final float CONVERSION_RATE = 0.5f; // for every 0.5 BC Joules, one unit of IP Power is generated
    private PowerHandler powerHandler;

    public TileEntityBuildcraftGenerator() { 
	super(100);
	this.powerHandler = new PowerHandler(this, Type.MACHINE);
	this.powerHandler.configure(1, 50, 3, 15000);
	this.powerHandler.configurePowerPerdition(2, 1);
    }

    @Override
    public int producePower(int maxAmount, boolean doProduce) { 
	float max = maxAmount / CONVERSION_RATE;
	float min = max / 2;
	return (int)(this.powerHandler.useEnergy(min, max, doProduce) * CONVERSION_RATE); 
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) { 
	return false;
    }

    @Override
    public PowerReceiver getPowerReceiver(ForgeDirection side) { 
	 return this.powerHandler.getPowerReceiver();
    }

    @Override
    public void doWork(PowerHandler workProvider) { 
    }

    @Override
    public World getWorld() { 
	return this.worldObj;
    }

    @Override
    public boolean canProducePower(ForgeDirection opposite) { 
	return true;
    }

}
