package ip.industrialProcessing.power.meters;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAmpMeter extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress {

    LocalDirection inputSide = LocalDirection.BACK;
    LocalDirection outputSide = LocalDirection.UP;

    public TileEntityAmpMeter() {
	super(1000); 
    }
 

    @Override
    public boolean canOutputPower(ForgeDirection opposite) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public float getVoltage() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getAnimationProgress(float scale) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	// TODO Auto-generated method stub
	return false;
    } 

    public void checkConnections() {
	// TODO Auto-generated method stub
	
    } 

    @Override
    public float getCharge(float amount) {
	// TODO Auto-generated method stub
	return 0;
    } 

}
