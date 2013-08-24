package ip.industrialProcessing.power.meters;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityVoltMeter extends TileEntityMachine implements IPowerAcceptor, IAnimationProgress {

    private LocalDirection inputSide = LocalDirection.BACK;
    private float angle; 
    private float volt;
    private int producers;

  
    @Override
    public void updateEntity() {  
    }



    @Override
    public float getAnimationProgress(float scale) { 
	return this.angle;
    }



    @Override
    public float getResistance(ForgeDirection side) { 
	return 10000; // 10MΩ
    }



    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	// DO nothing with the power, as it should be equal or close to 0 Coulomb.
    }
 

    @Override
    public boolean canAcceptPower(ForgeDirection side) { 
	LocalDirection local = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return local == inputSide;
    }



    @Override
    protected boolean isValidInput(int slot, int itemID) { 
	// TODO: input slot for batteries to measure charge
	return false;
    }
    
     

}
